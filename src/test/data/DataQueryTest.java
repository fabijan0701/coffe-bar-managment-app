package test.data;

import app.data.DataAccess;
import app.data.DataQuery;
import app.entities.Employee;
import app.entities.exceptions.UserNotExistException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataQueryTest {

    @Test
    public void employeeNotNullTest() throws SQLException, ClassNotFoundException, UserNotExistException {
        DataAccess dataAccess = new DataAccess();
        DataQuery query = new DataQuery(dataAccess);
        Employee e = query.getEmployee(212323, "jure3344");
        assertNotNull(e);
    }

    @Test
    public void employeeDoesenNotExistsTest() {
        DataAccess dataAccess = new DataAccess();
        DataQuery query = new DataQuery(dataAccess);

        // User with the test password does not exist
        Exception acException = assertThrows(UserNotExistException.class, ()-> {
            Employee e = query.getEmployee(212323, "jure");
        });
        assertEquals(acException.getMessage(), new UserNotExistException().getMessage());
    }

    @Test
    public void getEmployeeTest() throws SQLException, ClassNotFoundException, UserNotExistException {

        // expected
        String firstName = "Jure";

        // actual
        DataAccess dataAccess = new DataAccess();
        DataQuery query = new DataQuery(dataAccess);
        Employee e = query.getEmployee(212323, "jure3344");

        //assert
        assertEquals(firstName, e.getFirstName());
    }

}