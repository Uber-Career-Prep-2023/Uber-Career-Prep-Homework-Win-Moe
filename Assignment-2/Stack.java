public class Stack {
    private Node head;
    public static class Node {
        // storing int value instance variable and Node next
        private int value;
        private Node next;

        // constructor to create a new node with a value
        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    // returns the top item in the stack
    int top() {
        return head.value;
    }

    // adds x to the top of the stack
    void push(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // removes and returns the top item in the stack
    int pop() {
        if (isEmpty()) {
            return -1;
        }
        int headVal = head.value;
        head = head.next;
        return headVal;
    }

    // returns a boolean indicating whether the stack is empty
    boolean isEmpty() {
        return head == null;
    }

    /**
     * int top() // returns the top item in the stack
     *     void push(int x) // adds x to the top of the stack
     *     int pop() // removes and returns the top item in the stack
     *     bool isEmpty() // returns a boolean indicating whether the stack is empty
     *
     */

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Test isEmpty method
        System.out.println(stack.isEmpty()); // should print true

        // Test push method
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test isEmpty method again
        System.out.println(stack.isEmpty()); // should print false

        // Test top method
        System.out.println(stack.top()); // should print 3

        // Test pop method
        System.out.println(stack.pop()); // should print 3
        System.out.println(stack.pop()); // should print 2
        System.out.println(stack.pop()); // should print 1
        System.out.println(stack.pop()); // should print -1, because stack is now empty

        // Test isEmpty method again
        System.out.println(stack.isEmpty()); // should print true

    }
}
