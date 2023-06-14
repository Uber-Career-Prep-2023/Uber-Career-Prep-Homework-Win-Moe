import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q9MergeKSortedArrays {
    public static List<Integer> sort(int k, List<List<Integer>> intLists) {
        // selection sort variation;
        // use hashmap to map the index;
        boolean complete = false;
        List<Integer> finalList = new ArrayList<>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        int timesToRun = 0;
        for (List<Integer> li : intLists) {
            map.put(li, 0);
            timesToRun += li.size();
        }

        int min = intLists.get(0).get(map.get(intLists.get(0)));

        for (int t = 0; t < timesToRun; t++) {
            int minai = 0;
            System.out.println(t + " / " + timesToRun);
            for (int i = 0; i < k; i++) {

                List<Integer> currList = intLists.get(i);
                if (map.get(currList) < currList.size()) {
                    // get current index
                    if (currList.get(map.get(currList)) < min) {
                        minai = i;
                    }
                }
            }
            List<Integer> minarr = intLists.get(minai);
            finalList.add(minarr.get(map.get(minarr)));
            map.put(minarr, map.get(minarr) + 1);
        }
        System.out.println(finalList);
        return finalList;
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfListOfIntegers = new ArrayList<>();

        List<Integer> list1 = List.of(1, 4, 7, 9);
        List<Integer> list2 = List.of(2, 6, 7, 10, 11, 13, 15);
        List<Integer> list3 = List.of(3, 8, 12, 13, 16);

        listOfListOfIntegers.add(list1);
        listOfListOfIntegers.add(list2);
        listOfListOfIntegers.add(list3);

        sort(3, listOfListOfIntegers);
    }


}
