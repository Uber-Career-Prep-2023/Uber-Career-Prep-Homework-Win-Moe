import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;
import java.util.List;

public class CopyTree4 {
    // Given a binary tree, create a deep copy. Return the root of the new tree.
    public CopyTree4(BinarySearchTree bst) {
        this.bst = bst;
        BSTNode head = bst.getHead();
        this.head = preOrderCopy(head);
    }

    // instance variables
    private BinarySearchTree bst;
    private BSTNode head;

    public BSTNode preOrderCopy(BSTNode root) {
        if (root == null) {
            return null;
        }
        BSTNode newHead = new BSTNode(root.value);

        newHead.left = preOrderCopy(root.left);
        newHead.right = preOrderCopy(root.right);
        return newHead;
    }

    public BSTNode getHead() {
        return head;
    }

    public static void main(String[] args) {
        BSTNode head = new BSTNode(50);
        BinarySearchTree bst = new BinarySearchTree(head);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        CopyTree4 copyTree = new CopyTree4(bst);
        BSTNode test = copyTree.getHead();
    }

}
