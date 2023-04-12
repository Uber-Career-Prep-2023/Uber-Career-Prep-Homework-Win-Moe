public class Queue {
    private Node head;
    private Node tail;
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

    // returns the first item in the queue
    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.value;
    }

    // adds x to the back of the queue
    void enqueue(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // removes and returns the first item in the queue
    int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int headValue = head.value;
        head = head.next;
        return headValue;
    }

    // returns a boolean indicating whether the queue is empty
    boolean isEmpty() {
        return head == null;
    }

    /**
     *   int peek() // returns the first item in the queue
     *     void enqueue(int x) // adds x to the back of the queue
     *     int dequeue() // removes and returns the first item in the queue
     *     bool isEmpty() // returns a boolean indicating whether the queue is empty
     *
     */

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test isEmpty method
        System.out.println(queue.isEmpty()); // should print true

        // Test enqueue method
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Test isEmpty method again
        System.out.println(queue.isEmpty()); // should print false

        // Test peek method
        System.out.println(queue.peek()); // should print 1

        // Test dequeue method
        System.out.println(queue.dequeue()); // should print 1
        System.out.println(queue.dequeue()); // should print 2
        System.out.println(queue.dequeue()); // should print 3

        // Test isEmpty method again
        System.out.println(queue.isEmpty()); // should print true
        System.out.println(queue.dequeue()); // should print -1
        System.out.println(queue.peek()); // should print -1
    }
}
