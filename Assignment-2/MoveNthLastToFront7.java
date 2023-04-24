public class MoveNthLastToFront7 {
    // Given a sorted singly linked list, remove any duplicates so that no value appears more than once.

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Time taken: 20 minutes
     *
     */

    public MoveNthLastToFront7() {
    }

    public void moveNthLastToFront(SinglyLinkedList sll, int n) {
        // set distance from front instead of from back
        int distanceFromFront = sll.length(sll.head) - n;

        // edge cases
        if (sll == null) {
            return;
        }
        if (distanceFromFront < 0) {
            // invalid input - n is greater than the length of the list
            return;
        } else if (distanceFromFront == 0) {
            // n is the length of the list, so the head is already the nth last
            return;
        } else if (n < 1) {
            return;
        }

        // set pointers to store previousNode and currentNode
        SinglyLinkedList.Node previous = null;
        SinglyLinkedList.Node current = sll.head;

        // int counter to increment until distanceFromFront
        for (int i = 0; i < distanceFromFront; i++) {
            previous = current;
            current = current.next;
        }
        sll.insertAtFront(sll.head, current.value);
        previous.next = current.next;
        current = null;
    }

    public static void main(String[] args) {
        // test 1
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(list.head, 15);
        list.insertAtBack(list.head, 2);
        list.insertAtBack(list.head, 8);
        list.insertAtBack(list.head, 7);
        list.insertAtBack(list.head, 20);
        list.insertAtBack(list.head, 9);
        list.insertAtBack(list.head, 11);
        list.insertAtBack(list.head, 6);
        list.insertAtBack(list.head, 19);

        MoveNthLastToFront7 test1 = new MoveNthLastToFront7();
        // edits the sll
        list.testPrint();
        test1.moveNthLastToFront(list, 2);
        list.testPrint();
        // edge case n 0, move last to the front
        test1.moveNthLastToFront(list, 0); //invalid because it begins from 1
        test1.moveNthLastToFront(list, -99); //invalid because it begins from 1
        list.testPrint();

        test1.moveNthLastToFront(list, 1); //invalid because it begins from 1
        list.testPrint();

        // test 2
        System.out.println(" ");
        System.out.println("Test2");
        SinglyLinkedList list2 = new SinglyLinkedList();
        test1.moveNthLastToFront(list2,1); // no output
        list2.insertAtFront(list2.head, 15);
        list2.insertAtBack(list2.head, 2);
        list2.insertAtBack(list2.head, 8);
        list2.insertAtBack(list2.head, 7);
        list2.insertAtBack(list2.head, 20);
        list2.insertAtBack(list2.head, 9);
        list2.insertAtBack(list2.head, 11);
        list2.insertAtBack(list2.head, 6);
        list2.insertAtBack(list2.head, 19);

        list2.testPrint();
        test1.moveNthLastToFront(list2, 7);
        list2.testPrint();
        test1.moveNthLastToFront(list2, 99);
        list2.testPrint();
    }
}
