package algoPatterns.slidingWindowPattern;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
 *
 * This is a case of sliding window problem as sub-array is in process. So the approach of first initializing the first window will be done.
 * The key idea is -
 * For every window of size k:
 * one deque keeps indices of elements in decreasing order → front gives maximum
 * one deque keeps indices of elements in increasing order → front gives minimum
 * Then for each window:
 * max = arr[maxDeque.peekFirst()]
 * min = arr[minDeque.peekFirst()]
 * add max + min to answer
 * Here deque is used as it lets us:
 * remove from front if index goes out of window
 * remove from back while maintaining order
 * get min/max in O(1) from front
 */

public class SumOfKsubArray {


    public static int SumOfKSubArray(int[] arr, int k) {
        int sum = 0;

        // Will maintain the indices of elements in increasing order
        Deque<Integer> S = new LinkedList<>();
        // Will maintain the indices of elements in decreasing order
        Deque<Integer> G = new LinkedList<>();

        // Process first window of size K
        for (int i = 0; i < k; i++) {
            // Remove all previous greater elements that are useless.
            while (!S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); // Remove from rear

            // Remove all previous smaller that are elements are useless.
            while (!G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); // Remove from rear

            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }

        // Process rest of the Array elements
        for (int i = k; i < arr.length; i++) {
            // Element at the front of the deque 'G' & 'S' is the largest and smallest element of previous window respectively
            sum += arr[S.peekFirst()] + arr[G.peekFirst()];

            // Remove all elements which are out of this window
            while (!S.isEmpty() && S.peekFirst() <= i - k)
                S.removeFirst();
            while (!G.isEmpty() && G.peekFirst() <= i - k)
                G.removeFirst();

            // remove all previous greater element that are useless
            while (!S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); // Remove from rear

            // remove all previous smaller that are elements are useless
            while (!G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); // Remove from rear

            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }

        sum += arr[S.peekFirst()] + arr[G.peekFirst()];

        return sum;
    }

    public static void main(String args[]) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(SumOfKSubArray(arr, k));
    }
}
