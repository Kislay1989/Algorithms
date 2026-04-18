package algoPatterns.greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
 * The cost to connect two ropes is the sum of their lengths.
 * <p>
 * The solution is here to follow the greedy approach. So at every iteration we are computing the min cost of connection.
 * The idea is that at any ith iteration connect the two smallest ropes ,
 * and so on until all ropes are connected.
 * We will use a min heap (priority queue) to get the two smallest ropes at every iteration.
 */

public class MinCostOfRopes {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }

    public static int minCost(int[] arr) {
        int len = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);
        }

        return totalCost;
    }
}
