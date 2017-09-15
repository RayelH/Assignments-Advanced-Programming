import javax.swing.*;
import java.awt.*;

public class LoginActivity extends JFrame {

    private JPanel LoginPanel = new JPanel(new GridBagLayout());
    GridBagConstraints cst = new GridBagConstraints();
    private final Dimension INITIAL_WINDOW_SIZE = new Dimension(500,500);

    public LoginActivity(){
        setTitle("Login");
        setSize(INITIAL_WINDOW_SIZE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        JLabel username = new JLabel("username: ");
        JLabel password = new JLabel("password: ");
        JTextField usernameField = new JTextField(15);
        JTextField passField = new JTextField(15);
        JButton login = new JButton("Login");
        JButton exit = new JButton("Exit");

        cst.insets = new Insets(3, 3, 3, 3);

        addComponent(username, 0, 0);
        addComponent(password, 0, 1);
        addComponent(usernameField, 1, 0, 3);
        addComponent(passField, 1, 1, 3);
        addComponent(login, 2, 2);
        addComponent(exit, 3, 2);
        add(LoginPanel);

    }

    public void addComponent(JComponent comp, int gridx, int gridy, int gridwidth){

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridwidth = gridwidth;
        cst.gridx = gridx;
        cst.gridy = gridy;
        LoginPanel.add(comp, cst);

    }

    public void addComponent(JComponent comp, int gridx, int gridy){
        addComponent(comp, gridx, gridy, 1);
    }
}
