public class Node {

    private String data;
    private Node left;
    private Node right;

    Node(String data) {
        this.data = data;
        right = null;
        left = null;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right ) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }
}
