public class Q3PriorityQueue {
    public Pair[] arr = new Pair[0];

    // pair stores the string to int mapping
    private class Pair {
        public String x;
        public int weight;

        public Pair(String x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }

    public Q3PriorityQueue() {
    }

    public int top() {
        return arr[0].weight;
    }
    public void insert(String x, int weight) {
        // add one to the array length
        Pair[] temparr = new Pair[arr.length+1];
        // copy array items
        for (int i = 0; i < arr.length; i++) {
            temparr[i] = arr[i];
        }
        temparr[temparr.length-1] = new Pair(x, weight);
        this.arr = temparr;

        // use the swim operation to begin putting the latest option in its thing by swimming if it is less
        swim(arr.length-1);
        testPrint(arr);
    }

    public void swim(int k) {
        // if the parent is smaller than the current one, then swap
        if (arr[parent(k)].weight < arr[k].weight) {
            // swap
            Pair temp = arr[parent(k)];
            arr[parent(k)] = arr[k];
            arr[k] = temp;
            // recursively check the parent whether to swim up or not
            swim(parent(k));
        }
    }

    public static int parent(int k) {
        return (k-1)/2;
    }

    public void remove() {
        if (arr.length == 1) {
            this.arr = new Pair[0];
            return;
        }
        Pair[] temparr = new Pair[arr.length-1];
        for (int i = 1; i < arr.length - 1; i++) {
            temparr[i] = arr[i];
        }
        temparr[0] = arr[arr.length-1];
        this.arr = temparr;
        sink(0);

    }

    public void sink(int k) {
        int smallestIndex = k;
        int leftChildIndex = k * 2 + 1;
        int rightChildIndex = k * 2 + 2;
        if (leftChildIndex < arr.length && arr[leftChildIndex].weight > arr[smallestIndex].weight) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < arr.length && arr[rightChildIndex].weight > arr[smallestIndex].weight) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != k) {
            Pair temp = arr[k];
            arr[k] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            sink(smallestIndex);
        }
    }

    public static void testPrint(Pair[] arr) {
        for (Pair p : arr) {
            System.out.print("(" + p.x + ", " + p.weight + ") --> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q3PriorityQueue queue = new Q3PriorityQueue();

        // Insert test cases
        queue.insert("A", 5);
        queue.insert("B", 2);
        queue.insert("C", 7);
        queue.insert("D", 3);
        queue.insert("E", 1);

        // Print the top element
        System.out.println("Top element: " + queue.top()); // Expected output: 7

        // Remove the top element and print the new top element
        queue.remove();
        System.out.println("Top element after removal: " + queue.top()); // Expected output: 5

        // Insert more elements
        queue.insert("F", 8);
        queue.insert("G", 4);

        // Remove elements until the queue is empty
        while (queue.arr.length > 0) {
            System.out.println("Removing top element: " + queue.top());
            queue.remove();
        }
    }
}
