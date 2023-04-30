public class FloorInBST11 {
    // Given a target numeric value and a binary search tree,
    // return the floor (greatest element less than or equal to the target) in the BST.

    /**
     * Binary search
     * Time complexity: O(n) - goes through all nodes in BST
     * Space complexity: O(log n) - only stores the necessary elements
     *
     * Time taken: 20-30 minutes
     *
     */

    public int floorInBST(BSTNode root, int target) {
        if (root == null) {
            // error
            return -1;
        }

        // check if the target is root.value otherwise traverse through the BST
        if (target == root.value) {
            return root.value;
        } else if (target < root.value) {
            // stop recursion if there is no left child
            if (root.left == null) {
                return root.value;
            } else {
                return floorInBST(root.left, target);
            }
        } else {
            // stop recursion if there is no left child
            if (root.right == null) {
                return root.value;
            } else {
                return floorInBST(root.right, target);
            }
        }
    }

    public static void main(String[] args) {
        // test the tree
        BSTNode head = new BSTNode(10);
        BinarySearchTree bst = new BinarySearchTree(head);
        bst.insert(8);
        bst.insert(9);
        bst.insert(16);
        bst.insert(13);
        bst.insert(17);
        bst.insert(20);

        FloorInBST11 test = new FloorInBST11();

        System.out.println(test.floorInBST(bst.getHead(), 13));
        System.out.println(test.floorInBST(bst.getHead(), 15));
        System.out.println(test.floorInBST(bst.getHead(), 999999));
        System.out.println(test.floorInBST(bst.getHead(), -999999)); // returns smallest element
        System.out.println(test.floorInBST(null, 999));
    }
}
