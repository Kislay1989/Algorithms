package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        // Constructed binary tree is
        //          1
        //        /   \
        //      2      3
        //    /  \
        //  4     5
        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        root.left.left = new BSTNode(4);
        root.left.right = new BSTNode(5);

        levelOrderTraversalLineByLine(root);
        levelOrderTraversalLineByLine2(root);
    }


    /**
     * Level order traversal is also known as breadth first traversal.
     * It is done using a queue as we need to process the nodes in the same order they are added to the queue (FIFO).
     * The key thing is to add the left and right child of the current node to the queue before processing the next node (at the same level) in the queue.
     * At any given iteration, we are using a for loop (with size as queue.size()) to process all the nodes at the same level, and then move to next level.
     */
    private static void levelOrderTraversalLineByLine(BSTNode root) {
        if (root == null) {
            return;
        }

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BSTNode curr = queue.poll();
                System.out.print(curr.getData() + " ");

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            System.out.println(" ");
        }
    }

    private static void levelOrderTraversalLineByLine2(BSTNode root) {
        if (root == null) {
            return;
        }

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode curr = queue.poll();
            System.out.print(curr.getData() + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

    }

}