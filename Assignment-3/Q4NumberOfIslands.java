public class Q4NumberOfIslands {
    //Given a binary matrix in which 1s represent land and 0s represent water.
    // Return the number of islands (contiguous 1s surrounded by 0s or the edge of the matrix).

    // method: breadth first search;
    // time complexity: O(N) because as the array gets bigger
    // the number of traversals will increase linearly according to how many cells need to be visitedd
    // space complexity: O(N) visited array is getting created and uses up linear amounjt of space, same as O(N)

    // time: leetcode took me a while

    public static int numOfIslands(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int islands = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    if (!visited[i][j]) {
                        islands++;
                    }
                    visitNeighboringNodes(arr, visited, i, j);
                }
            }
        }
        return islands;
    }

    public static void visitNeighboringNodes(int[][] arr, boolean[][] visited, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length && arr[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            visitNeighboringNodes(arr, visited, i+1, j);
            visitNeighboringNodes(arr, visited, i-1, j);
            visitNeighboringNodes(arr, visited, i, j+1);
            visitNeighboringNodes(arr, visited, i, j-1);
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Number of islands: " + numOfIslands(arr1)); // Expected output: 3

        int[][] arr2 = {
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Number of islands: " + numOfIslands(arr2)); // Expected output: 3

        int[][] arr3 = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println("Number of islands: " + numOfIslands(arr3)); // Expected output: 3

        int[][] arr4 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println("Number of islands: " + numOfIslands(arr4)); // Expected output: 0
    }
}
