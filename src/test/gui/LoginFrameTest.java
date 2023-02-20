package test.gui;

import app.Mode;
import app.gui.LoginFrame;
import org.junit.jupiter.api.Test;

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
}