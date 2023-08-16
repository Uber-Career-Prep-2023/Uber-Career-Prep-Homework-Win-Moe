public class Q2Heap {
    public int[] arr;

    public Q2Heap(int begin) {
        arr = new int[1];
        arr[0] = begin;
    }

    public int top() {
        return arr[0];
    }
    public void insert(int x) {
        // add one to the array length
        int[] temparr = new int[arr.length+1];
        // copy array items
        for (int i = 0; i < arr.length; i++) {
            temparr[i] = arr[i];
        }
        temparr[temparr.length-1] = x;
        this.arr = temparr;

        // use the swim operation to begin putting the latest option in its thing by swimming if it is less
        swim(arr.length-1);
        testPrint(arr);
    }

    public void swim(int k) {
        // if the parent is bigger than the current one, then swap
        if (arr[parent(k)] > arr[k]) {
            // swap
            int temp = arr[parent(k)];
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
            this.arr = new int[0];
            return;
        }
        int[] temparr = new int[arr.length-1];
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
        if (leftChildIndex < arr.length && arr[leftChildIndex] < arr[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < arr.length && arr[rightChildIndex] < arr[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != k) {
            int temp = arr[k];
            arr[k] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            sink(smallestIndex);
        }
    }

    public static void testPrint(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q2Heap heap = new Q2Heap(99);
        heap.insert(88);
        heap.insert(77);
        heap.insert(66);
        heap.remove();
        heap.insert(22);
        heap.insert(100);
        heap.remove();
        heap.insert(22);

        System.out.println("Other test cases: ");
        // Test Case 1: Insertion and Removal
        Q2Heap heap1 = new Q2Heap(99);
        heap1.insert(88);
        heap1.insert(77);
        heap1.insert(66);
        heap1.remove();
        testPrint(heap1.arr); // Expected Output: 66 99 88

        // Test Case 2: Insertion of Larger Elements
        Q2Heap heap2 = new Q2Heap(50);
        heap2.insert(70);
        heap2.insert(80);
        heap2.insert(60);
        heap2.insert(90);
        testPrint(heap2.arr); // Expected Output: 50 60 70 80 90
        System.out.println("Expected Output: 50 60 70 80 90");


        // Test Case 3: Insertion of Smaller Elements
        Q2Heap heap3 = new Q2Heap(100);
        heap3.insert(80);
        heap3.insert(70);
        heap3.insert(90);
        heap3.insert(60);
        testPrint(heap3.arr); // Expected Output: 60 70 90 80 100
        System.out.println("Expected Output: 60 70 90 80 100");

        // Test Case 4: Insertion of Duplicate Elements
        Q2Heap heap4 = new Q2Heap(10);
        heap4.insert(20);
        heap4.insert(10);
        heap4.insert(20);
        heap4.insert(10);
        testPrint(heap4.arr); // Expected Output: 10 10 20 20 10
        System.out.println("Expected Output: 10 10 20 20 10");

        // Test Case 5: Insertion and Removal of Single Element
        Q2Heap heap5 = new Q2Heap(50);
        heap5.remove();
        testPrint(heap5.arr); // Expected Output: (empty heap)
        System.out.println("Expected Output: none");
        heap5.insert(99);
    }
}
