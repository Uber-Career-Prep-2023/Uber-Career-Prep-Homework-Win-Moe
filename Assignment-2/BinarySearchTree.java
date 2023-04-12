import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    /** NODE class for BST with prev and next attributes
     *
     */
    public static class Node {
        // storing int value instance variable and Node next
        private int value;
        private Node left;
        private Node right;

        // constructor to create a new node with a value
        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    /** END OF NODE CLASS */

    // instance variable for head
    private Node head;

    // constructor
    public BinarySearchTree(Node head) {
        this.head = head;
    }

    // returns the minimum value in the BST
    int min() {
        return 0;
    }

    // returns the maximum value in the BST
    int max() {
        return 0;
    }

    // returns a boolean indicating whether val is present in the BST

    boolean contains(int val) {
        // pointer moves through left or right depending on value and pointer's value
        Node pointer = head;
        while (pointer != null) {
            if (pointer.value == val) {
                return true;
            } else if (val > pointer.value) {
                // if the value is greater, then search the right tree
                pointer = pointer.right;
            } else {
                // if value is lesser, search the left tree
                pointer = pointer.left;
            }
        }
        return false;
    }

    // creates a new Node with data val in the appropriate location
    // For simplicity, do not allow duplicates. If val is already present, insert is a no-op
    void insert(int val) {
        // pointer checks where to put depending on BST rules
        // if val > pointer, go until null, set pointer's right to the new node
        Node newNode = new Node(val);
        Node pointer = head;

        // store the last node to pick pointer's location
        Node lastNode = null;

        while (pointer != null) {
            lastNode = pointer;
            if (pointer.value == val) {
                // do not add duplicates for simplicity
                return;
            } else if (val > pointer.value) {
                // set pointer to the right
                pointer = pointer.right;
            } else {
                pointer = pointer.left;
            }
        }

        // check lastNode to see if put on RIGHT
        if (val > lastNode.value) {
            lastNode.right = newNode;
        } else {
            // put on left since val < pointer.value
            lastNode.left = newNode;
        }
    }

    // deletes the Node with data val, if it exists
    int delete(int val) {
        Node pointer = this.head;
        // store the parent so that we can set it
        Node parent = null;
        // logic - find the node with the value and then when found, activate helper
        while (pointer != null) {
            if (pointer.value == val) {
                return deleteHelper(pointer, parent);
            } else if (pointer.value > val) {
                pointer = pointer.right;
            } else {
                pointer = pointer.left;
            }
            parent = pointer;
        }
        // the case that it is not found
        return -999999;
        // in order traversal
    }

    int deleteHelper(Node node, Node parent) {
        int valueDeleted = node.value;
        boolean dirLeft;
        // is it on the left or right of the parent
        if (node == parent.left) {
            dirLeft = true;
        } else {
            dirLeft = false;
        }

        if (node.right == null && node.left == null) {
            // it is a leaf therefore it can just be deleted
            if (dirLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (node.left == null && node.right != null) {
            if (dirLeft) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else if (node.left != null && node.right == null) {
            if (dirLeft) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            // case that it has more than two children
            // get the value of the last node in the InOrder
            Node lastNodeOfInOrder = nodesInOrder.get(nodesInOrder.size() - 1);
            int newVal = lastNodeOfInOrder.value;
            delete(newVal);
            node.value = newVal;
        }

        return valueDeleted;
    }

    // somewhere to store inOrder
    private List<Node> nodesInOrder = new ArrayList<>();

    void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        nodesInOrder.add(head);
        inOrder(head.right);
    }


    public static void main(String[] args) {
        /*
        Node head = new Node(8);
        BinarySearchTree bst = new BinarySearchTree(head);
        bst.insert(3);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);
        System.out.println(bst.contains(13) == true);
        System.out.println(bst.contains(1) == false);
        bst.insert(1);
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);
        System.out.println(bst.contains(6) == false);
        System.out.println(bst.contains(7) == false);

         */

        Node h2 = new Node(50);
        BinarySearchTree b2 = new BinarySearchTree(h2);
        b2.insert(40);
        b2.insert(70);
        b2.insert(60);
        b2.insert(80);
        b2.delete(50);

    }
}
