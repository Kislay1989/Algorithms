package Tree;

import java.util.Stack;

public class MirrorTree {

    /**
     *
     * The approach is to use two stacks to do a simultaneous traversal of both trees.
     * We will be doing a PreOrder traversal of both trees, but for one tree we will be traversing left first and for the other tree we will be traversing right first.
     * This way we can compare the nodes at each step and check if they are mirrors of each other.
     */
    static boolean checkIfMirrorsIteratively(BSTNode root1, BSTNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        Stack<BSTNode> stk1 = new Stack<>();
        Stack<BSTNode> stk2 = new Stack<>();

        // Push roots of both roots
        stk1.push(root1);
        stk2.push(root2);

        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            BSTNode node1 = stk1.pop();
            BSTNode node2 = stk2.pop();

            if (node1.getData() != node2.getData()) {
                return false;
            }

            if (node1.left != null && node2.right != null) {
                stk1.push(node1.left);
                stk2.push(node2.right);
            } else if (node1.left != null || node2.right != null) {
                return false;
            }

            if (node1.right != null && node2.left != null) {
                stk1.push(node1.right);
                stk2.push(node2.left);
            } else if (node1.right != null || node2.left != null) {
                return false;
            }
        }

        // If both stacks are empty, the roots
        // are mirrors
        return stk1.isEmpty() && stk2.isEmpty();
    }
}
