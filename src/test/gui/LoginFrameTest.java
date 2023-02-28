package test.gui;

import app.Mode;
import app.entities.Administrator;
import app.entities.Employee;
import app.gui.LoginFrame;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LoginFrameTest {

    // === Universal ===
    @Test
    public void nullModeReturnTest() {

        // null expected

        // actual
        LoginFrame frame = new LoginFrame();
        Mode actualMode = frame.getApplicationMode();

        // assertion
        assertNull(actualMode);
    }

    @Test
    public void modeGetSetTest() {
        // expected
        Mode expectedMode = Mode.USER;

        // actual
        LoginFrame frame = new LoginFrame();
        frame.setApplicationMode(Mode.USER);
        Mode actualMode = frame.getApplicationMode();

        // assertion
        assertEquals(expectedMode, actualMode);
    }


    // ===== Employee =====
    @Test
    public void doLoginThrowsParsingExceptionTest()
            throws NoSuchMethodException{

        Method method = get_doEmployeeLogin_method();

        Exception e = assertThrows(
                InvocationTargetException.class,
                () -> {
                    Employee employee = (Employee) method.invoke(
                            new LoginFrame(),
                            new Object[] { "", "jure3344" }
                    );
                });
        assertEquals(e.getMessage(), new NumberFormatException().getMessage());
    }


    public Method get_doEmployeeLogin_method() throws NoSuchMethodException {
        Method method = LoginFrame.class.getDeclaredMethod(
                "doEmployeeLogin", String.class, String.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    public void doLoginReturnsEmployeeTest()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // expected
        String expectedIdInput = "212323";
        String expectedPasswordInput = "jure3344";

        // actual
        Method method = get_doEmployeeLogin_method();
        Employee actualEmployee = (Employee) method.invoke(
                new LoginFrame(),
                new Object[] { expectedIdInput, expectedPasswordInput }
        );

        // assertions
        assertNotNull(actualEmployee);
        assertEquals(Integer.parseInt(expectedIdInput), actualEmployee.getId());
        assertEquals(expectedPasswordInput, actualEmployee.getAccessKey());
    }

    @Test
    public void doLoginDoesNotReturnEmployeeTest()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = get_doEmployeeLogin_method();
        Employee employee = (Employee) method.invoke(
                new LoginFrame(),
                new Object[] { "22222", "jjjjjj" }
        );

        assertNull(employee);
    }


    // ===== Administrator =====
    public Method get_doAdministratorLogin_method() throws NoSuchMethodException {
        Method method = LoginFrame.class.getDeclaredMethod(
                "doAdministratorLogin", String.class, String.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    void doLoginReturnsAdministratorTest()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // expected
        String adminIdInput = "123321";
        String adminPasswordInput = "fabo0701";

        // actual
        Method method = get_doAdministratorLogin_method();
        Administrator testAdmin = (Administrator) method.invoke(
                new LoginFrame(),
                new Object[]{adminIdInput, adminPasswordInput}
        );

        // test cases
        assertNotNull(testAdmin);
        assertEquals(Integer.parseInt(adminIdInput), testAdmin.getId());
        assertEquals(adminPasswordInput, testAdmin.getAccessKey());
    }

    @Test
    void doLoginDoesNotReturnAdministratorTest()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // expected
        String adminIdInput = "123321";
        String adminPasswordInput = "x";

        // actual
        Method method = get_doAdministratorLogin_method();
        Administrator testAdmin = (Administrator) method.invoke(
                new LoginFrame(),
                new Object[]{adminIdInput, adminPasswordInput}
        );

        // test cases
        assertNull(testAdmin);
    }


}














