package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

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

        ArrayList<Integer> res = inOrderTraversalIterative(root);
        printList(res);

        res = inOrderTraversalIterativelyWithoutStack(root);
        printList(res);
    }

    static void printList(ArrayList<Integer> v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void inOrderTraversalRecursion(BSTNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversalRecursion(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrderTraversalRecursion(root.getRight());
    }

    /**
     * A key thing here while using a stack is that only when moving to left, we push the current node in stack.
     * While moving to right, we do not push the current node in stack as we have already visited it, and we are done with it.
     */
    public static ArrayList<Integer> inOrderTraversalIterative(BSTNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<BSTNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }

        BSTNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // First reach the left most Node of the curr Node
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }

            // At this point curr is always null
            curr = stack.pop();
            ans.add(curr.data);
            curr = curr.getRight();
        }

        return ans;
    }

    /**
     * Here the key thing is to create temporary links (via right most node as for it right node is null and can be used to reference its successor)
     * This to keep track of the traversal path without using a stack or recursion.
     * For any node, the right most node in its left subtree is its predecessor during inorder traversal.
     * We create a temporary link from this predecessor to the current node, so that when we reach the predecessor again,
     * we know that we have already visited the left subtree and can move to the right subtree.
     * 1. curr has no left
     * -> visit curr
     * -> curr = curr.right
     * <p>
     * 2. curr has left
     * -> find predecessor
     * <p>
     * a) predecessor.right == null
     * -> predecessor.right = curr
     * -> curr = curr.left
     * <p>
     * b) predecessor.right == curr
     * -> predecessor.right = null
     * -> visit curr
     * -> curr = curr.right
     */
    public static ArrayList<Integer> inOrderTraversalIterativelyWithoutStack(BSTNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        BSTNode current = root, previous;

        while (current != null) {
            if (current.getLeft() == null) {
                ans.add(current.data);
                current = current.getRight();
            } else {
                previous = current.getLeft();
                /* By this while loop iteration we will always reach the right most node of current's left subtree
                    If the first condition breaks, it means we have reached the right most node of current's left subtree
                    If the second condition breaks, it means we have reached the right most node of current's left subtree and
                */
                while (previous.getRight() != null && previous.getRight() != current) {
                    previous = previous.getRight();
                }
                /* We have reached the right most node of current
                 Make current as right child of its inorder predecessor */
                if (previous.getRight() == null) {
                    previous.setRight(current);
                    current = current.getLeft();
                } else {
                    /*
                    Reaching the else condition means
                     */
                    previous.setRight(null);
                    ans.add(current.data);
                    current = current.getRight();
                }
            }
        }
        return ans;
    }
}
