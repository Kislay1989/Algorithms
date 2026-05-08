package algoPatterns.dynamicProgramming;

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * A subarray may only include each element of the fixed buffer nums at most once.
 * <p>
 * A circular array means the end of the array connects to the beginning of the array.
 * In a circular array, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 */

public class MaxSubarraySumCircular {


    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int totalSum = 0;
        int maxSum = nums[0];
        int currMaxSum = 0, currMinSum = 0;

        for (int num : nums) {
            int data = currMaxSum + num;
            currMaxSum = Math.max(data, num);

            int data2 = currMinSum + num;
            currMinSum = Math.min(data2, num);

            totalSum = totalSum + num;
        }

        if (totalSum == currMinSum) {
            return maxSum;
        }

        int circularMaxSum = totalSum - currMinSum;

        return Math.max(maxSum, circularMaxSum);
    }
}
