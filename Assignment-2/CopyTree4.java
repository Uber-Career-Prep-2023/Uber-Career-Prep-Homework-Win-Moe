import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;
import java.util.List;

public class CopyTree4 {
    // Given a binary tree, create a deep copy. Return the root of the new tree.

    /**
     * Depth-first traversal
     * Pre-order traversal
     * Time complexity: O(n) copying it is linear
     * Space complexity: O(n) copying it takes linear space because it is a new tree
     *
     * Time taken: 20-30 minutes
     *
     * @param head of bst
     */

    private BSTNode head;

    public CopyTree4(BSTNode head) {
        this.head = preOrderCopy(head);
    }

    // instance variables

    public BSTNode preOrderCopy(BSTNode root) {
        if (root == null) {
            return null;
        }
        BSTNode newHead = new BSTNode(root.value);

        // pre order traversal
        newHead.left = preOrderCopy(root.left);
        newHead.right = preOrderCopy(root.right);
        return newHead;
    }

    public BSTNode getHead() {
        return head;
    }

    public static void main(String[] args) {
        // test the tree
        BSTNode head = new BSTNode(50);
        BinarySearchTree bst = new BinarySearchTree(head);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        CopyTree4 copyTree = new CopyTree4(bst.getHead());
        BSTNode test = copyTree.getHead();



        // test a tree, but not a BST
        // test 2 on custom wrong node
        BSTNode head2 = new BSTNode(50);
        BSTNode wrongLeft = new BSTNode(80);
        BSTNode wrongRight = new BSTNode(40);
        head2.left = wrongLeft;
        head2.right = wrongRight;
        CopyTree4 copyTree2 = new CopyTree4(head2);
        BSTNode test2 = copyTree2.getHead();

        // test on null, no error
        CopyTree4 copyTree3 = new CopyTree4(null);
        BSTNode test3 = copyTree3.getHead();

    }

}
