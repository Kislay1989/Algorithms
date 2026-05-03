package algoPatterns.monotonicStackPattern;

/**
 * You are given a histogram represented by an array arr[ ], where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.
 * Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.
 * Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 * Output: 100
 * Explanation: We get the maximum area by picking bars 50 and 60. The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
 *
 * The key ideas here are -
 * 1.) Use a stack and stores indices of bars in increasing height order.
 * 2.) Whenever we find a smaller bar, it means bars taller than this cannot extend further right, so we stop to calculate this area
 *
 * This algorithm is based on the concept of a monotonic stack, which is a stack that maintains its elements in a specific order - increasing .
 * In this case, we will use a monotonic increasing stack to keep track of the indices of the histogram bars.
 * This is similar to next smaller element approach except that here we are iterating from left to right.
 * The iteration from left to right will continue it the height is in increasing order (and data pushed in stack), once the condition is violated,
 * indicating that for that ith element, that is the right boundary.
 */

import java.util.*;


public class HistogramMaxRectangularArea {

    public static int largestRectangleArea(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int currIndex = 0; currIndex <= n; currIndex++) {
            // This is done to handle the case when we have reached the end of the array, we need to pop all the remaining elements from stack and calculate area for them as well.
            // We are adding a dummy bar of height 0 at the end of the histogram as In the stack approach We only calculate area when we find a smaller bar.
            int currentHeight = (currIndex == n) ? 0 : arr[currIndex];

            while (!stack.isEmpty() && currentHeight < arr[stack.peek()]) {
                // Larger elements are useless once a smaller one appears → so we remove them and use as height of rectangle and calculate area for them.
                int top = stack.pop();
                int height = arr[top];

                int rightIndex = currIndex;
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                /* Why width = right - left - 1
                Because:   - right is the first smaller bar on the right (as we stop when currIndex < stack.peek())
                           - for the left boundary as the stack has indices of bars in increasing order, we compare each stack.peek and if it is bigger than current,
                                then a rectangle can be formed between them (and area is calculated), this iteration continues until we find a smaller bar on the left (than current height)
                                and that is the left boundary
                           rectangle can only exist between them
                           So usable width is the bars in between.
                 */
                int width = stack.isEmpty() ? currIndex : rightIndex - leftIndex - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(currIndex);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        //int[] arr = {60, 20, 50, 40, 10, 50, 60};
        //System.out.println(largestRectangleArea(arr));

        int[] arr2 = {5, 8, 11, 14, 9};
        System.out.println(largestRectangleArea(arr2));
    }

}
