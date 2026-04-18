package algoPatterns.prefixSumPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * <p>
 * A good subarray is a subarray where:
 * <p>
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * <p>
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */

public class ContinuousSubArraySum {
    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubArraySum(arr, k));

        int[] arr2 = {2, 4, 6, 7, 8};
        int k2 = 6;
        System.out.println(checkSubArraySum(arr2, k2));

        int[] arr3 = {7, 2, 4, 6, 7, 8};
        int k3 = 6;
        System.out.println(checkSubArraySum(arr3, k3));
    }

    /**
     * The Core Concept here is - If two prefix sums have the same remainder when divided by k, then the subarray between them has sum divisible by k.
     * Memory Trick (for quick recall) - "Same remainder ⇒ divisible subarray exists in between"
     * S1 = a*k + r
     * S2 = b*k + r
     * S2 - S1 = (b*k + r) - (a*k + r)
     *         = (b - a)*k
     * So S2 - S1 is divisible by k
     */
    public static boolean checkSubArraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        // remainder 0 at index -1 helps handle sub-arrays starting from index 0
        remainderIndexMap.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder;
            if (k != 0) {
                remainder = prefixSum % k;
            } else {
                remainder = prefixSum; // when k = 0, cannot do modulo
            }

            if (remainderIndexMap.containsKey(remainder)) {
                int prevIndex = remainderIndexMap.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                remainderIndexMap.put(remainder, i);
            }
        }

        return false;
    }
}
