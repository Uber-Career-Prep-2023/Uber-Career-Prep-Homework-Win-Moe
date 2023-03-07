import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // One-directional running computation/total

    /*
    Question 10: TwoSum


    Time complexity: O(n^2) - Number of traversals is n(n-1)/2 because it goes through twice
    Space complexity: O(nlog(n)) - it would create an array every time we call the algorithm.

    Given an array of integers and a target integer, k,
    return the number of pairs of integers in the array that sum to k.
    In each pair, the two items must be distinct elements (come from different indices in the array).

    */

    /*
    edgecase null arr return -1

    create int counter
    put into hashmap? is hashing technique necessary because array is also very efficient

    brute force solution first, two for loops.

    efficient solution
    use hashmap to use contains method to see if there is k - current index.
    */

    public static int twoSum(int[] arr, int k) {

        /*
        // brute force
        // i was keeping track of pairs
        // Map<Integer, Integer> pairs = new HashMap<>();
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    counter += 1;
                    // pairs.put(arr[i], arr[j]);
                }
            }
        }
        // System.out.println(pairs);
        return counter;
        */

        // efficient method using hashmap
        Map<Integer, Integer> indexToVal = new HashMap<>();
        int count = 0;
        for (int x = 0; x < arr.length; x++) {
            indexToVal.put(x, arr[x]);
        }


        for (int key : indexToVal.keySet()) {
            // how to deal with duplicate values that sum up to k. like 5+5 = 10 but there is only one five?
            if (indexToVal.containsValue(k - key)) {
                count += 1;
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {

        // first test case print
        System.out.println(twoSum(new int[]{1, 10, 8, 3, 2, 5, 7, 2, -2, -1}, 10));

        // assert
        Assert.assertTrue(twoSum(new int[]{1, 10, 8, 3, 2, 5, 7, 2, -2, -1}, 8) == 3);
        Assert.assertTrue(twoSum(new int[]{4, 3, 3, 5, 7, 0, 2, 3, 8, 6}, 6) == 5);
        Assert.assertTrue(twoSum(new int[]{4, 3, 3, 5, 7, 0, 2, 3, 8, 6}, 1) == 0);

        // edge case
        Assert.assertTrue(twoSum(new int[]{}, 1) == -1);
        Assert.assertTrue(twoSum(null, 1) == -1);
        // make sure duplicate index isn't allowed
        Assert.assertTrue(twoSum(new int[]{5}, 10) != 1);


    }

    // this question took me 8 minutes - not sure how to find efficient solution.
}
