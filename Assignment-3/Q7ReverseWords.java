import java.util.Stack;

public class Q7ReverseWords {
    // use stack
    // time complexity: O(n) because it loops once through the array
    // space complexity: O(n) because the stack grows as a result of the string

    public static String reverseWords(String str) {
        // nullcase
        if (str == null || str.length() == 0) {
            return "";
        }

        // use stack and a buildup string that will push whenever
        Stack<String> stack = new Stack<>();
        String buildup = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stack.add(buildup);
                buildup = "";
            } else {
                buildup += str.charAt(i);
            }
            // get the last word
            if (i == str.length() - 1) {
                stack.add(buildup);
                break;
            }
        }

        // final string variable that will take things from the stack
        String reverseString = "";
        while (!stack.isEmpty()) {
            reverseString += stack.pop();
            reverseString += " ";
        }

        // need to remove the space from the last string
        return reverseString.substring(0, reverseString.length() - 1);
    }

    public static void main(String[] args) {
        String ucp = reverseWords("Uber Career Prep");
        String ny = reverseWords("Emma lives in Brooklyn, New York.");
        System.out.println(ucp);
        System.out.println(ny);

        System.out.println(reverseWords(" "));
        System.out.println(reverseWords("   "));
        System.out.println(reverseWords(null));
    }
}
