public class SinglyLinkedList {
    // head Node
    public Node head;

    // HELPER: class Node
    public static class Node {
        // storing int value instance variable and Node next
        public int value;
        public Node next;

        // constructor to create a new node with a value
        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    // HELPER: toString test method
    public void testPrint() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.value + " --> ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    // creates new Node with data val at front; returns new head
    public Node insertAtFront(Node head, int val) {
        Node newNode = new Node(val);
        // newNode's next to head.
        newNode.next = head;
        // set the head of the list to newNode
        this.head = newNode;
        return newNode;
    }

    // creates new Node with data val at end
    public void insertAtBack(Node head, int val) {
        Node newNode = new Node(val);

        // if the head is null then just make this the head.
        if (head == null) {
            this.head = newNode;
            return;
        }

        // set pointer to get to the back
        Node pointer = head;

        while (pointer.next != null) {
            pointer = pointer.next;
        }
        // pointer.next is null, so set it to newNode since it's at the end
        pointer.next = newNode;
    }

    // creates new Node with data val after Node loc
    public void insertAfter(Node head, int val, Node loc) {
        Node newNode = new Node(val);
        Node pointer = head;

        while (pointer != loc) {
            pointer = pointer.next;
        }

        // loc's previous next will become the newNode's next
        Node prevNext = pointer.next;
        pointer.next = newNode;
        newNode.next = prevNext;
        // if loc is not found, then just insert at the end
    }

    // removes first Node; returns new head
    public Node deleteFront(Node head) {
        //edgecase if the slllist is empty
        if (head == null) {
            return null;
        }

        Node newHead = head.next;
        // newHead becomes the head
        this.head = newHead;
        return this.head;
    }

    // removes last Node
    public void deleteBack(Node head) {
        //edgecase if the slllist is empty
        if (head == null) {
            return;
        }

        // set pointer to get to the back
        Node pointer = head;

        while (pointer.next.next != null) {
            pointer = pointer.next;
        }
        pointer.next = null;

    }

    // deletes Node loc; returns head
    public Node deleteNode(Node head, Node loc) {
        // EDGE CASE that the head is the loc
        if (this.head == loc) {
            return deleteFront(head);
        } else {
            Node pointer = head;
            // stop when pointer is loc or pointer is null,
            // the condition is that pointer.next is loc instead of pointer being loc
            // because we still need to connect loc's next to pointer's next
            while (pointer.next != loc && pointer.next != null) {
                pointer = pointer.next;
            }
            // no problem if loc is never found if the pointer is at null then we just return nothing
            if (pointer.next == null) {
                return null;
            }

            // switch the pointers to skip over loc
            pointer.next = loc.next;
            loc = null;
            return head;
        }
    }

    // returns length of the list
    public int length(Node head) {
        int len = 0;
        Node pointer = head;

        // edgecase there is nothing
        if (pointer == null) {
            return len;
        }

        while (pointer != null) {
            pointer = pointer.next;
            len += 1;
        }
        return len;
    }

    // reverses the linked list iteratively
    public Node reverseIterative(Node head) {
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        // set the head to the former tail
        this.head = prevNode;
        return prevNode;
    }

    // reverses the linked list recursively (Hint: you will need a helper function)
    public Node reverseRecursive(Node head) {
        return recursiveHelper(null, head);
    }

    public Node recursiveHelper(Node prevNode, Node currNode) {
        if (currNode == null) {
            // set the head to the former tail
            this.head = prevNode;
            return prevNode;
        } else {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            return recursiveHelper(prevNode, currNode);
        }
    }

    /** FUNCTIONS TO TEST
    Node insertAtFront(Node head, int val) // creates new Node with data val at front; returns new head
    void insertAtBack(Node head int val) // creates new Node with data val at end
    void insertAfter(Node head, int val, Node loc) // creates new Node with data val after Node loc
    Node deleteFront(Node head) // removes first Node; returns new head
    void deleteBack(Node head) // removes last Node
    Node deleteNode(Node head, Node loc) // deletes Node loc; returns head *** WORK ON THIS ***
    int length(Node head) // returns length of the list
    Node reverseIterative(Node head) // reverses the linked list iteratively
    Node reverseRecursive(Node head) // reverses the linked list recursively (Hint: you will need a helper function)
     */

    // testing main method of the singlylinkedlist class
    public static void main(String[] args) {
        // test case 1
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtFront(sll.head, 1);
        sll.insertAtBack(sll.head, 2);
        sll.testPrint();
        System.out.println("Length of list:" + sll.length(sll.head));
        sll.insertAtFront(sll.head, 0);
        sll.insertAtBack(sll.head, 3);
        sll.testPrint();
        sll.reverseIterative(sll.head);
        sll.testPrint();
        sll.reverseRecursive(sll.head);
        sll.testPrint();
        sll.deleteBack(sll.head);
        sll.deleteFront(sll.head);
        sll.testPrint();

        // test case in between, we want to try inserting at back, which initially failed
        SinglyLinkedList sll0 = new SinglyLinkedList();
        sll0.insertAtBack(sll0.head, 1);
        sll0.insertAtBack(sll0.head, 0);
        sll0.insertAtFront(sll0.head, 1);
        sll0.testPrint();


        //test case 2
        System.out.println();
        System.out.println("Test 2: ");
        SinglyLinkedList sll2 = new SinglyLinkedList();
        //edgecases delete empty list, returns empty and no error
        sll2.deleteBack(sll.head);
        sll2.deleteFront(sll.head);
        // problem with the loc node, currently i just compared them
        Node loc = new Node(0);
        sll2.head = loc;
        sll2.insertAfter(sll2.head, 2, loc);
        sll2.testPrint();
        sll2.insertAfter(sll2.head, 1, loc);
        sll2.testPrint();
        // it should delete loc, which has a value of 0
        sll2.deleteNode(sll2.head, loc);
        sll2.testPrint();
        // let's try deleting loc again, since it's not found it is unaffected
        sll2.deleteNode(sll2.head, loc);
        sll2.testPrint();

        // TALK ABOUT: WHAT IF THE LINKEDLIST IS CIRCULAR? IT WOULD GO INTO INFINITE LOOP.
    }
}
