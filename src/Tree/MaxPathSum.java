package Tree;

public class MaxPathSum {

    /**
     * The maximum path sum in a binary tree is the largest sum of values along any path in the tree.
     * A path can start and end at any node in the tree, and it must contain at least one node. The path does not need to go through the root, and it can go in any direction (up or down).
     */
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

        int[] res = new int[1];
        int maxSum = findMaxPathSum(root, res);
        System.out.println("Max Path Sum: " + maxSum);
    }

    private static int findMaxPathSum(BSTNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, findMaxPathSum(root.left, res));
        int right = Math.max(0, findMaxPathSum(root.right, res));

        res[0] = Math.max(res[0], left + right + root.data);

        return Math.max(left, right) + root.data;
    }
}
