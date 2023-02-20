package app;


public class Application {
    private Mode mode;
    public Mode getMode() {
        return mode;
    }
    public void setMode(Mode mode) { this.mode = mode;
    }

    public Application(Mode mode) {
        setMode(mode);
    }
}
