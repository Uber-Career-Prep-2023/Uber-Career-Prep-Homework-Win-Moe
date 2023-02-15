public class MaxMeanSubArray {
    /*
    Question 1: MaxMeanSubArray

    Time complexity: O(n^2)  #traversing through the n array, multiple times
    Space complexity: O(n)   #we are inputting an array

    Given an array of integers and an integer, k,
    find the maximum mean of a subarray of size k.
    */

    //input int[] arr, int k, and output double value
    //consider edgecase empty array, throw exception
    //consider edgecase array size is less than size k (similar to empty),
    //.  or k is not a valid number throw exception
    //no need to consider array of other types or other input k

    //use sliding window method of size k
    //set maxMean to the first mean (we cannot set it to 0 since it's integers)
    //iterate from 0 to k, then size-k to size using a while loop
    //in the while, use a comparison operator between maxMean and the
    //.  computed average (compute by summing each element and dividing)
    //return the maximum mean

    //this is kind of the brute force solution but I think there's a way for more efficiency
    //by storing the previous values in the mean calculation.

    //possible efficient implementation by storing the past numbers but no time.

    public static double MaxMeanSubArray(int[] arr, int k) {
        if (arr.length < k || k < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxMeanSum = 0;
        double maxMean = 0;

        //find the meansum of the first three ints
        for (int i = 0; i < k; i++) {
            maxMeanSum += arr[i];
            maxMean = maxMeanSum / k;
        }

        int counter = 1;
        int counterUp = 1 + k;

        //sliding window
        while (counterUp <= arr.length) {
            double meanSum = 0;
            double mean = 0;

            //get the average
            for (int j = counter; j < counterUp; j++) {
                meanSum += arr[j];
                mean = meanSum / k;
            }

            if (mean > maxMean) {
                maxMean = mean;
            }
            //increment counter and counterup
            counter += 1;
            counterUp += 1;
        }

        return maxMean;
    }

    public static void main(String[] args) {
        //test cases provided
        assert MaxMeanSubArray(new int[]{4,5,-3,2,6,1}, 2) == 4.5;

        assert MaxMeanSubArray(new int[]{4,5,-3,2,6,1}, 3) == 3;
        assert MaxMeanSubArray(new int[]{1, 1, 1, 1, -1, -1, 2, -1, -1}, 3) == 1;
        assert MaxMeanSubArray(new int[]{1, 1, 1, 1, -1, -1, 2, -1, -1, 6}, 5) == 1;


        /* EDIT THE ILLEGAL ARGUMENT EXCEPTION ASSERTION ////// ****
        //edgecases
        assert MaxMeanSubArray(new int[]{1}, 5) == new IllegalArgumentException("Invalid input");
        assert MaxMeanSubArray(new int[]{}, 1) == new IllegalArgumentException("Invalid input");

        //my own cases
        assert MaxMeanSubArray(new int[]{1,2,3}, 0) == null;
        */

        assert MaxMeanSubArray(new int[]{1,2,3}, 1) == 3;
        assert MaxMeanSubArray(new int[]{1,2,3}, 3) == 2;
        assert MaxMeanSubArray(new int[]{-10000,0,10000}, 2) == 5000;

        System.out.println("Passed test cases");
    }
    /*
    This question took me 25 minutes.
    */
}
