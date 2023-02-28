package test.data;

import app.data.DataAccess;
import app.data.DataQuery;
import app.entities.Administrator;
import app.entities.Employee;
import app.entities.exceptions.UserNotExistException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataQueryTest {


    // --- Employee tests ---
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
        assertThrows(UserNotExistException.class, ()-> {
            Employee e = query.getEmployee(212323, "jure");
        });
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


    // --- Administrator tests ---
    @Test
    public void adminNotNullTest() throws SQLException, ClassNotFoundException, UserNotExistException {
        DataAccess dataAccess = new DataAccess();
        DataQuery query = new DataQuery(dataAccess);
        Administrator admin = query.getAdministrator(123321, "fabo0701");
        assertNotNull(admin);
    }

    @Test
    public void adminDoesenNotExistTest() throws SQLException, ClassNotFoundException, UserNotExistException {
        DataAccess dataAccess = new DataAccess();
        DataQuery query = new DataQuery(dataAccess);

        assertThrows(UserNotExistException.class, (Executable) query.getAdministrator(123, "23123"));
    }

    @Test
    public void rightAdministratorTest() throws SQLException, ClassNotFoundException, UserNotExistException {

        //expected
        int expectedUserId = 123321;
        String expectedAccessKey = "fabo0701";

        //Database connection objects
        DataAccess dataAccess = new DataAccess();
        DataQuery query = new DataQuery(dataAccess);

        //Getting actual values
        Administrator admin = query.getAdministrator(expectedUserId, expectedAccessKey);

        // Test assert statements
        assertEquals(expectedUserId, admin.getId());
        assertEquals(expectedAccessKey, admin.getAccessKey());
    }
}