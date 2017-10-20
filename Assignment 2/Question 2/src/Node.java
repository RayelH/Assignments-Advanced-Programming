/**
 * This class represents a Node that can be added to a tree.
 */
public class Node {

    private String data;
    private Node left;
    private Node right;

    /**
     * Constructor for the Node class.
     *
     * @param data the data that the Node contains.
     */
    Node(String data) {

        this.data = data;
        right = null;
        left = null;
    }

    /**
     * Method for changing the data of the Node
     *
     * @param data the data that the Node contains.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Method for getting the data of the Node
     */
    public String getData() {
        return data;
    }

    /**
     * Method for changing the left child of the Node
     *
     * @param left the left child of the Node.
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Method for getting the left child of the Node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Method for changing the right child of the Node
     *
     * @param right the right child of the Node.
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Method for getting the right child of the Node
     */
    public Node getRight() {
        return right;
    }
}
