package algoPatterns.monotonicStackPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Circular traversal is a fundamental technique used when you want an array to behave like a ring. When you reach the last element, the next step should take you back to the index 0.
 * The "secret sauce" for this logic is the Modulo Operator (%).
 * We theoretically "double" the array. If the array is [3, 8, 4, 1], we treat it as [5, 7, 1, 2, 6, 5, 7, 1, 2, 6].
 * Hence, we start the iteration from right to left by starting our loop at index (2N - 1) and moving down to 0, we ensure that every element gets to "see" every other element.
 * The addition of next greate element is only done during the first pass (i < N) to ensure that we are not adding next greater element for the elements in second pass.
 */

public class NextGreaterElementCircularArray {

    public static ArrayList<Integer> nextGreaterCircular(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(-1);
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int pos = i % n;
            int curr = arr[pos];
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            // Only add next greater element for the first pass (i < N) to avoid adding next greater element for the elements in second pass.
            if (i < n && !st.isEmpty()) {
                res.set(i, st.peek());
            }

            st.push(curr);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 6};
        ArrayList<Integer> res = nextGreaterCircular(arr);
        System.out.println(res);
    }
}
