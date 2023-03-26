package redo;

import java.util.*;

public class BSSCompareRedo {
    // Reset/catch-up two-pointer

      /*
    Question 4: BackspaceStringCompare

    Time complexity: O(N) - traverses two strings one time each
    Space complexity: O(1) - traverses two strings with two hashmaps created

    Given two strings representing series of keystrokes, determine whether the resulting text is the same.
    Backspaces are represented by the '#' character so "x#" results in the empty string ("").
    */

    public static boolean BackspaceStringCompare(String s1, String s2) {
        String c1 = stringRemove(s1);
        String c2 = stringRemove(s2);
        if (c1.equals(c2)) {
            return true;
        }
        return false;
    }

    public static String stringRemove(String s) {
        char[] carr = s.toCharArray();

        int pointerFront = 0;
        int pointerBack = 0;
        int size = 1;

        while (pointerFront < s.length() && pointerBack < s.length()) {
            if (s.charAt(pointerFront) == '#') {
                if (pointerFront + 1 < s.length() && s.charAt(pointerFront + 1) == '#') {
                    // check if front pointer should continue moving or
                    // move backpointer or that backpointer satisfies size
                    size += 2;
                    pointerFront += 1;
                } else if (pointerBack == pointerFront - size) {
                    // case that pointerBack has reached

                    // for loop telling pointerFront pointerBack to make the values null
                    for (int i = pointerBack; i < pointerFront; i++) {
                        // i couldnt make the value null
                        carr[i] = '#';
                    }

                    // reset values
                    pointerFront += 1;
                    pointerBack = pointerFront;
                } else {
                    // increment pointerBack to match the size
                    pointerBack += 1;
                }
            } else {
                // else keep moving
                pointerFront += 1;
            }
        }
        List<Character> clist = new ArrayList<>();
        for (char ch : carr) {
            if (ch != '#') {
                clist.add(ch);
            }
        }

        char[] charArray = new char[clist.size()];
        for (int i = 0; i < clist.size(); i++) {
            charArray[i] = clist.get(i);
        }
        //return
        return new String(charArray);
    }

    public static void main(String[] args) {
        // own test cases on helper method
        System.out.println(stringRemove("u#Uber Careee#r Prep"));

        // test cases provided
        System.out.println(BackspaceStringCompare("abcde", "abcde") == true);
        System.out.println(BackspaceStringCompare("Uber Career Prep", "u#Uber Careee#r Prep") == true);
        System.out.println(BackspaceStringCompare("abcdef###xyz", "abcw#xyz") == true);
        System.out.println(BackspaceStringCompare("abcdef###xyz", "abcdefxyz###") == false);

        // own cases
        System.out.println(BackspaceStringCompare("aaa###", "abcd####") == true);
        System.out.println(BackspaceStringCompare("a##a", "b#a") == false);
        System.out.println(BackspaceStringCompare("1111#222", "111222") == true);

        System.out.println("Passed test cases");
    }
    /*
    This question took me 34 minutes.
    */
}

