package algoPatterns.slidingWindowPattern;

import java.util.*;

/**
 * Given an array of integers and a number ‘k,’ find the count of distinct numbers in all windows of size ‘k’ in the array.
 */
public class CountDistinctElements {

    ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        res.add(map.size());

        for (int i = k; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            res.add(map.size());
        }

        return res;
    }

    public static void main(String[] args) {
        CountDistinctElements countDistinctElements = new CountDistinctElements();
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println(countDistinctElements.countDistinct(arr, k));
    }

}
