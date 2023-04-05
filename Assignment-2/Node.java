public class Node {
    // storing int value instance variable
    private int value;
    private Node next;

    // constructor to create a new node with a value
    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }



    // creates new Node with data val at front; returns new head
    Node insertAtFront(Node head, int val) {
        head.value = val;
        // set head's next to this.
        head.next = this;
        return head;
    }

    // creates new Node with data val at end
    void insertAtBack(Node head, int val) {
        // set pointer to get to the back
        head.value = val;
        Node pointer = this;

        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = head;
    }

    // creates new Node with data val after Node loc
    void insertAfter(Node head, int val, Node loc) {
        // similar logic but where pointer.next is loc
        Node pointer = this;

        while (pointer.next != loc) {
            pointer = pointer.next;
        }
        pointer.next = head;
    }

    // removes first Node; returns new head
    Node deleteFront(Node head) {
        Node newHead = head.next;
        head.next = null;
        return newHead;
    }

    // removes last Node
    void deleteBack(Node head) {
        // set pointer to get to the back
        Node pointer = this;

        while (pointer.next.next != null) {
            pointer = pointer.next;
        }
        pointer.next = null;

    }

    // deletes Node loc; returns head
    Node deleteNode(Node head, Node loc) {
        Node pointer = head;
        while (pointer.next != loc) {
            pointer = pointer.next;
        }
        pointer.next = loc.next;
        return loc;
    }

    // returns length of the list
    int length(Node head) {
        int len = 0;
        Node pointer = head;

        while (pointer != null) {
            pointer = pointer.next;
            len += 1;
        }
        return len;
    }

    // reverses the linked list iteratively
    Node reverseIterative(Node head) {
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    // reverses the linked list recursively (Hint: you will need a helper function)
    Node reverseRecursive(Node head) {
        return recursiveHelper(null, head);
    }

    Node recursiveHelper(Node prevNode, Node currNode) {
        if (currNode == null) {
            return prevNode;
        } else {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            return recursiveHelper(prevNode, currNode);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);

        Node rev = head.reverseIterative(head);
        Node revrec = rev.reverseRecursive(rev);

        /*
        Node head = new Node(1);
        head.insertAtBack(new Node(), 2);

        Node headhead = new Node();
        head.insertAtFront(headhead, -9);

        int len1 = head.length(headhead);

        head.deleteFront(headhead);
        head.deleteBack(head);

        int len = head.length(head);
         */
    }
}
