import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class GraphPanel extends JPanel {

    private final GraphFrame frame;
    private Function<Double,Double> graphFunction;


    public GraphPanel(GraphFrame frame, Function<Double,Double> graphFunction) {

        this.frame = frame;
        this.graphFunction = graphFunction;
    }

    @Override
    protected void paintComponent(Graphics g) {

        // create Graphics2D object to be able to draw on the panel
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        Dimension frameSize = frame.getSize(); // gets the current size of the frame, used for scaling

        // evaluate and draw the function
        for (double x = -100; x <= 100; x += 0.3) {
            double y = -1*graphFunction.apply(x);
            g2.drawOval((int)((frameSize.width/2 - 0.02*frameSize.width) + 0.014*frameSize.width*x), (int)(0.90*frameSize.height + 0.001*frameSize.height*y), 5, 5);
        }
    }

}
