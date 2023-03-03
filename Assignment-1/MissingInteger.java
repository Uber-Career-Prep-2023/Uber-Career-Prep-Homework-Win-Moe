import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingInteger {
    // Binary search variation

    /*
    Question 6: MissingInteger

    Did not get the answer.

    Time complexity: O(nlog(n)) - It would be in log time since binary search is log n time
    Space complexity: O(nlog(n)) - it would create an array every time we call the algorithm.

    Given an integer n and a sorted array of integers of size n-1
    which contains all but one of the integers in the range 1-n, find the missing integer.
    */

    /*
    if arr empty return 0
    use recursion binary search and int up and down boounds
    middle


    */

    public static int missingInteger(int[] arr, int n) {
        if (arr.length == 0) {
            return 0;
        }

        return helper(arr, n, 0, arr.length - 1);
    }

    public static int helper(int[] arr, int n, int lower, int upper) {

        if (lower > upper) {
            return 0;
        }
        int middle = lower + ((upper - lower) / 2);
        if (middle - 1 != n) {
            return middle;
        }
        return helper(arr, n, lower, middle - 1) + helper(arr, n, middle + 1, upper);
    }

    public static void main(String[] args) {

        // first test case print
        int[] gg = {1,2,3,5,6,7};
        int result = (missingInteger(gg, 7));

        System.out.println(result);


        // REAL test cases

        // additional test cases

        /*
        Input Array: [1, 2, 3, 4, 6, 7]
        Input n: 7
        Output: 5

        Input Array: [1]
        Input n: 2
        Output: 2

        Input Array: [1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12]
        Input n: 12
        Output: 9

         */
    }

    /*
This question took 40 minutes, didn't finish - writing test cases.
    */
}
