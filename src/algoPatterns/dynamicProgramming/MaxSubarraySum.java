package algoPatterns.dynamicProgramming;

public class MaxSubarraySum {

    /**
     * Given an array of integers, find the maximum sum of a contiguous subarray.
     *
     * At any given ith state, we add the current element to the maximum sum of the previous state (i-1) and compare it with the current element itself.
     * If the result is greater than the current element, then we will continue with the previous state and add the current element to it.
     * Otherwise, we will start a new subarray from the current element.
     */

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};

        System.out.println(maxSubarraySum(arr));

        int[] arr2 = {-3, -2, -6, -1, -7, -4};
        System.out.println(maxSubarraySum(arr2));
    }

    public static int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int result = maxSoFar + arr[i];
            maxSoFar = Math.max(result, arr[i]);

            maxSum = Math.max(maxSum, maxSoFar);
        }

        return maxSum;
    }
}
