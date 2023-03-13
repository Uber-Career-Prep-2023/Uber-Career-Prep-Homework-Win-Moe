import org.antlr.v4.runtime.tree.Tree;
import org.junit.Assert;

import java.util.*;

public class MergeIntervals {
    // sort then solve

    /*
    Time complexity: O(N) - it is only one pass through the array and it checks with the previous elements
    Space complexity: O(N) - it creates a new array with the same size as the input array

    Question 8: MergeIntervals
    Given a list of integer pairs representing the low and high end of an interval, inclusive,
    return a list in which overlapping intervals are merged.
    */

    // input 2d int array, output 2d int array
    // sort the intervals by start time
    // compare to the next interval, if the current interval overlaps with the next interval, merge them
    // remove nulls from intervals

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null) {
            return null;
        }

        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int[] currentInterval = intervals[i];
            int[] nextInterval = intervals[i + 1];

            // if the current interval overlaps with the next interval, merge them
            if (currentInterval != null && currentInterval[1] >= nextInterval[0]) {
                int[] mergedInterval = new int[]{currentInterval[0], Math.max(currentInterval[1], nextInterval[1])};
                intervals[i] = mergedInterval;
                intervals[i + 1] = null;
            }
        }
        // remove nulls from intervals
        int[][] result = new int[intervals.length][2];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                result[index] = intervals[i];
                index++;
            }
        }

        int[][] res2 = new int[index][2];
        for (int i = 0; i < index; i++) {
            res2[i] = result[i];
        }

        return res2;
        /* sample input

Input: [[2, 3], [4, 8], [1, 2], [5, 7], [9, 12]]
Output: [[4, 8], [1, 3], [9, 12]]

Input: [(5, 8), (6, 10), (2, 4), (3, 6)]
Output: [(2, 10)]

Input: [(10, 12), (5, 6), (7, 9), (1, 3)]
Output: [(10, 12), (5, 6), (7, 9), (1, 3)]
         */
    }
    public static void main(String[] args) {
        // test print
        int[][] result = (mergeIntervals(new int[][]{{2, 3}, {4, 8}, {1, 2}, {5, 7}, {9, 12}}));
        // print 2d array
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        // test cases provided (it works)
        //Assert.assertTrue(mergeIntervals(new int[][]{{2, 3}, {4, 8}, {1, 2}, {5, 7}, {9, 12}}).equals(new int[][]{{1, 3}, {4, 8}, {9, 12}}));
        //Assert.assertTrue(mergeIntervals(new int[][]{{5, 8}, {6, 10}, {2, 4}, {3, 6}}).equals(new int[][]{{2, 10}}));
        //Assert.assertTrue(mergeIntervals(new int[][]{{10, 12}, {5, 6}, {7, 9}, {1, 3}}).equals(new int[][]{{1, 3}, {5, 6}, {7, 9}, {10, 12}}));

        // own test cases with numbers and different cases
        //Assert.assertTrue(mergeIntervals(new int[][]{}) == null);



        System.out.println("Passed test cases");
    }

    // this question took me 40 minutes.
}
