import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    // Forward/backward two-pointer

    /*
    Question 2: ReverseVowels

Time complexity: O(n) - the pointers only traverse the entire word once.
Space complexity: O(n^2) -  the substrings being replaced and word being new every time will use up space.

Given a string, reverse the order of the vowels in the string.
    */

    // input String, output String
    // already confirms word is string
    // if word of length 1 or below, return word
    // two int pointers - front, and back
    // an Char[] or Set containing vowels a e i o u,
    // used set for contains method, save time and space?
    // while loop that increments front, decrements back
    // break when front >= back aka meet in the middle
    // if charAt is any vowel, stop front, decrement back and check that if
    // swap the letters - how? i used substring.
    // StringBuilder could've been a valid option to save space complexity but I wasn't sure + no time

    public static String reverseVowels(String word) {
        if (word.length() <= 1) {
            return word;
        }
        //create the vowels set to be able to access with O(1) time .contains method
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        // two pointers
        int front = 0;
        int back = word.length() - 1;

        // front < back - 1 because if front and back are the same, the code errors.
        while (front < back) {
            char letterFront = word.charAt(front);
            while (vowels.contains(letterFront) && front < back) {
                char letterBack = word.charAt(back);
                if (vowels.contains(letterBack)) {
                    word = word.substring(0, front) +
                            word.substring(back, back + 1) +
                            word.substring(front + 1, back) +
                            word.substring(front, front + 1) +
                            word.substring(back + 1);
                    //break the second while statement
                    letterFront = '-';
                }
                back -= 1;
            }
            front += 1;
        }

        return word;
    }

    public static void main(String[] args) {
        // first test case print
        System.out.println(reverseVowels("Uber Career Prep"));

        // test cases
        Assert.assertTrue(reverseVowels("Uber Career Prep").equals("eber Ceraer PrUp"));
        Assert.assertTrue(reverseVowels("xyz").equals("xyz"));
        Assert.assertTrue(reverseVowels("flamingo").equals("flominga"));

        // additional test cases

        Assert.assertTrue(reverseVowels("1234").equals("1234"));
        Assert.assertTrue(reverseVowels("aAaeEe").equals("eEeaAa"));
        Assert.assertTrue(reverseVowels("Uber is awesome!!!").equals("ebor es awisemU!!!"));
        Assert.assertTrue(reverseVowels("ue").equals("eu"));
        Assert.assertTrue(reverseVowels("aio").equals("oia"));

        System.out.println("Passed test cases");
    }

    /*
This question took me 32 minutes.
    */
}
