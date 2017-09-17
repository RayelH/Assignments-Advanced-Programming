import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class serves as a window manager for creation of a window, placements of UI components and layout management.
 */
public class Activity {

    private JFrame frame;
    private JPanel panel = new JPanel(new GridBagLayout());
    private ArrayList<JTextField> allTextFields = new ArrayList<>();

    /**
     * Constructor for the Activity class.
     *
     * @param frame      the frame on which the pannel should be added to.
     * @param title      the title of the frame.
     * @param windowSize the size of the window that is created.
     */
    public Activity(JFrame frame, String title, Dimension windowSize) {

        this.frame = frame;
        frame.setTitle(title);
        frame.setSize(windowSize);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(panel);
    }

    /**
     * Adds a button to the panel.
     *
     * @param name      the name of the button.
     * @param gridx     the x-coordinate of the grid in the GridBagLayout on which the button should be displayed.
     * @param gridy     the y-coordinate of the grid in the GridBagLayout on which the button should be displayed.
     * @param gridwidth the width of the button, measured in number of grids.
     * @param listener  the ActionListener used for the buttons' actions.
     */
    public void addButton(String name, int gridx, int gridy, int gridwidth, ActionListener listener) {

        JButton button = new JButton(name);
        GridBagConstraints cst = new GridBagConstraints();
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.insets = new Insets(5, 5, 5, 5);
        cst.gridwidth = gridwidth;
        cst.gridx = gridx;
        cst.gridy = gridy;
        panel.add(button, cst);
        button.setActionCommand(name);
        button.addActionListener(listener);
    }

    /**
     * Adds a label to the panel.
     *
     * @param content   the content of the label.
     * @param gridx     the x-coordinate of the grid in the GridBagLayout on which the button should be displayed.
     * @param gridy     the y-coordinate of the grid in the GridBagLayout on which the button should be displayed.
     * @param gridwidth the width of the button, measured in number of grids.
     */
    public void addLabel(String content, int gridx, int gridy, int gridwidth) {

        JLabel label = new JLabel(content);
        GridBagConstraints cst = new GridBagConstraints();
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.insets = new Insets(5, 5, 5, 5);
        cst.gridwidth = gridwidth;
        cst.gridx = gridx;
        cst.gridy = gridy;
        panel.add(label, cst);
    }

    /**
     * Adds a textfield to the panel.
     *
     * @param length    the number of visible columns for the textfield.
     * @param gridx     the x-coordinate of the grid in the GridBagLayout on which the button should be displayed.
     * @param gridy     the y-coordinate of the grid in the GridBagLayout on which the button should be displayed.
     * @param gridwidth the width of the button, measured in number of grids.
     * @param ID        the ID of the textfield.
     */
    public void addTextField(int length, int gridx, int gridy, int gridwidth, int ID) {

        JTextField textfield = new JTextField(length);
        GridBagConstraints cst = new GridBagConstraints();
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.insets = new Insets(5, 5, 5, 5);
        cst.gridwidth = gridwidth;
        cst.gridx = gridx;
        cst.gridy = gridy;
        panel.add(textfield, cst);
        allTextFields.add(textfield);
    }

    /**
     * Returns a textfield based on its ID.
     *
     * @param ID the ID of the textfield.
     */
    public JTextField getTextField(int ID) {

        return allTextFields.get(ID);
    }


}
