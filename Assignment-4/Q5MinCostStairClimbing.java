import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q5MinCostStairClimbing {
    // how to make this dynamic programming`
    /*
    Question 5: MinCostStairClimbing
A staircase on a hiking trail implements a rather unusual toll system to cover trail maintenance costs.
Each stair in the staircase has a different toll which you only have to pay if you step on that stair.
Due to the height of the stairs, you can only climb one or two stairs at once.
This means that from the ground you must initially step on either stair 0 or stair 1 and that,
if there are n stairs, the last stair you step on can be either stair n-1 or n-2.
Given an array representing the costs per stair, what is the minimum possible toll you can pay to climb the staircase?

Examples:
Input: [4, 1, 6, 3, 5, 8]
Output: 9 (step on stairs 1, 3, 4 for a cost of 1+3+5)


Input: [11, 8, 3, 4, 9, 13, 10]
Output: 25 (step on stairs 1, 3, 5 for a cost of 8+4+13)
     */

    public int stairs(int[] tolls) {
        // branch into one two one two
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        stairsHelper(tolls, minHeap, 0, 0);
        stairsHelper(tolls, minHeap, 1, 0);
        return minHeap.peek();
    }

    public void stairsHelper(int[] tolls, PriorityQueue<Integer> results, int n, int sumSoFar) {
        if (n >= tolls.length) {
            results.add(sumSoFar);
        } else {
            stairsHelper(tolls, results, n + 1, sumSoFar + tolls[n]);
            stairsHelper(tolls, results, n + 2, sumSoFar + tolls[n]);
        }
    }

    public static void main(String[] args) {
        Q5MinCostStairClimbing test = new Q5MinCostStairClimbing();
        System.out.println(test.stairs(new int[]{4, 1, 6, 3, 5, 8}));
        System.out.println(test.stairs(new int[]{11, 8, 3, 4, 9, 13, 10}));
    }
}
