import org.antlr.v4.runtime.tree.Tree;
import org.junit.Assert;

import java.util.*;

public class MergeIntervals {
    // sort then solve.

    /*
    Time complexity:
    Space complexity:

    Question 8: MergeIntervals
    Given a list of integer pairs representing the low and high end of an interval, inclusive,
    return a list in which overlapping intervals are merged.
    */

    // input List, output List,
    // how will it be represented?
    // use list of maps with only one key value pair each.
    // in python it would be tuple, but i don't know any java tuples.

    // sort the treemaps by key value pair.

    public static List<Map<Integer, Integer>> mergeIntervals(List<Map<Integer, Integer>> input) {
        //getting sorted
        List<Integer> toSort = new ArrayList<>();

        for (Map<Integer, Integer> map : input) {
            for (int i : map.keySet()) {
                toSort.add(i);
            }
        }

        Collections.sort(toSort);

        //now based on that sorted keyset, we will sort the entire list based on keys
        List<Map<Integer, Integer>> inputSorted = new ArrayList<>();

        for (int i : toSort) {
            for (int j = 0; j < input.size(); j++) {
                if (input.get(j).containsKey(i)) {
                    inputSorted.add(input.get(j));
                }
            }
        }

        return inputSorted;
                //List<Map<Integer, Integer>>

        Input: [(2, 3), (4, 8), (1, 2), (5, 7), (9, 12)]
        Output: [(4, 8), (1, 3), (9, 12)]

    }
    public static void main(String[] args) {
        // test print
        System.out.println(mergeIntervals());

        // test cases provided

        // own test cases with numbers and different cases
        Assert.assertTrue(mergeIntervals("Uber@SanFrancisco", "uber#franciscosan", 1) == true);


        System.out.println("Passed test cases");
    }

    // this question took me ___ minutes.
}
