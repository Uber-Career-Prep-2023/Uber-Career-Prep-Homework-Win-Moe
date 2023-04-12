import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    // instance variable for head
    private BSTNode head;


    // constructor
    public BinarySearchTree(BSTNode head) {
        this.head = head;
    }

    // helper method to get head
    public BSTNode getHead() {
        return head;
    }

    // returns the minimum value in the BST
    int min() {
        if (head == null) {
            return 0;
        }
        BSTNode pointer = head;
        return minHelper(pointer);
    }
    int minHelper(BSTNode pointer) {
        if (pointer.left == null) {
            return pointer.value;
        } else {
            return minHelper(pointer.left);
        }
    }

    // returns the maximum value in the BST
    int max() {
        if (head == null) {
            return 0;
        }
        BSTNode pointer = head;
        return maxHelper(pointer);
    }
    int maxHelper(BSTNode pointer) {
        if (pointer.right == null) {
            return pointer.value;
        } else {
            return maxHelper(pointer.right);
        }
    }

    // returns a boolean indicating whether val is present in the BST

    boolean contains(int val) {
        // pointer moves through left or right depending on value and pointer's value
        BSTNode pointer = head;
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

    // creates a new BSTNode with data val in the appropriate location
    // For simplicity, do not allow duplicates. If val is already present, insert is a no-op
    void insert(int val) {
        // pointer checks where to put depending on BST rules
        // if val > pointer, go until null, set pointer's right to the new BSTNode
        BSTNode newNode = new BSTNode(val);
        BSTNode pointer = head;

        // store the last BSTNode to pick pointer's location
        BSTNode lastNode = null;

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
        BSTNode pointer = this.head;
        // store the parent so that we can set it
        BSTNode parent = this.head;
        // logic - find the node with the value and then when found, activate helper
        while (pointer != null) {
            if (val == pointer.value) {
                return deleteHelper(pointer, parent);
            } else if (val > pointer.value) {
                parent = pointer;
                pointer = pointer.right;
            } else {
                parent = pointer;
                pointer = pointer.left;
            }

        }
        // the case that it is not found
        return -999999;
        // in order traversal
    }

    int deleteHelper(BSTNode node, BSTNode parent) {
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
            // get the value of the successor node in the InOrder
            inOrder(node);
            int successorNodeIndex = 0;
            for (int i = 0; i < nodesInOrder.size() - 1; i++) {
                if (nodesInOrder.get(i).value == node.value) {
                    successorNodeIndex = i + 1;
                }
            }
            BSTNode successorNode = nodesInOrder.get(successorNodeIndex);


            int newVal = successorNode.value;
            this.delete(newVal);
            node.value = newVal;
            this.nodesInOrder = new ArrayList<>();
        }

        return valueDeleted;
    }

    // somewhere to store inOrder
    private List<BSTNode> nodesInOrder = new ArrayList<>();

    void inOrder(BSTNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        nodesInOrder.add(head);
        inOrder(head.right);
    }


    public static void main(String[] args) {
        BSTNode head = new BSTNode(8);
        BinarySearchTree bst = new BinarySearchTree(head);
        bst.insert(3);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);
        bst.insert(1);
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);

// Test min method
        System.out.println(bst.min()); // should print 1

// Test max method
        System.out.println(bst.max()); // should print 14

// Test contains method
        System.out.println(bst.contains(13)); // should print true
        System.out.println(bst.contains(1)); // should print true
        System.out.println(bst.contains(6)); // should print true
        System.out.println(bst.contains(7)); // should print true
        System.out.println(bst.contains(15)); // should print false

        BSTNode h2 = new BSTNode(50);
        BinarySearchTree b2 = new BinarySearchTree(h2);
        b2.insert(40);
        b2.insert(70);
        b2.insert(60);
        b2.insert(80);

// Test delete method
        b2.delete(50);
        System.out.println(b2.contains(50)); // should print false

        b2.delete(70);
        System.out.println(b2.contains(70)); // should print false

        b2.delete(80);
        System.out.println(b2.contains(80)); // should print false
    }
}
