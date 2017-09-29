/**
 * @author Preidun Andkhuiy
 * This class creates a node containing data and two children nodes.
 * You can put anything you like as the actual data in the node, and
 * can assume that either each node always has two children or no children (true or false)
 */
class p2 {
    /**
     * These are the variables a Tree object can have
     */
    private int data;
    private String name;

    /**
     * This constructor constructs a node with name and data and labels whether it has children
     *
     * @param children A boolean variable which indicates if this node has children
     * @param nodeData an Integer which represents the data of this node
     * @param nameNode a String which is the name of this node
     */
    public Node(int nodeData, String nameNode) {
        data = nodeData;
        name = nameNode;
    }

    /**
     * This method prints the name of the node with corresponding data
     */
    public void printNodeData() {
        System.out.println(name + ": " + data);
    }
}
