package test.gui;

import app.Mode;
import app.entities.Employee;
import app.gui.LoginFrame;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LoginFrameTest {

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


    public Method get_doLogin_method() throws NoSuchMethodException {
        Method method = LoginFrame.class.getDeclaredMethod(
                "doLogin", String.class, String.class
        );
        method.setAccessible(true);
        return method;
    }

    @Test
    public void doLoginReturnsEmployeeTest()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = get_doLogin_method();
        Employee actualEmployee = (Employee) method.invoke(
                new LoginFrame(),
                new Object[] { "212323", "jure3344" }
        );

        assertNotNull(actualEmployee);
    }

    @Test
    public void doLoginThrowsParsingExceptionTest()
            throws NoSuchMethodException{

        Method method = get_doLogin_method();

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

    @Test
    public void doLoginDoesNotReturnUserTest()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = get_doLogin_method();
        Employee employee = (Employee) method.invoke(
                new LoginFrame(),
                new Object[] { "22222", "jjjjjj" }
        );

        assertNull(employee);
    }
}