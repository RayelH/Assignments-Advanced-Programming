import javax.swing.*;
import java.awt.*;

public class GraphFrame extends JFrame {

    private static final Dimension INITIAL_WINDOW_SIZE = new Dimension(500, 500);

    /**
     * Constructor for the GraphFrame class.
     *
     * @param  title the title of the frame.
     */
    public GraphFrame(String title) {

        // set parameters for the appearance of the frame
        setTitle(title);
        setSize(INITIAL_WINDOW_SIZE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
    }

}
