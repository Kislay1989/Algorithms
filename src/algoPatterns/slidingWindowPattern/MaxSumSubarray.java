package algoPatterns.slidingWindowPattern;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 *
 *
 */

public class MaxSumSubarray {

    public int maxSubarraySum(int[] arr, int k) {
        int len = arr.length;
        if (k <= 0 || k > len) {
            return 0;
        }

        int windowSum = 0;
        int max;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        max = windowSum;

        // Slide window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            max = Math.max(max, windowSum);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSumSubarray maxSumSubarray = new MaxSumSubarray();
        int[] arr = {100, 200, 300, 400};
        int k = 2;
        System.out.println(maxSumSubarray.maxSubarraySum(arr, k));

        int[] arr2 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k2 = 4;
        System.out.println(maxSumSubarray.maxSubarraySum(arr2, k2));
    }

}
