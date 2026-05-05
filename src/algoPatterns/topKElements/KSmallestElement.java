package algoPatterns.topKElements;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of integers arr and an integer k, find the kth smallest element in the array.
 * The idea is to maintain a max heap of size k. We iterate through the array and add elements to the heap.
 * The key approach is -
 * 1.) The Kth smallest element in a sorted array of size K is the largest element.
 * 2.) So for every iteration we maintain a max heap of size K.
 * 3.) For every iteration, when the 5th element is inserted , the largest element is polled out, leaving the 4 smallest elements in the heap.
 *
 * If the size of the heap exceeds k, we remove the maximum element from the heap.
 * This way, we ensure that the heap always contains the k smallest elements seen so far.
 * At the end of the iteration, the root of the max heap will be the kth smallest element in the array.
 */

public class KSmallestElement {

    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val : arr) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KSmallestElement kSmallestElement = new KSmallestElement();
        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4;
        System.out.println(kSmallestElement.kthSmallest(arr, k));
    }
}
