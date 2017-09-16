import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a window for a WelcomeActivity.
 */
public class WelcomeActivity extends Activity {

    private static JFrame welcomeFrame = new JFrame();
    private static final Dimension INITIAL_WINDOW_SIZE = new Dimension(400, 250);

    /**
     * Constructor for the LoginActivity class.
     *
     * @param username the username of the user which has successfully logged in.
     */
    public WelcomeActivity(String username) {

        super(welcomeFrame, "Welcome", INITIAL_WINDOW_SIZE);
        WelcomeClickListener eventListener = new WelcomeClickListener();
        addLabel("Hello " +  username + ", how are you today?", 0, 0, 3);
        addButton("exit", 1, 1, 1, eventListener);
        welcomeFrame.setVisible(true);

    }

    /**
     * This class is an ActionListener for ClickEvents in a WelcomeActivity.
     */
    public class WelcomeClickListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            switch (event.getActionCommand()) {
                case "exit":
                    welcomeFrame.dispose();
                    break;
            }

        }

    }
}