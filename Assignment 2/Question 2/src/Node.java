public class Node {



    // https://stackoverflow.com/questions/20731833/constructing-a-binary-tree-in-java
    private int id;
    private int parent_id;
    private int leftChild_id;
    private int rightChild_id;
    private int data;

    public Node(int id, int parent_id, int leftChild_id, int rightChild_id, int data) {

        this.id = id;
        this.parent_id = parent_id;
        this.leftChild_id = leftChild_id;
        this.rightChild_id = rightChild_id;
        this.data = data;
    }
}
