import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstring {
    // Two arrays/strings two-pointer

    /*
    Question 5: ShortestSubstring

    Time complexity: O(n^2) - traverse through quadratic time as each permutation of the letter is checked.
    Space complexity: O(n^2) - takes up multiple hashmap space to compare lettermaps, and multiple substrings.

    Lots of potential for better efficiency.

    Given a string and a second string representing required characters,
    return the length of the shortest substring containing all the required characters.
    */

    /*
    edgecase blank req means we assume shortest of length 0
    if str and req are the same it should instantly return str.length
    what happens if req is not in the string? return -1

    // input 2 String, output String
    // first traverse both strings and get the lettermapping of each in a hashset
    seems like a very inefficient approach
    and use a catch up condition in one string
    go through a nested for loop to check if maps are valid, if less than the minimum then change the minimum
*/

    public static int shortestSubstring(String str, String req) {
        Map<Character, Integer> strMap = getCharMap(str);
        Map<Character, Integer> reqMap = getCharMap(req);

        //get wordmapping in hashset helper method for string and required
        if (req == "") {
            return 0;
        }
        if (str.equals(req)) {
            return str.length();
        }

        //edgecase that strmap doesn't contain, then return -1
        for (char c : reqMap.keySet()) {
            if (!strMap.containsKey(c)) {
                return -1;
            }
        }

        //begin two pointer method
        int pointerFront = 0;
        int pointerBack = 0;

        int minLength = str.length();
        int length = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                Map<Character, Integer> substrMap= getCharMap(str.substring(i, j));
                if (satisfiesMap(substrMap, reqMap) && (j - i) < minLength) {
                    minLength = j - i;
                }
            }
        }
        return minLength;
    }

    // helper method for character mapping
    public static Map<Character, Integer> getCharMap(String word) {
        Map<Character, Integer> charMap = new HashMap<>();

        //traverse, adding to hashmap
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, charMap.get(c) + 1);
            }
        }

        return charMap;

    }

    // helper method for comparing maps
    public static boolean satisfiesMap(Map<Character, Integer> map, Map<Character, Integer> submap) {
        for (char c : submap.keySet()) {
            if (map.get(c) == null || map.get(c) < submap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // make sure helper methods work
        System.out.println(getCharMap("abc"));
        System.out.println(getCharMap("abracadabra"));

        Map<Character, Integer> set = new HashMap<>();
        Map<Character, Integer> subset = new HashMap<>();
        set.put('a', 3);
        set.put('b', 3);
        subset.put('b', 3);

        System.out.println(satisfiesMap(set, subset));


        // first test case print
        System.out.println();
        System.out.println();

        // REAL test cases
        Assert.assertTrue(shortestSubstring("abracadabra", "abc") == 4);
        Assert.assertTrue(shortestSubstring("zxycbaabcdwxyzzxwdcbxyzabccbazyx", "zzyzx") == 10);
        Assert.assertTrue(shortestSubstring("dog", "god") == 3);


        // additional test cases
        Assert.assertTrue(shortestSubstring("aklsdjf", "") == 0);
        Assert.assertTrue(shortestSubstring("abcd", "efgh") == -1);
        Assert.assertTrue(shortestSubstring("winmmoe", "wmo") == 6);

        System.out.println("Passed test cases");
    }

    /*
This question took me a little over 40 minutes - writing test cases.
    */
}
