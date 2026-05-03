package algoPatterns.twoPointersPattern;

import java.util.Arrays;

public class TripletSum {

    public boolean hasTripletSum(int arr[], int target) {
        boolean hasTriplet = false;
        int len = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;

            int requiredSum = target - arr[i];
            while (left < right) {
                int currSum = arr[left] + arr[right];
                if (currSum == requiredSum) {
                    hasTriplet = true;
                    break;
                } else if (currSum < requiredSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return hasTriplet;
    }
}
