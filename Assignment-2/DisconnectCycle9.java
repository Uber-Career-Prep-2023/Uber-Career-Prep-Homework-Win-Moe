import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisconnectCycle9 {
    // Given a singly linked list, disconnect the cycle, if one exists.

    /**
     * Hash the Nodes
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * Time taken: 15 minutes
     *
     */

    public DisconnectCycle9() {
    }
    public void disconnectCycle(SinglyLinkedList.Node head) {
        if (head == null) {
            return;
        }

        // create bstnode set
        Set<SinglyLinkedList.Node> map = new HashSet<>();

        // iterate through the singlylinkedlist until sees existing key or null
        SinglyLinkedList.Node pointer = head;
        while (pointer != null) {
            if (map.contains(pointer.next)) {
                pointer.next = null;
                break;
            }
            map.add(pointer);
            pointer = pointer.next;
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(list.head, 10);
        list.insertAtBack(list.head, 18);
        list.insertAtBack(list.head, 12);
        list.insertAtBack(list.head, 9);
        list.insertAtBack(list.head, 11);
        list.insertAtBack(list.head, 4);
        list.head.next.next.next.next.next.next = list.head.next.next;

        DisconnectCycle9 test = new DisconnectCycle9();
        test.disconnectCycle(list.head);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtFront(list2.head, 10);
        list2.insertAtBack(list2.head, 18);
        list2.insertAtBack(list2.head, 12);
        list2.insertAtBack(list2.head, 9);
        list2.insertAtBack(list2.head, 11);
        list2.insertAtBack(list2.head, 4);
        list2.head.next.next.next.next.next.next = list2.head.next.next.next.next.next;

        test.disconnectCycle(list2.head);

        // null cases
        test.disconnectCycle(list2.head); // does nothing

        test.disconnectCycle(null); // does nothing
    }
}
