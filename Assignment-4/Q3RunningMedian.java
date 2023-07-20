import java.util.PriorityQueue;

public class Q3RunningMedian {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public double runningMedian(int num) {
        pq.add(num);
        PriorityQueue<Integer> pqCopy = new PriorityQueue<>(pq);
        double secondLast = pqCopy.peek();

        for (int i = 0; i < pq.size()/2; i++) {
            secondLast = pqCopy.peek();
            pqCopy.remove();
        }
        double median = pqCopy.peek();
        if (pq.size() % 2 == 0) {
            return (median + secondLast) / 2;
        }
        return pqCopy.peek();
    }

    public static void main(String[] args) {
        Q3RunningMedian test = new Q3RunningMedian();
        System.out.println(test.runningMedian(1));
        System.out.println(test.runningMedian(11));
        System.out.println(test.runningMedian(4));
        System.out.println(test.runningMedian(15));
        System.out.println(test.runningMedian(12));

    }
}
