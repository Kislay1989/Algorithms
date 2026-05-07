package algoPatterns.topKElements;

import java.util.*;

/**
 * Given an array arr[] and a positive integer k, Find the top k elements which have the highest frequency in the array.
 *
 * The idea is to use a min heap (priority queue) to keep track of the top k elements based on their frequency.
 * 1.) We will first create a frequency map to count the occurrences of each element in the array.
 * 2.) Then, we will iterate through the frequency map and add each element along with its frequency to the min heap.
 * 3.) If the size of the heap exceeds k, we will remove the element with the lowest frequency (the root of the min heap).
 * 4.) After processing all elements in the frequency map, the min heap will contain the top k elements with the highest frequency.
 */

public class TopKFrequency {

    /*
   Given an array of integers, find the top K frequent elements in it.
    */
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        TopKFrequency topKFrequency = new TopKFrequency();
        ArrayList<Integer> res = topKFrequency.topKFreq(arr, k);
        System.out.println(res);

        res = topKFrequency.topKFreq2(arr, k);
        System.out.println(res);
    }

    static class Element implements Comparable<Element> {
        int value;
        int frequency;

        public Element(int value, int index) {
            this.value = value;
            this.frequency = index;
        }

        @Override
        public int compareTo(Element o) {
            if (this.frequency == o.frequency) {
                return Integer.compare(o.value, this.value);
            }
            return Integer.compare(this.frequency, o.frequency);
        }
    }

    private ArrayList<Integer> topKFreq2(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Element> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1.frequency == o2.frequency) {
                return Integer.compare(o2.value, o1.value);
            }
            return Integer.compare(o2.frequency, o1.frequency);
        });

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry entry : frequencyMap.entrySet()) {
            heap.add(new Element((int) entry.getKey(), (int) entry.getValue()));
        }

        while (k > 0 && !heap.isEmpty()) {
            res.add(heap.poll().value);
            k--;
        }

        return res;
    }

    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Element> heap = new PriorityQueue<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry entry : frequencyMap.entrySet()) {
            heap.add(new Element((int) entry.getKey(), (int) entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            res.add(heap.poll().value);
        }

        return res;
    }
}
