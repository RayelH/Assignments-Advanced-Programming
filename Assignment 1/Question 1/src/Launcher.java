/**
 * This class lanches the application that shows the graph
 */
public class Launcher {

    public static void main(String[] args) {

        GraphFrame frame = new GraphFrame("plot of y = x^2");

        // add a panel to the frame to draw the function on
        frame.add(new GraphPanel(frame, x -> Math.pow(x,2)));

        frame.setVisible(true);
    }

}
