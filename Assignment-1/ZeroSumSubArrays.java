import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ZeroSumSubArrays {
    // Reset/catch-up two-pointer

      /*
    Question 3: ZeroSumSubArrays
    
    Time complexity: O(n log n) - we are traversing the array, but every time we go through it, the length decreases by one
    Space complexity: O(n) - only one array we are traversing through

    Given an array of integers,
    count the number of subarrays that sum to zero.
    */

    ///////// SHOULD I MAKE THIS ASSUMPTION OR NAH.
    // assumption - subarrays mean the sum to zero arrays combined
    //      must make up the entire array otherwise count is zero.
    //      i assume this based on test case 3, where

    // edge case empty arr (length 0), return 0
    // while loop with index counter
    // int count which will be returned
    // int index counter
    // int front and back pointer

    // calculate the sum by a for loop every time
    // if sum is zero,
    // set pointerBack to pointerFront


    // note - the subarray has to be consecutive

    // I think there is an error with this problem too. test case three
    // does it mean the subarrays have to comprise the entire array?

    public static int ZeroSumSubArrays(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int count = 0;
        int pointerFront = 0;
        int pointerBack = 0;
        int index = 0;
        int sum = 0;

        // while loops, pointerFront doesn't exceed length
        while (index < arr.length - 1) {

            // reset sum

            sum += arr[pointerFront];
            if (sum == 0) {
                pointerBack = pointerFront;
                count += 1;
            }

            pointerFront += 1;

            // if pointerFront reaches end of arr, reset it to original
            if (pointerFront == arr.length) {
                index += 1;
                pointerFront = index;
                pointerBack = index;
                sum = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // test cases provided
        Assert.assertTrue(ZeroSumSubArrays(new int[]{4, 5, 2, -1, -3, -3, 4, 6, -7}) == 2);
        Assert.assertTrue(ZeroSumSubArrays(new int[]{1, 8, 7, 3, 11, 9}) == 0);
        Assert.assertTrue(ZeroSumSubArrays(new int[]{8, -5, 0, -2, 3, -4}) == 2);
        Assert.assertTrue(ZeroSumSubArrays(new int[]{1, -1, 1}) == 2);
        Assert.assertTrue(ZeroSumSubArrays(new int[]{1, 0, -1}) == 2);
        Assert.assertTrue(ZeroSumSubArrays(new int[]{1, -1}) == 1);

        // own test cases
        Assert.assertTrue(ZeroSumSubArrays(new int[]{}) == 0);
        Assert.assertTrue(ZeroSumSubArrays(new int[]{0, 0}) == 2);


        System.out.println("Passed test cases");
    }
    /*
    This question took me 40 minutes.
    */
}
