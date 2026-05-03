package algoPatterns.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2, 3, 4};
        System.out.println(longestIncreasingSubSequenceBottomUp(arr));

        int[] arr2 = {3, 10, 2, 1, 20};
        System.out.println(longestIncreasingSubSequenceBottomUp(arr2));

        int[] arr3 = {10, 46, 42, 34, 36, 9, 41};
        System.out.println(longestIncreasingSubSequenceBottomUp(arr3));


    }

    /*public static int longestIncreasingSubSequenceTopDown(int[] arr) {
        int max = 1;
        int length = arr.length;
        if (length == 0) {
            return 0;
        }

        for (int i = 1; i < length; i++) {
            max = Math.max(max, lisSubSequenceTopDown(arr, i));
        }

        return max;
    }

    private static int lisSubSequenceTopDown(int[] arr, int index) {
        // base condition
        if (index == 0) {
            return 1;
        }

        for (int prev = 0; prev < index; prev++) {
            if (arr[index] > arr[prev]) {
                return 1 + lisSubSequenceTopDown(arr, prev);
            }
        }
    }*/


    public static int longestIncreasingSubSequenceBottomUp(int[] arr) {
        int max = 1;
        int length = arr.length;
        if (length == 0)
            return 0;

        int[] lis = new int[length];

        Arrays.fill(lis, 1);

        for (int i = 1; i < length; i++) {
            for (int prev = 0; prev < i; prev++) {
                // The key logic is that if the current element (arr[i]) is greater than the element on the left (arr[prev]),
                // then it is a case of increasing subsequence. Here as part of Dynamic Programming, we are relying on the previous state (list[prev]).
                // So State[curr] = state[prev] + 1.
                if (arr[i] > arr[prev]) {
                    lis[i] = Math.max(lis[i], lis[prev] + 1);
                    max = Math.max(max, lis[i]);
                }
            }
        }

        return max;
    }
}
