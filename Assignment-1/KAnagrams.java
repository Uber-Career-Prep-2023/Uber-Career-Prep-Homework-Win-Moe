import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class KAnagrams {
    // Two arrays/strings increment/decrement hashmap counts
    /*
    Question 7: KAnagrams

    Time complexity:
    Space complexity:

    Two strings are considered to be “k-anagrams”
    if they can be made into anagrams by changing at most k characters in one of the strings.
    Given two strings and an integer k, determine if they are k-anagrams.

    */

    // edgecases: assert length must be the same, assume we don't accept this by returning false
    // are we assuming anagrams only replaces characters instead of adding on new ones?
    // I assumed that in that case their length must be the same.

    // another edgecase - are we going to make them lowercase? anagrams have same character but different case.
    // so I assume that we only want to compare lowercases and made both strings into lowercase, using the String toLowercase() method.
    // what happens if numbers or symbols are in the string?
    // I assume they would act in the same way as characters so didn't change them at all.

    // if both empty return -1
    // input two strings, and an int, return boolean
    // int counter variable to compare against k
    // first create hashmap, increase the key value pairs by first input string's character mapping
    // decrease the key value pairs by second input string character mapping
    // for every 2 changes we make, we add one to the counter.

    // cannot use helper function to make the char mapping with a for loop
    // loop through the keymap and count up absolute values -
    // absolute value divided by two returns the number of changes needed
    // use math.abs from java Math library.

    public static boolean kAnagrams(String str1, String str2, int k) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1 == "" && str2 == "") {
            return false;
        }
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int counter = 0;

        Map<Character, Integer> charmap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (charmap.containsKey(c1)) {
                charmap.put(c1, charmap.get(c1) + 1);
            } else {
                charmap.put(c1, 1);
            }

            if (charmap.containsKey(c2)) {
                charmap.put(c2, charmap.get(c2) - 1);
            } else {
                charmap.put(c2, -1);
            }
        }

        // testing
        // System.out.println(charmap);

        for (char c : charmap.keySet()) {
            counter += Math.abs(charmap.get(c));
        }
        return k >= counter / 2;
    }


    public static void main(String[] args) {
        // test print
        System.out.println(kAnagrams("apple", "peach", 1));

        // test cases provided
        Assert.assertTrue(kAnagrams("apple", "peach", 1) == false);
        Assert.assertTrue(kAnagrams("apple", "peach", 2) == true);
        Assert.assertTrue(kAnagrams("cat", "dog", 3) == true);
        Assert.assertTrue(kAnagrams("debit curd", "bad credit", 1) == true);
        Assert.assertTrue(kAnagrams("baseball", "basketball", 2) == false);

        // own test cases with numbers and different cases
        Assert.assertTrue(kAnagrams("1234***", "1234567", 2) == false);
        Assert.assertTrue(kAnagrams("1234***", "1234567", 3) == true);
        Assert.assertTrue(kAnagrams("Uber@SanFrancisco", "uber#franciscosan", 1) == true);


        System.out.println("Passed test cases");
    }

    // this question took me 22 minutes.
}
