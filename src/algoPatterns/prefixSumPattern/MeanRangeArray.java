package algoPatterns.prefixSumPattern;

import java.util.ArrayList;

/**
 * You are given an array arr[] consisting of n positive integers and a set of q queries represented by a 2D array queries queries[][]. Each query contains two integers l and r,
 * indicating a range of indices in the array.
 * <p>
 * For every query, calculate the mean of the elements in the subarray from index l to index r (inclusive). After computing the mean, return its floor value.
 */

public class MeanRangeArray {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[][] queries = {{0, 2}, {1, 3}, {0, 4}};

        MeanRangeArray meanRangeArray = new MeanRangeArray();
        ArrayList<Integer> result = meanRangeArray.findMean(arr, queries);
        System.out.println(result); // Output: [2, 3, 3]
    }

    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {

        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            int sum = prefixSum[end + 1] - prefixSum[start];
            int count = end - start + 1;

            result.add(sum / count); // floor value of mean
        }


        return result;
    }
}
