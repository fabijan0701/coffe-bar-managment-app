package app;


import app.gui.LoginFrame;

public class Application implements Runnable{
    private Mode mode;
    public Mode getMode() {
        return mode;
    }
    public void setMode(Mode mode) { this.mode = mode;
    }

    public Application(Mode mode) {
        setMode(mode);
    }

    @Override
    public void run() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
