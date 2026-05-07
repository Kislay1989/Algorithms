package algoPatterns.topKElements;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Time Complexity: O(n log k), where n is the total number of nodes across all lists and k is the number of linked lists.
 */

public class MergeKLists {


    static class Node implements Comparable<Node> {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.data, o.data);
        }
    }

    Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (Node head : arr) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        Node head = minHeap.peek();
        Node prev = null;

        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            if (prev != null) {
                prev.next = minNode;
            }
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
            prev = minNode;
        }

        return head;
    }
}
