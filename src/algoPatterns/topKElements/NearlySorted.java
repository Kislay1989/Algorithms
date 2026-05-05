package algoPatterns.topKElements;

import java.util.PriorityQueue;

/**
 * Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time.
 * <p>
 * The idea is to use a min heap.
 * If we start placing the correct elements from left to right, then the element for the current position must be
 * within the next k+1 elements, and we don’t need to check the elements to the left.
 * The smallest element in sorted array is at 0 position. According to the given condition, it means that in the unsorted array, the element must be between 0 and 0 + k.
 * So we will insert the first k+1 elements in the min heap and pop the minimum element and add to the array at 0th index. This way we will get the smallest element at 0th index.
 * Then we will insert the next element in the min heap and pop the minimum element and add to the array at 1st index. This way we will get the second smallest element at 1st index.
 * So for any given ith element, the left side of array will be sorted using min heap.
 * Finally, we remove all remaining elements from the heap and add to the array.
 */

public class NearlySorted {

    static void nearlySorted(int[] arr, int k) {
        int length = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        int i;
        for (i = k; i < length; i++) {
            pq.add(arr[i]);
            // Size becomes k+1 so pop it
            // and add minimum element in (i-k) index
            arr[i - k] = pq.poll();
        }

        // Putting remaining elements in array
        while (!pq.isEmpty()) {
            arr[i - k] = pq.poll();
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 6, 5};
        int k = 3;
        nearlySorted(arr, k);
        for (int x : arr)
            System.out.print(x + " ");
    }
}
