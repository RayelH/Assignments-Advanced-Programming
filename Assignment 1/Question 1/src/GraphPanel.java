import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

/**
 * This class represents the panel that contains the graph.
 */
public class GraphPanel extends JPanel {

    private final GraphFrame frame;
    private Function<Double,Double> graphFunction;

    /**
     * Constructor for the GraphPanel class.
     *
     * @param  frame the frame that is used to display the panel.
     * @param  graphFunction the function that needs to be drawn on the panel.
     */
    public GraphPanel(GraphFrame frame, Function<Double,Double> graphFunction) {

        this.frame = frame;
        this.graphFunction = graphFunction;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Dimension frameSize = frame.getSize(); // gets the current Dimension of the frame, used for scaling

        final double X_SCALING_FACTOR = 0.014*frameSize.width;  // scaling for the x-axis
        final double Y_SCALING_FACTOR = 0.001*frameSize.height; // scaling for the y-axis
        final double BOTTOM_MARGIN = 0.90*frameSize.height;     // margin at the bottom of the frame

        double startPoint = -100;  // start of the domain which we want to plot
        double endPoint = 100;     // end of the domain which we want to plot
        double stepSize = 0.3;     // the step size of the x value in the domain, determines the amount of evaluations done
        int ovalWidth = 5;
        int ovalHeight = 5;

        // create Graphics2D object to be able to draw on the panel
        Graphics2D gDraw = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gDraw.setRenderingHints(rh);

        // evaluate and draw the function
        for (double x = startPoint; x <= endPoint; x += stepSize) {

            // evaluate function, JFrame counts height(y-axis) from top to bottom, so multiply by -1 to get a "normal" y-axis
            double y = -1*graphFunction.apply(x);

            gDraw.drawOval((int)((frameSize.width/2) + X_SCALING_FACTOR*x), (int)(BOTTOM_MARGIN + Y_SCALING_FACTOR*y), ovalWidth, ovalHeight);
        }
    }
}
