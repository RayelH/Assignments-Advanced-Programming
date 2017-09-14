import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

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

        double startPoint = -100; // start of the domain which we want to plot
        double endPoint = 100;    // end of the domain which we want to plot
        double stepSize = 0.3;    // the step size of the x value in the domain, determines the amount of evaluations done

        // create Graphics2D object to be able to draw on the panel
        Graphics2D gDraw = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gDraw.setRenderingHints(rh);

        Dimension frameSize = frame.getSize(); // gets the current size of the frame, used for scaling

        // evaluate and draw the function
        for (double x = startPoint; x <= endPoint; x += stepSize) {

            // evaluate function, JFrame counts height(y-axis) from top to bottom, so multiply by -1 to get a "normal" y-axis
            double y = -1*graphFunction.apply(x);

            gDraw.drawOval((int)((frameSize.width/2 - 0.02*frameSize.width) + 0.014*frameSize.width*x), (int)(0.90*frameSize.height + 0.001*frameSize.height*y), 5, 5);
        }
    }

}
