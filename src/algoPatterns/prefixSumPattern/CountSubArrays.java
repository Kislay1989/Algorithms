package algoPatterns.prefixSumPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers arr and an integer k, return the total number of continuous sub-arrays whose sum equals to k.
 */

public class CountSubArrays {

    public static void main(String[] args) {
        /*int[] arr = {10, 2, -2, -20, 10};
        int k = -10;

        System.out.println(countSubArrays.countSubArrays(arr, k)); // Output: 3*/
        CountSubArrays countSubArrays = new CountSubArrays();

        int[] arr2 = {9, 4, 20, 3, 10, 5};
        int k2 = 33;
        System.out.println(countSubArrays.countSubArrays(arr2, k2)); // Output: 2
    }

    /**
     * Here instead of using an array as buffer for prefix sum, we will be using a HashMap to store the count of prefix sums encountered so far.
     * The core idea is that to identify if there is an array with sum k, we need to identify if there are 2 such prefix sums, whose difference is equal to k.
     * Normally doing this would mean scanning the array for every prefix sum, which would lead to O(n^2) time complexity.
     * But if we store the count of prefix sums in a HashMap, then we can identify such prefix sums in O(1) time,
     * leading to an overall O(n) time complexity.
     * P[i] - P[j] = k => P[j] = P[i] - k
     */
    public int countSubArrays(int[] arr, int total) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum so far.
            currSum += arr[i];

            // If currSum is equal to desired sum
            // then a new subarray is found.
            if (currSum == total)
                res++;

            // Check if the difference exists in the prefixSums map.
            if (prefixSums.containsKey(currSum - total))
                res += prefixSums.get(currSum - total);

            // Add currSum to the set of prefix sums.
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }

}
