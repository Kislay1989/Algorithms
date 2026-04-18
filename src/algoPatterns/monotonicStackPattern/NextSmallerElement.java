package algoPatterns.monotonicStackPattern;

/**
 *
 * Problem Statement :-
 * Given an array, find the next smaller element for each element in the array.
 *
 * The idea is to use a monotonic increasing stack
 * So at any given point of time the stack will always have elements in increasing order from bottom to top.
 * The key concept are -
 * 1.) Since the comparison is done with the elements in right side of array(next elements), the stack will be filled with elements from right to left (n-1 -> 0).
 * 2.) At any given point for an element i, all the elements in stack are elements to its right and in decreasing order from top.
 * 3.) If the stack.top() is less than the current element, then the core requirement for ith element is satisfied, else all the elements from stack will be removed
 *      till top is greater than ith.
 */

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {

    static ArrayList<Integer> nextSmallerElement(int[] arr) {
        int len = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            result.add(-1);
        }

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                // If the top of stack is greater than or equal to current element,
                // then it can't be the next smaller element for current element or any of the elements to left of current element. So pop it.
                stack.pop();
            }
            if (!stack.empty()) {
                result.set(i, stack.peek());
            }

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        ArrayList<Integer> res = nextSmallerElement(arr);
        System.out.println(res);
    }
}
