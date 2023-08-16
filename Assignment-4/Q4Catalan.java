import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4Catalan {
    /*
    Technique: Memoization because we are storing what has already been calculated before
    Time complexity: O(n), we are calculating factorials with a while loop
    Space Complexity: O(n) since hashmap uses linear space

        Question 4: Catalan Numbers
    The Catalan numbers are a mathematical sequence of numbers.
    The nth Catalan number is defined as (2n)! / (n+1)!n!.
    Given a non-negative integer n, return the Catalan numbers 0-n.

    Examples:
    Input: 1
    Output: 1, 1

    Input: 5
    Output: 1, 1, 2, 5, 14, 42
     */
    Map<Integer, Integer> calculated = new HashMap<>();
    // use dynamically programming
    public List<Integer> catalan(int num) {
        List<Integer> result = new ArrayList<>();
        for (int n = 0; n <= num; n++) {
            if (calculated.get(n) == null) {
                int calc = factorial(2 * n) / (factorial(n) * factorial(n + 1));
                result.add(calc);
                calculated.put(n, calc);
            } else {
                result.add(calculated.get(n));
            }
        }
        return result;
    }

    public int factorial(int num) {
        int result = 1;
        for (int factor = 2; factor <= num; factor++) {
            result *= factor;
        }
        return result;
    }

    public static void main(String[] args) {
        Q4Catalan test = new Q4Catalan();
        System.out.println(test.catalan(5));
        System.out.println(test.catalan(1));
        System.out.println(test.catalan(-1));
        System.out.println(test.catalan(15));
    }
}
