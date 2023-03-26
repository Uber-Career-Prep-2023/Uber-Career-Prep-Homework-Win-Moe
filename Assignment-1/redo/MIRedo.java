package redo;

public class MIRedo {
    // Binary search variation

    /*
    Question 6: MissingInteger

    Did not get the answer.

    Time complexity: O(n) - It checks every element.
    Space complexity: O(n) - it would create an array every time we call the algorithm.

    Given an integer n and a sorted array of integers of size n-1
    which contains all but one of the integers in the range 1-n, find the missing integer.
    */

    /*
    i drew out a diagram, so basically check element in the middle,
    we can check if the middle is left or right leaning so that can continue searching ONE side.\
    I tried this binary search method but I think it will take too much time. I'll do it later.

    */

        public static int missingInteger(int[] arr, int n) {
            // assume - empty means 1 is missing
            if (arr.length == 0 || arr.length == n) {
                return 1;
            }

            // if arr length is n means nothing is missing and return -1
            if (arr.length == n) {
                return -1;
            }

            // binary search variation pointers, right begins at n-2 because one value is missing and index goes until n-1
            int left = 0;
            int right = n - 2;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int expectedValue = mid + 1;
                int actualValue = arr[mid];
                if (actualValue != expectedValue) {
                    // The missing number is in the left half
                    right = mid - 1;
                } else {
                    // The missing number is in the right half
                    left = mid + 1;
                }
            }
            return left + 1;
        }
        public static void main(String[] args) {

            // first test case print
            int[] gg = {1,2,3,5,6,7};
            int result = (missingInteger(gg, 7));

            System.out.println(result);


            // REAL test cases
            System.out.println(missingInteger(new int[]{1,2,3,5,6,7}, 7)); // == 4);
            System.out.println(missingInteger(new int[]{1}, 2)); // == 2);
            System.out.println(missingInteger(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12}, 12)); // == 9);

            // additional test cases
            System.out.println(missingInteger(new int[]{}, 1)); // == 1);
            System.out.println(missingInteger(new int[]{1,2,3,4,5,6,7,8,9,10}, 11) ); //== 11);


            System.out.println("passed test cases");
        }

    /*
This question took 40 minutes, didn't finish - writing test cases.
    */
}
