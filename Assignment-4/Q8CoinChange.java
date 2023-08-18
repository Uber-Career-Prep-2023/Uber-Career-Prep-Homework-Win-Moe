import java.util.LinkedList;
import java.util.Queue;

public class Q8CoinChange {
    //Given a list of coin denominations and a target sum, return the number of possible ways to make change for that sum.
    // Technique: tabulation, we store smaller coins as we go up
    // Time complexity: O(n) only one for loop in the array
    // space complexity: O(n) since only one extra array stored
    public static int coinChange(int[] coins, int sum) {
        int[] ways = new int[sum + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                ways[i] += ways[i - coin];
            }
        }
        return ways[sum];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2,5,10}, 20));
        System.out.println(coinChange(new int[]{2,5,10}, 3));
    }
}
