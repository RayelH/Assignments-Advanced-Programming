import java.util.ArrayList;

public class Tree {

    private static Node root;
    private ArrayList<Node> Nodes = new ArrayList<Node>();


    public static void main(String[] args){

        Tree binaryTree = new Tree("A");

        Node nodeB = new Node("B");
        binaryTree.addNode(nodeB, root, "left");
        Node nodeC = new Node("C");
        binaryTree.addNode(nodeC, root, "right");
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


    }

    public Tree(String data){

        root = new Node(data);
        Nodes.add(root);

    }

    public void addNode(Node thisNode, Node parent, String place){

        Nodes.add(thisNode);

        if (place.equals("left")){

            parent.setLeft(thisNode);

        } else {

            parent.setRight(thisNode);
        }
    }

    public void printNode(Node node){

        System.out.println((node.equals(root)) ? node.getData() : ("|----" + node.getData()));
    }

    public void printTree(){



    }





}
