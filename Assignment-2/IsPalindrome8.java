public class IsPalindrome8 {
    // Given a singly linked list, move the nth from the last element to the front of the list.

    /**
     * meet in the middle doubly linked list forward backward two pointer
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Time taken: 20 minutes
     *
     */

    public IsPalindrome8() {
    }

    public boolean isPalindrome(DoublyLinkedList dll) {
        if (dll == null || dll.length(dll.head) == 0) {
            return false;
        }

        if (dll.length(dll.head) == 1) {
            return true;
        }

        // get head and tail
        DoublyLinkedList.Node temp = dll.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        DoublyLinkedList.Node pointerTail = temp;
        DoublyLinkedList.Node pointerHead = dll.head;

        // iterate through the list from both ends
        while (pointerHead != pointerTail && pointerHead.next != pointerTail && pointerHead.next != null && pointerTail.next != null) {
            if (pointerHead.value != pointerTail.value) {
                return false;
            }
            pointerHead = pointerHead.next;
            pointerTail = pointerTail.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        // null case and test 1
        IsPalindrome8 test1 = new IsPalindrome8();
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println(test1.isPalindrome(list));
        list.insertAtBack(list.head, 9);
        System.out.println(test1.isPalindrome(list)); // true because only one element

        list.insertAtBack(list.head, 2);

        list.insertAtBack(list.head, 4);
        list.insertAtBack(list.head, 2);
        list.insertAtBack(list.head, 9);
        list.testPrint();
        System.out.println(test1.isPalindrome(list)); // true

        System.out.println();
        System.out.println("TEST 2: ");
        // test 2
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertAtFront(list2.head, 9);
        list2.insertAtFront(list2.head, 9);
        System.out.println(test1.isPalindrome(list2)); // true

        list2.insertAtFront(list2.head, 2);
        list2.insertAtFront(list2.head, 2);
        list2.insertAtFront(list2.head, 9);
        list2.insertAtFront(list2.head, 9);
        System.out.println(test1.isPalindrome(list2)); // true
    }
}
