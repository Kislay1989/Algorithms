package algoPatterns.topKElements;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a 2D array points[][] and an integer k, where each element of points represents a point [xi, yi] on the X-Y plane,
 * find the k points that are closest to the origin (0,0) in any order.
 * <p>
 * Approach 1:
 * We can use a min heap to keep track of the closest points. We will calculate the distance of each point from the origin and add it to the heap.
 * After iterating through all the points, we will extract the top k elements from the heap, which will be the closest points to the origin.
 * However, this approach has a time complexity of O(n log n) due to the need to sort all the points based on their distance from the origin.
 * <p>
 * Approach 2:
 * We can use a max heap to keep track of the k closest points. We will iterate through the points and calculate their distance from the origin.
 * So we will add the points to the max heap and if the size of the heap exceeds k, we will remove the point with the largest distance from the heap.
 * So removing elements larger than k, means we have n-k largest elements removed, leaving us with k smallest elements in the heap.
 * So the top element is n-k largest element or the kth smallest element.
 */
public class KClosestPointsToOrigin {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y; // Calculate the distance from the origin

            maxHeap.add(new Point(x, y, distance));
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the point with the largest distance
            }
        }

        int[][] res = new int[k][2];
        while (!maxHeap.isEmpty()) {
            Point point = maxHeap.poll();
            res[--k] = new int[]{point.x, point.y};
        }

        return res;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] res = kClosestPointsToOrigin.kClosest(points, k);
        for (int[] point : res) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }

        int[][] points2 = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        res = kClosestPointsToOrigin.kClosest(points2, k);
        for (int[] point : res) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

}
