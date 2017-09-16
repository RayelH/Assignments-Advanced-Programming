import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a window for a LoginActivity.
 */
public class LoginActivity extends Activity {


    private static JFrame loginFrame = new JFrame();
    private static final Dimension INITIAL_WINDOW_SIZE = new Dimension(400, 250);

    /**
     * Constructor for the LoginActivity class.
     */
    public LoginActivity() {
        super(loginFrame, "login", INITIAL_WINDOW_SIZE);
        LoginClickListener eventListener = new LoginClickListener();
        addTextField(20, 1, 0, 3, 0);
        addTextField(20, 1, 1, 3, 1);
        addLabel("username: ", 0, 0, 1);
        addLabel("password: ", 0, 1, 1);
        addButton("login", 1, 2, 1, eventListener);
        addButton("exit", 2, 2, 1, eventListener);
        loginFrame.setVisible(true);

    }

    public static void main(String[] args) {

        Activity loginWindow = new LoginActivity();

    }

    /**
     * This class is an ActionListener for ClickEvents in a LoginActivity.
     */
    public class LoginClickListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "login":
                    // if username and password are correct, close current window and create an instance of WelcomeActivity
                    if (getTextField(0).getText().equals("username") && getTextField(1).getText().equals("password")) {

                        String username = getTextField(0).getText();
                        loginFrame.dispose();
                        WelcomeActivity welcomeWindow = new WelcomeActivity(username);

                    } else {

                       addLabel("Username or password incorrect, please try again.", 0, 3, 4);
                       loginFrame.setVisible(true);
                    }
                    break;

                case "exit":
                    loginFrame.dispose();
                    break;
            }
        }

    }


}
