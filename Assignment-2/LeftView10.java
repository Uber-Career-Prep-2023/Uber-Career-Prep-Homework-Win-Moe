import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeftView10 {
    // Given a binary tree, create an array of the left view (leftmost elements in each level) of the tree.

    /**
     * Breadth first - level order traversal
     * Time complexity: O(n) - traverse through all nodes
     * Space complexity: O(n) - store all nodes of levels
     *
     * Time taken: 30 minutes
     */

    // tested with void print strategy first

    public ArrayList<Integer> leftView(BSTNode root) {
        HashMap<Integer, Integer> leftView = new HashMap<Integer, Integer>();
        leftViewHelper(root, 0, leftView);

        ArrayList<Integer> leftViewList = new ArrayList<Integer>();
        for (int level : leftView.keySet()) {
            leftViewList.add(leftView.get(level));
        }
        System.out.println(leftViewList);
        return leftViewList;
    }
    public void leftViewHelper(BSTNode root, int level, HashMap<Integer, Integer> leftView) {
        if (root == null) {
            return;
        } else {
            if (leftView.containsKey(level) == false) {
                leftView.put(level, root.value);
            }
            leftViewHelper(root.left, level + 1, leftView);
            leftViewHelper(root.right, level + 1, leftView);
        }
    }



    public static void main(String[] args) {

        // test the tree
        BSTNode head = new BSTNode(7);
        head.left = new BSTNode(8);
        head.right = new BSTNode(3);
        head.right.right = new BSTNode(13);
        head.right.left = new BSTNode(9);


        LeftView10 test = new LeftView10();
        test.leftView(head); // should print 7, 8, 9

        head.right.left.left = new BSTNode(20);
        head.right.right.left = new BSTNode(14);
        head.right.right.left.right = new BSTNode(15);
        test.leftView(head); // should print 7, 8, 9, 20, 15

        // null case
        test.leftView(null); // should print empty list
        BSTNode head2 = new BSTNode(7);
        test.leftView(head2); // should print 7 only

    }
}
