import java.util.PriorityQueue;

public class Q3RunningMedian {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int runningMedian(int num) {
        pq.add(num);
        PriorityQueue<Integer> pqCopy = new PriorityQueue<>(pq);
        for (int i = 0; i < pqCopy.size() / 2; i++) {
            pqCopy.remove();
        }
        return pqCopy.peek();
    }

    public static void main(String[] args) {
        Q3RunningMedian test = new Q3RunningMedian();
        System.out.println(test.runningMedian(1));
        System.out.println(test.runningMedian(1));
        System.out.println(test.runningMedian(1));
        System.out.println(test.runningMedian(1));
    }
}
