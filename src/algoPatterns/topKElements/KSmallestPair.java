package algoPatterns.topKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * The core logic is that since the input arrays are usually sorted, we don't need to check every single combination.
 * Instead, we can use a "Best-First Search" approach.
 * We can use a min heap to keep track of the pairs with the smallest sums.
 * We will initialize the heap with the first element of nums1 paired with each element of nums2 till k.
 * Then, we will repeatedly extract the minimum pair from the heap and add it to the result list.
 */
public class KSmallestPair {

    public static void main(String[] args) {
        int[] arr1 = {1, 7, 11};
        int[] arr2 = {2, 4, 6};
        int k = 3;

        KSmallestPair kSmallestPair = new KSmallestPair();
        List<List<Integer>> res = kSmallestPair.kSmallestPair(arr1, arr2, k);
        System.out.println(res);
    }

    static class Pair implements Comparable<Pair> {
        int sum;
        int index1;
        int index2;

        public Pair(int sum, int index1, int index2) {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.sum, o.sum);
        }
    }

    public List<List<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        if (arr1.length == 0 || arr2.length == 0 || k <= 0) {
            return result;
        }

        for (int i = 0; i < Math.min(arr1.length, k); i++) {
            Pair pair = new Pair(arr1[i] + arr2[0], i, 0);
            minHeap.add(pair);
        }

        while (k > 0 && !minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            result.add(List.of(arr1[pair.index1], arr2[pair.index2]));

            int j = pair.index2 + 1;
            if (j < arr2.length) {
                minHeap.add(new Pair(arr1[pair.index1] + arr2[j], pair.index1, j));
            }

            k--;
        }

        return result;
    }
}
