import java.util.ArrayList;

/**
 * This class represents a Tree, on which Nodes can be added.
 */
public class Tree {

    private static Node root;
    private ArrayList<Node> Nodes;

    public static void main(String[] args) {

        // create a Tree
        Tree binaryTree = new Tree("A");

        // add Nodes
        Node nodeB = new Node("B");
        binaryTree.addNode(nodeB, root, "left");
        Node nodeC = new Node("C");
        binaryTree.addNode(nodeC, nodeB, "left");
        Node nodeD = new Node("D");
        binaryTree.addNode(nodeD, nodeC, "left");
        Node nodeE = new Node("E");
        binaryTree.addNode(nodeE, nodeC, "right");
        Node nodeF = new Node("F");
        binaryTree.addNode(nodeF, nodeB, "right");
        Node nodeG = new Node("G");
        binaryTree.addNode(nodeG, nodeF, "left");
        Node nodeH = new Node("H");
        binaryTree.addNode(nodeH, nodeF, "right");
        Node nodeI = new Node("I");
        binaryTree.addNode(nodeI, root, "right");
        Node nodeJ = new Node("J");
        binaryTree.addNode(nodeJ, nodeI, "left");
        Node nodeK = new Node("K");
        binaryTree.addNode(nodeK, nodeJ, "left");
        Node nodeL = new Node("L");
        binaryTree.addNode(nodeL, nodeJ, "right");
        Node nodeM = new Node("M");
        binaryTree.addNode(nodeM, nodeI, "right");
        Node nodeN = new Node("N");
        binaryTree.addNode(nodeN, nodeM, "left");
        Node nodeO = new Node("O");
        binaryTree.addNode(nodeO, nodeM, "right");

        // Print the Tree
        binaryTree.printTree();


    }

    /**
     * Constructor for the Tree class.
     *
     * @param rootData the data that te root contains.
     */
    public Tree(String rootData) {

        root = new Node(rootData);
        Nodes = new ArrayList<>();
        Nodes.add(root);

    }

    /**
     * Method for adding a node to the tree.
     *
     * @param thisNode the Node that should be added.
     * @param parent   the parent of the Node that should be added.
     * @param place    the place of the Node, which can be either left or right.
     */
    public void addNode(Node thisNode, Node parent, String place) {

        Nodes.add(thisNode); // add Nodes to an ArrayList in case you want to access them later on

        if (place.equals("left")) {

            parent.setLeft(thisNode);

        } else {

            parent.setRight(thisNode);
        }
    }

    /**
     * Method for printing the tree.
     */
    public void printTree() {
        printTree(root, 0);
    }

    /**
     * Helper method for printing the tree. This method gets called in printTree().
     *
     * @param node         the node that should be printed.
     * @param depthCounter a counter to keep track off how deep the current node is in the tree.
     */
    public void printTree(Node node, int depthCounter) {

        if (node != null) {

            for (int i = 0; i < depthCounter; i++) {
                System.out.print("|----");
            }

            System.out.println(node.getData());

            // increase depthCounter as we go deeper in the Tree
            depthCounter++;
            printTree(node.getLeft(), depthCounter);
            printTree(node.getRight(), depthCounter);
        }
    }
}






