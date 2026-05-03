package algoPatterns.twoPointersPattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfPairEqualToTarget {

    static boolean twoSum(int[] arr, int target) {
        boolean isPairFound = false;
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                isPairFound = true;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return isPairFound;
    }

    static boolean twoSum2(int[] arr, int target) {
        boolean isPairFound = false;
        Set<Integer> set = new HashSet<>();

        for (int data : arr) {
            int complement = target - data;
            if (set.contains(complement)) {
                isPairFound = true;
                break;
            }
            set.add(data);
        }

        return isPairFound;
    }
}
