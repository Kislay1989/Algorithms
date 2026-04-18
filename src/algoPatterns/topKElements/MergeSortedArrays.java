package algoPatterns.topKElements;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Statement - Given a 2D array where each row is sorted in increasing order, merge all the rows into a single sorted list.
 *
 * The idea is to use a min heap (priority queue) to keep track of the smallest elements from each row.
 * We will initialize the heap with the first element of each row,
 * and then repeatedly extract the minimum element from the heap and add it to the result list.
 * After extracting an element, we will add the next element from the same row to the heap until we have processed all elements.
 *
 */

public class MergeSortedArrays {

    static class Element implements Comparable<Element> {
        int val;
        int row;
        int col;

        public Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element element) {
            return Integer.compare(this.val, element.val);
        }
    }

    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Element> heap = new PriorityQueue<>();

        int rowLen = mat.length;
        for (int i = 0; i < rowLen; i++) {
            if (mat[i].length > 0) {
                heap.add(new Element(mat[i][0], i, 0));
            }
        }

        while (!heap.isEmpty()) {
            Element e = heap.poll();
            res.add(e.val);
            if (e.col + 1 < mat[e.row].length) {
                heap.add(new Element(mat[e.row][e.col + 1], e.row, e.col + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[][] mat = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        System.out.println(mergeSortedArrays.mergeArrays(mat));
    }

}
