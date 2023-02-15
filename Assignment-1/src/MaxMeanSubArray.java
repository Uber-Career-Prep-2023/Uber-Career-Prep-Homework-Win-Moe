public class MaxMeanSubArray {
/*

"""
Question 1: MaxMeanSubArray

Time complexity: O(n*k)  #traversing through the n array, k times
Space complexity: O(n)   #we are inputting an array

Given an array of integers and an integer, k,
find the maximum mean of a subarray of size k."""

#consider edgecase empty array, return None
#consider edgecase array size is less than size k (similar to empty),
#.  or k is not a valid number we return None
#no need to consider array of other types or other input k

#use sliding window method of size k
#set maxMean to the first mean (we cannot set it to 0 since it's integers)
#iterate from 0 to k, then size-k to size using a while loop
#in the while, use a comparison operator between maxMean and the
#.  computed average (compute by summing each element and dividing)
#return the maximum mean

#this is kind of the brute force solution but I think there's a way for more efficiency
#by storing the previous values in the mean calculation.

def MaxMeanSubArray(arr, k):
  if len(arr) < k or k < 1:
    return None

  maxMeanSum = 0
  for i in range(k):
    maxMeanSum += arr[i]
  maxMean = maxMeanSum / k

  counter = 1
  counterUp = 1+k


  #sliding window
  while counterUp <= len(arr):
    meanSum = 0
    #get the average
    for j in range(counter, counterUp):
      meanSum += arr[j]
    mean = meanSum/k

    if mean > maxMean:
      maxMean = mean

    #increment counter and counterup
    counter += 1
    counterUp += 1

  return maxMean

#test cases provided
assert MaxMeanSubArray([4,5,-3,2,6,1], 2) == 4.5
assert MaxMeanSubArray([4,5,-3,2,6,1], 3) == 3
assert MaxMeanSubArray([1, 1, 1, 1, -1, -1, 2, -1, -1], 3) == 1
assert MaxMeanSubArray([1, 1, 1, 1, -1, -1, 2, -1, -1, 6], 5) == 1
#edgecases
assert MaxMeanSubArray([1], 5) == None
assert MaxMeanSubArray([], 1) == None
#my own cases
assert MaxMeanSubArray([1,2,3], 0) == None
assert MaxMeanSubArray([1,2,3], 1) == 3
assert MaxMeanSubArray([1,2,3], 3) == 2
assert MaxMeanSubArray([-10000,0,10000], 2) == 5000

print("Passed test cases")

"""
This question took me 25 minutes.
"""

 */
}
