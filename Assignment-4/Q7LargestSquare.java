public class Q7LargestSquare {
    // Question 7: LargestSquareOf1s
    // Given a square matrix of 0s and 1s, find the dimension of the largest square consisting only of 1s.
    // Technique: Tabulation store the results of lower lengths until we reach the largest
    // Time complexity: I believe it would be O(n^2) since there are two for loops
    // space complexity: O(n) since it only stores the array
    public int largestSquare(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = arr[i][j];
                } else if (arr[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }




    public static void main(String[] args) {
        Q7LargestSquare ls = new Q7LargestSquare();
        int[][] binaryArray = {
                {0, 1, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        };

        int[][] arr = {
                {0, 1, 0, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0}
        };


        System.out.println(ls.largestSquare(binaryArray));
        System.out.println(ls.largestSquare(arr));
    }
}
