import java.util.*;
public class Q9MergeKSortedArrays {
    // used arraylist
    // time complexity: O(n^2) - sort of like selection sort for multiple arraylists
    // space complexity: O(n) - perhaps not too much extra space?

    // time: probably like 40 min

    public static List<Integer> sort(int k, List<List<Integer>> intLists) {
        List<Integer> result = new ArrayList<>();
        Map<List<Integer>, Integer> status = new HashMap<>();

        for (List<Integer> li : intLists) {
            status.put(li, 0);
        }
        int min = 0;
        int minI = -1;

        boolean stop = false;
        while (stop == false) {
            min = Integer.MAX_VALUE;
            // check
            stop = true;
            for (List<Integer> li : intLists) {
                if (status.get(li) < li.size()) {
                    stop = false;
                }
            }

            // get the index
            for (int i = 0; i < k; i++) {
                List<Integer> currList = intLists.get(i);
                if (status.get(currList) < currList.size()) {
                    if (currList.get(status.get(currList)) < min) {
                        min = currList.get(status.get(currList));
                        minI = i;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                break;
            }
            result.add(min);
            status.put(intLists.get(minI), status.get(intLists.get(minI)) + 1);
            System.out.println(status);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfListOfIntegers = new ArrayList<>();

        List<Integer> list1 = List.of(1, 4, 7, 9);
        List<Integer> list2 = List.of(2, 6, 7, 10, 11, 13, 15);
        List<Integer> list3 = List.of(3, 8, 12, 13, 16);

        listOfListOfIntegers.add(list1);
        listOfListOfIntegers.add(list2);
        listOfListOfIntegers.add(list3);

        List<Integer> sortedList = sort(3, listOfListOfIntegers);
        System.out.println(sortedList);
    }
}

