public class BSTNode {
    // storing int value instance variable and Node next
    public int value;
    public BSTNode left;
    public BSTNode right;

    // constructor to create a new node with a value
    public BSTNode(int value) {
        this.value = value;
    }

    public BSTNode() {
    }

    public int getValue() {
        return value;
    }
}
