package test.app;

import app.Application;
import app.Mode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    public void mode_test1() {
        Application app = new Application(Mode.USER);

        Mode actualMode = app.getMode();
        Mode expectedMode = Mode.USER;

        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void mode_test2() {
        Application app = new Application(Mode.ADMINISTRATOR);
        app.setMode(Mode.USER);

        Mode expectedMode = Mode.USER;
        Mode actualMode = app.getMode();

        assertEquals(expectedMode, actualMode);
    }

}