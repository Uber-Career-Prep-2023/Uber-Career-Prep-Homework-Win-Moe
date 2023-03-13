import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class BackspaceStringCompare {
    // Reset/catch-up two-pointer

      /*
    Question 3: ZeroSumSubArrays

    Time complexity: O(N) - traverses two strings one time each
    Space complexity: O(N) - traverses two strings with two hashmaps created

    Given two strings representing series of keystrokes, determine whether the resulting text is the same.
    Backspaces are represented by the '#' character so "x#" results in the empty string ("").
    */

    // edgecase their string rep is equal, then true
    // edgecase one is empty, then false

    // create hashmap to store values
    // input two strings, output boolean
    // growing shrinking window, continue searching for # after that
    // two while statements each for each string, int pointerFront pointerBack
    // when pointerFront reaches end, stop
    // if pointerFront is # and pointerFront + 1 (if exists) is #, then keep going, an int size would grow
    // this int size would determine how far pointerBack comes and deletes
    // then keep track of which areas to remove in a HashMap?
    // i will define a helper method for this.
    // getall hashmap values and build string based on that
    // check if two strings .equal


    public static boolean BackspaceStringCompare(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1 == "" || s2 == "") {
            return false;
        }

        //get word maps to remove
        String str1 = stringRemove(s1);
        String str2 = stringRemove(s2);
        //substrings based on the maps

        return str1.equals(str2);
    }

    public static String stringRemove(String s) {
        Map<Integer, Integer> values = new HashMap<>();
        int pointerFront = 0;
        int pointerBack = 0;
        int size = 1;

        while (pointerFront < s.length() && pointerBack < s.length()) {
            if (s.charAt(pointerFront) == '#') {
                // check if front pointer should continue moving or
                // move backpointer or that backpointer satisfies size
                if (pointerFront + 1 < s.length() && s.charAt(pointerFront + 1) == '#') {
                    size += 2;
                    pointerFront += 1;
                } else if (pointerBack == pointerFront - size) {
                    values.put(pointerBack, pointerFront);
                    pointerFront += 1;
                    pointerBack = pointerFront;
                } else {
                    pointerBack += 1;
                }
            } else {
                pointerFront += 1;
            }
        }

        StringBuilder str = new StringBuilder("");
        int index = 0;
        boolean inRange = false;
        while (index < s.length()) {
            if (values.containsKey(index)) {
                inRange = true;
            }
            if (values.containsValue(index-1)) {
                inRange = false;
            }

            if (!inRange) {
                str.append(s.charAt(index));
            }

            index += 1;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        // own test cases on helper method
        System.out.println(stringRemove("u#Uber Careee#r Prep"));

        // test cases provided
        Assert.assertTrue(BackspaceStringCompare("abcde", "abcde") == true);
        Assert.assertTrue(BackspaceStringCompare("Uber Career Prep", "u#Uber Careee#r Prep") == true);
        Assert.assertTrue(BackspaceStringCompare("abcdef###xyz", "abcw#xyz") == true);
        Assert.assertTrue(BackspaceStringCompare("abcdef###xyz", "abcdefxyz###") == false);

        // own cases
        Assert.assertTrue(BackspaceStringCompare("aaa###", "abcd####") == true);
        Assert.assertTrue(BackspaceStringCompare("a##a", "b#a") == false);
        Assert.assertTrue(BackspaceStringCompare("1111#222", "111222") == true);

        System.out.println("Passed test cases");
    }
    /*
    This question took me 34 minutes.
    */
}
