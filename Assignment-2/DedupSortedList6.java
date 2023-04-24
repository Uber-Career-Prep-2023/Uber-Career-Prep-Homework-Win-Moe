public class DedupSortedList6 {
    // Given a sorted singly linked list, remove any duplicates so that no value appears more than once.

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Time taken: 20 minutes
     *
     */

    public DedupSortedList6() {

    }

    public void dedupSortedList(SinglyLinkedList sll) {
        // set pointer
        SinglyLinkedList.Node current = sll.head;

        while (current.next != null) {
            if (current.value == current.next.value) {
                //accounts for the case where there are multiple duplicates
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        // singly linked list is edited
    }

    public static void main(String[] args) {
        // test 1
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(list.head, 1);
        list.insertAtBack(list.head, 2);
        list.insertAtBack(list.head, 2);
        list.insertAtBack(list.head, 4);
        list.insertAtBack(list.head, 5);
        list.insertAtBack(list.head, 5);
        list.insertAtBack(list.head, 5);
        list.insertAtBack(list.head, 10);
        list.insertAtBack(list.head, 10);

        DedupSortedList6 test1 = new DedupSortedList6();
        // edits the test
        test1.dedupSortedList(list);
        list.testPrint();

        // test 2
        SinglyLinkedList list2 = new SinglyLinkedList();
    }


}
