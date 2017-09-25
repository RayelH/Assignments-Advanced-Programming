import java.util.ArrayList;

/**
 * @author Preidun Andkhuiy
 * This class represents a binary tree of a general depth.
 * You can put anything you like as the actual data in the node, and
 * can assume that each node always has two children.
 */
public class Tree {
    /**
     * These are the variables a Tree object can have
     */
    private int depth;
    private ArrayList<Node> nodes;


    /**
     * This main method tests the class Tree by creating an instance tree
     */
    public static void main(String[] args) {
        final int height = 3;
        Tree myTree = new Tree(height);
        myTree.addNode("A", 500);
        myTree.addNode("B", 200);
        myTree.addNode("C", 550);
        myTree.addNode("D", 70);
        myTree.addNode("E", 540);
        myTree.addNode("F", 60);
        myTree.addNode("G", 330);
        myTree.addNode("H", 80);
        myTree.addNode("I", 480);
        myTree.addNode("J", 280);
        myTree.addNode("k", 50);
        myTree.addNode("l", 680);
        myTree.addNode("M", 30);
        myTree.addNode("N", 80);
        myTree.addNode("O", 770);
        myTree.printTree();
    }

    /**
     * This constructor initializes the instance variables
     *
     * @param heighTree an Integer which represents the height of a Tree object
     */
    public Tree(int heightTree) {
        depth = heightTree;

        nodes = new ArrayList<Node>();
    }

    /**
     * This method constructs a node and it adds to the tree with length specified in the constructor
     * If the tree is full (if all possible nodes created) then a warning is printed.
     * !!note!!: This method adds the nodes in a specific order.
     * The nodes are added in a recursive way: For every node the child to the right
     * is first than the left child is second.
     *
     * @param nameNode A String which represents the name of the node
     * @param nodeData An Integer which is the corresponding data of the node
     */
    public void addNode(String nameNode, int nodeData) {
        if (nodes.size() < (Math.pow(2, depth + 1)) - 1) // A binary tree of depth of n has 2^(n+1) - 1 nodes
        {
            Node node = new Node(nodeData, nameNode);
            nodes.add(node);
        } else {
            System.out.println("The binary tree is full, you can't add anymore nodes.");
        }
    }

    /**
     * This method prints the tree with depth specified in the constructor
     * This method calls the recursive helper method printTree
     */
    public void printTree() {
        if (nodes.size() < Math.pow(2, depth + 1) - 1) // If the Tree is not full we cannot print tree
        {
            System.out.println("The binary tree is not complete yet , add more nodes to be able to print the tree!.");
        } else {
            printTree(0, depth);
        }
    }

    /**
     * This recursive helper method prints the binary tree
     *
     * @param nodeIndex  an Integer which we use as a parameter variable
     *                   to get the index of the node list
     * @param depthIndex also an Integer which keeps track of the level of the binary tree
     */
    public void printTree(int nodeIndex, int depthIndex) {
        if (depthIndex == 0) {
            for (int x = 0; x < depth - depthIndex; x++) {
                System.out.print("|----");
            }
            nodes.get(nodeIndex).printNodeData();
        } else {
            for (int x = 0; x < depth - depthIndex; x++) {
                System.out.print("|----");
            }
            nodes.get(nodeIndex).printNodeData();
            printTree(nodeIndex + 1, depthIndex - 1);   // go to the right child
            printTree(nodeIndex + (int) (Math.pow(2, depthIndex)), depthIndex - 1); // go to the left child
        }
    }
}

