package algoPatterns.monotonicStackPattern;

/**
 *
 * Problem Statement :-
 * Given an array, find the next greater element for each element in the array.
 * The next greater element for an element x is the first greater element on the right side of x in the array.
 * If there is no greater element on the right side of x, then the next greater element for x is -1.
 *
 *
 * The idea is to use a monotonic decreasing stack
 * So at any given point of time the stack will always have elements in decreasing order from bottom to top.
 * The key concept are -
 * 1.) Since the comparison is done with the elements in right side of array(next elements), the stack will be filled with elements from right to left (n-1 -> 0).
 * 2.) At any given point for an element i, all the elements in stack are elements to its right and in increasing order from top.
 * 3.) If the stack.top() is greater than the current element, then the core requirement for ith element is satisfied, else all the elements from stack will be removed
 *      until top is greater than ith.
 *
 *
 *      Complexity Analysis - Time Complexity: O(n) - Each element is pushed and popped at most once.
 */

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int len = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            res.add(-1);
        }

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i]) {
                // If the top of stack is smaller than or equal to current element,
                // then it can't be the next greater element for current element or any of the elements to left of current element. So pop it.
                stack.pop();
            }

            if (!stack.empty()) {
                res.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3, 7, 6};
        //ArrayList<Integer> res = nextLargerElement(arr);
        //System.out.println(res);

        int[] arr2 = {3, 7, 4, 9};
        ArrayList<Integer> res2 = nextLargerElement(arr2);
        System.out.println(res2);
    }

}