package Tree;

import java.util.Stack;

public class PostOrderTraversal {

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

        postOrderTraversalRecursion(root);
        System.out.println(" ");
        postorderTraversalUsingStack(root);
    }

    public static void postOrderTraversalRecursion(BSTNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversalRecursion(root.getLeft());
        postOrderTraversalRecursion(root.getRight());
        System.out.print(root.getData() + " ");
    }

    /**
     * A key thing here in this logic is to use lastVisited node info along with stack.
     * After coming up from processing the left subtree, current node needs to have info if right part is processed or not.
     * So lastVisited is updated after every node has been processed and popped from the stack.
     */
    public static void postorderTraversalUsingStack(BSTNode root) {
        Stack<BSTNode> stack = new Stack<>();
        BSTNode curr = root;
        BSTNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // The key thing to remember at this point is that
            //  Either we reached leftmost node
            // OR
            // We have come back after processing the left subtree
            BSTNode peekNode = stack.peek();
            // So after this step we can now focus on right subtree

            // If right exists and not processed yet → go right
            if (peekNode.right != null && lastVisited != peekNode.right) {
                curr = peekNode.right;
            } else {
                System.out.print(peekNode.getData() + " ");
                lastVisited = stack.pop();
            }
        }
    }
}
