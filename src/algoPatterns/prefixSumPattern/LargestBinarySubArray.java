package algoPatterns.prefixSumPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] containing only 0s and 1s, find the longest subarray which contains equal no of 0s and 1s.
 */
public class LargestBinarySubArray {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        LargestBinarySubArray largestBinarySubArray = new LargestBinarySubArray();
        System.out.println(largestBinarySubArray.maxLen(arr)); // Output: 6
    }

    public int maxLen(int[] arr) {
        int len = arr.length;
        int max = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        int prefixSum = 0;

        for (int i = 0; i < len; i++) {
            int value = arr[i] == 0 ? -1 : 1; // Treat 0 as -1 and 1 as 1
            prefixSum += value;

            // This condition occurs when the subarray from the start to the current index has equal number of 0s and 1s
            if (prefixSum == 0)
                max = i + 1;

            if (prefixSums.containsKey(prefixSum)) {
                int length = i - prefixSums.get(prefixSum);
                max = Math.max(max, length);
            } else {
                prefixSums.put(prefixSum, i);
            }
        }

        return max;
    }
}
