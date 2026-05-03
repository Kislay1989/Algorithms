package algoPatterns.twoPointersPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and a target integer, count the number of pairs of integers in the array that have an absolute difference equal to the target.
 */

public class CountPairs {

    public static void main(String[] args) {
        CountPairs cp = new CountPairs();
        int[] arr = {8, 16, 12, 16, 4, 0};
        int target = 4;
        System.out.println(cp.countPairs(arr, target));
    }

    public int countPairs(int[] arr, int target) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int data : arr) {
            int complementA = data - target;
            int complementB = data + target;

            if (freqMap.containsKey(complementA)) {
                count = count + freqMap.get(complementA);
            }
            if (freqMap.containsKey(complementB)) {
                count = count + freqMap.get(complementB);
            }

            freqMap.put(data, freqMap.getOrDefault(data, 0) + 1);
        }

        return count;
    }
}
