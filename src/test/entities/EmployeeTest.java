package test.entities;

import app.entities.Employee;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void dateTest() {

        Employee e = new Employee();
        LocalDate actualDate = e.getBirthDate();

        assertNull(actualDate);
    }

    @Test
    public void dateTest_2() {

        //expected
        LocalDate expectedDate = LocalDate.of(2000, 2, 2);

        // actual
        LocalDate testDate = LocalDate.of(2000, 2, 2);
        Employee e = new Employee("Marko", "Jurić", testDate, "mmmm");

        assertEquals(expectedDate, e.getBirthDate());
    }

    @Test
    public void dateSetTest_1() {

        //expected
        LocalDate expectedDate = LocalDate.of(2000, 2, 2);

        // actual
        LocalDate testDate = LocalDate.of(2000, 2, 2);
        Employee e = new Employee();
        e.setBirthDate(testDate);

        // assert
        assertEquals(expectedDate, e.getBirthDate());
    }

    @Test
    public void dateSetTest_2() {

        //expected
        LocalDate expectedDate = LocalDate.of(2000, 2, 2);

        // actual
        Date testDate = Date.valueOf("2000-2-2");
        Employee e = new Employee();
        e.setBirthDate(testDate);

        // assert
        assertEquals(expectedDate, e.getBirthDate());
    }
}