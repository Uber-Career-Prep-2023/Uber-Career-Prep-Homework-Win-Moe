import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingInteger {
    // Binary search variation

    /*
    Question 6: MissingInteger

    Did not get the answer.

    Time complexity: O(n) - It checks every element.
    Space complexity: O(n) - it would create an array every time we call the algorithm.

    Given an integer n and a sorted array of integers of size n-1
    which contains all but one of the integers in the range 1-n, find the missing integer.
    */

    /*
    i drew out a diagram, so basically check element in the middle,
    we can check if the middle is left or right leaning so that can continue searching ONE side.\
    I tried this binary search method but I think it will take too much time. I'll do it later.

    */

    public static int missingInteger(int[] arr, int n) {
        // assume empty means 1 is missing
        if (arr.length == 0) {
            return 1;
        }
        int counter = 1;
        for (int i : arr) {
            if (i != counter) {
                return counter;
            }
            counter += 1;
        }
        // n returned if the wrong item isn't found because it's the last item missing.
        return n;
    }
    public static void main(String[] args) {

        // first test case print
        int[] gg = {1,2,3,5,6,7};
        int result = (missingInteger(gg, 7));

        System.out.println(result);


        // REAL test cases
        Assert.assertTrue(missingInteger(new int[]{1,2,3,5,6,7}, 7) == 4);
        Assert.assertTrue(missingInteger(new int[]{1}, 2) == 2);
        Assert.assertTrue(missingInteger(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12}, 12) == 9);

        // additional test cases
        Assert.assertTrue(missingInteger(new int[]{}, 1) == 1);
        Assert.assertTrue(missingInteger(new int[]{1,2,3,4,5,6,7,8,9,10}, 11) == 11);


        System.out.println("passed test cases");
    }

    /*
This question took 40 minutes, didn't finish - writing test cases.
    */
}
