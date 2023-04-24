import java.util.ArrayList;
import java.util.List;

public class IsBST5 {
    /**
     * Depth-first traversal
     * In-order traversal
     * Time complexity: O(n)
     * Space complexity: O(n)
     * <p>
     * Time taken: 30 minutes
     *
     * @param BSTNode
     */

// instance variables
    private List<Integer> orderedList;

    public IsBST5() {
        orderedList = new ArrayList<>();
    }

    public void inOrder(BSTNode node) {
        if (node == null) {
            return;
        } else {
            inOrder(node.left);
            orderedList.add(node.value);
            inOrder(node.right);
        }
    }

    public boolean isBST(BSTNode head) {
        inOrder(head);
        for (int i = 0; i < orderedList.size() - 1; i++) {
            if (orderedList.get(i) > orderedList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // test 1 on CopyTree4 and inOrder
        BSTNode head = new BSTNode(50);
        BinarySearchTree bst = new BinarySearchTree(head);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        CopyTree4 copyTree = new CopyTree4(bst.getHead());
        BSTNode testNodeCopied = copyTree.getHead();

        IsBST5 test1 = new IsBST5();
        System.out.println(test1.isBST(testNodeCopied)); // should print true

        // test 2 on custom wrong node
        BSTNode head2 = new BSTNode(50);
        BSTNode wrongLeft = new BSTNode(80);
        BSTNode wrongRight = new BSTNode(40);
        head2.left = wrongLeft;
        head2.right = wrongRight;
        IsBST5 test2 = new IsBST5();
        System.out.println(test2.isBST(head2)); // should print false

        // test 3 on null
        IsBST5 test3 = new IsBST5();
        System.out.println(test3.isBST(null)); // should print true
    }
}
