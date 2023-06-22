import java.util.LinkedList;
import java.util.Queue;

public class Q5FirstKBinaryNumbers {
    /**
     * Given a number, k, return an array of the first k binary numbers, represented as strings.
     *
     * Examples:
     * Input: 5
     * Output: ["0", "1", "10", "11", "100"]
     *
     * Input: 10
     * Output: ["0", "1", "10", "11", "100", "101", "110", "111", "1000", "1001"]
     */

    // method used: Queue
    // time complexity: O(1) there is only insertion and deletion
    // space complexity: O(n) a queue is like this

    // time: took me a while

    public static void main(String[] args) {
        print(fkbn(10));
    }

    public static String[] fkbn(int k) {
        // invalid case
        if (k < 1) {
            return null;
        }

        String[] resultList = new String[k];
        resultList[0] = "0";
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 1; i < k; i++) {
            String curr = queue.poll();
            resultList[i] = curr;

            String zeroAppended = curr + "0";
            String oneAppended = curr + "1";

            queue.add(curr + "0");
            queue.add(curr + "1");
        }
        return resultList;
    }

    public static void print(String[] s) {
        for (String str : s) {
            System.out.print("***"+str + " ");
        }
    }

}
