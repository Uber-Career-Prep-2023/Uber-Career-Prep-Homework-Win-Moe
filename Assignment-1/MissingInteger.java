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
    base case - if arr.length is one and arr[0] is n,
     return n

    I will assume that it doesn't start from 0 so return 0 if there is no missing int
    Try binary search variation
    recursively call

    use arrays copy of range
    copyrange made this question a little tougher


    */

    public static int missingInteger(int[] arr, int n) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            if (arr[0] == n) {
                return 0;
            } else {
                return n;
            }
        } else {
            //recursive
            int arrlen = arr.length;
            int arrlenhalf = arr.length / 2;

            int[] arr1 = Arrays.copyOfRange(arr,0, arrlenhalf);
            int[] arr2 = Arrays.copyOfRange(arr, arrlenhalf, arrlen);

            int r1 = missingInteger(arr1, n / 2);
            int r2 = missingInteger(arr2, n);
            return r1 + r2;

        }
    }

    public static void main(String[] args) {

        // first test case print
        int[] gg = {1,2,4};
        int result = (missingInteger(gg, 4));

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
