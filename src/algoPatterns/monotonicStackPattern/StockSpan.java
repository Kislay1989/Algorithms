package algoPatterns.monotonicStackPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Problem Statement - Given an array arr[] of daily stock prices, the stock span for the i-th day is the count of
 * consecutive days up to and including day i, such that each of those days had a stock price less than or equal to the
 * price on day i.
 * <p>
 * The idea is to check, for each day, how many consecutive previous days had stock prices less than or equal to the current day’s price.
 * It is a case of stopping at previous greater element.
 */

public class StockSpan {

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};

        List<Integer> span = calculateSpan(arr);
        for (int x : span) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        List<Integer> span = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.empty()) {
                span.set(i, i + 1);
            } else {
                span.set(i, i - stack.peek());
            }

            stack.push(i);
        }

        return span;
    }
}
