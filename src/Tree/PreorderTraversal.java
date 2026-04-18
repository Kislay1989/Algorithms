package Tree;

import java.util.Stack;

/**
 * Use Case - Evaluation of Prefix Expressions.
 * A prefix expression is of the form "operator operand1 operand2" (e.g., +ab), where the operator is written before its two operands.
 * ["+", "*", "/", "+", "100", "200", "2", "5", "7"]
 * The operation becomes - (((100 + 200) / 2) * 5) + 7
 */

public class PreorderTraversal {

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

        preOrderTraversalRecursion(root);
        System.out.println(" ");
        preOrderTraversalWithoutRecursion(root);
    }

    public static void preOrderTraversalRecursion(BSTNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        preOrderTraversalRecursion(root.getLeft());
        preOrderTraversalRecursion(root.getRight());
    }

    public static void preOrderTraversalWithoutRecursion(BSTNode root) {
        if (root == null) {
            return;
        }

        Stack<BSTNode> stack = new Stack<>();
        stack.push(root);

        BSTNode curr;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr.getData() + " ");

            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }
            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }

    }

}
