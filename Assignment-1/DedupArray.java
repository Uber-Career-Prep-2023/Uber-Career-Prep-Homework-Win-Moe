import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DedupArray {
    // One-directional running computation/total

    /*
    Question 9: DedupArray

    Time complexity: O(N) - two for loops that traverse the array one time each.
    Space complexity: O(N) - there is only one set that grows as a linear function of the input array.

    Given a sorted array of non-negative integers,
    modify the array by removing duplicates so each element only appears once.
    If arrays are static (aka, not dynamic/resizable) in your language of choice,
    the remaining elements should appear in the left-hand side of the array
    and the extra space in the right-hand side should be padded with -1s.
    */

    // what does array being sorted have to do with this?
    // binary search? I don't see how it's related.


    // create hashset of integers
    // there won't be duplicates
    // for i < arr.length, add each integers in set
    // arr[i] = key
    // if the set is exhausted then remaining of arr becomes -1
    // since the array is being MODIFIED, it would be void
    // considered case of empty arr, no need to change anything since code wouldn't break;

    // what if there are -1 in the arr? it would look the same right? I assume this

    // also realized binary search could work on this array if there are extremely many duplicates
    // in these cases can get log n time but very hard to implement.

    public static void dedupArray(int[] arr) {
        Set<Integer> integerSet = new HashSet<>();
        for (int item : arr) {
            integerSet.add(item);
        }

        int count = 0;
        for (int i : integerSet) {
            arr[count] = i;
            count += 1;
        }

        for (int j = integerSet.size(); j < arr.length; j++) {
            arr[j] = -1;
        }


    }


    public static void main(String[] args) {
        // test print
        int[] t1 = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        dedupArray(t1);
        for (int i : t1) {
            System.out.print(i + " ");
        }

        // test cases provided
        int[] t2 = new int[]{0, 0, 1, 4, 5, 5, 5, 8, 9, 9, 10, 11, 15, 15};
        dedupArray(t2);
        int[] t2check = new int[]{0, 1, 4, 5, 8, 9, 10, 11, 15, -1, -1, -1, -1, -1};
        Assert.assertArrayEquals(t2, t2check);

        int[] t3 = new int[]{1, 3, 4, 8, 10, 12};
        dedupArray(t3);
        int[] t3check = new int[]{1, 3, 4, 8, 10, 12};
        Assert.assertArrayEquals(t3, t3check);


        // own test cases with numbers and different cases
        int[] t4 = new int[]{};
        dedupArray(t4);
        int[] t4check = new int[]{};
        Assert.assertArrayEquals(t4, t4check);

        int[] t5 = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        dedupArray(t5);
        int[] t5check = new int[]{-1, 0, 1, -1, -1, -1, -1, -1};
        Assert.assertArrayEquals(t5, t5check);



        System.out.println("Passed test cases");
    }

    // this question took me 25 minutes.
}
