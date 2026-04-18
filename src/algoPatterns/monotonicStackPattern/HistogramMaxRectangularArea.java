package algoPatterns.monotonicStackPattern;

/**
 * You are given a histogram represented by an array arr[ ], where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.
 * Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.
 * Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 * Output: 100
 * Explanation: We get the maximum area by picking bars 50 and 60. The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
 * This algorithm is based on the concept of a monotonic stack, which is a stack that maintains its elements in a specific order - increasing .
 * In this case, we will use a monotonic increasing stack to keep track of the indices of the histogram bars.
 * This is similar to next smaller element approach except that here we are iterating from left to right.
 * The iteration from left to right will continue it the height is in increasing order (and data pushed in stack), once the condition is violated,
 * indicating that for that ith element, that is the right boundary.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class HistogramMaxRectangularArea {

    public static int largestRectangleArea(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            // This is done to handle the case when we have reached the end of the array, we need to pop all the remaining elements from stack and calculate area for them as well.
            // We are adding a dummy bar of height 0 at the end of the histogram as In the stack approach We only calculate area when we find a smaller bar.
            int currentHeight = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && currentHeight < arr[stack.peek()]) {
                int top = stack.pop();
                int height = arr[top];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(largestRectangleArea(arr));

        int[] arr2 = {5, 8, 3, 7, 9, 1};
        System.out.println(largestRectangleArea(arr2));
    }

}
