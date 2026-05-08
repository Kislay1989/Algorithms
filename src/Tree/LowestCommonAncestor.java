package Tree;

import java.util.*;

/**
 * Problem Statement - Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class LowestCommonAncestor {

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

        System.out.println(lowestCommonAncestor(root, 4, 5).getData());
    }

    /**
     * The approach is following -
     * 1.) Build a map to store all the ancestors of both p and q. We do a PreOrder traversal to build this map.
     * The map will have data in this way - <Key=child, Value=parent> (Child -> Parent relationship)
     * 2.) The get a collection of all the ancestors of p from down -> up.
     * 3.) From this collection, find which is also an ancestor of q (processing down -> up)
     */
    private static BSTNode lowestCommonAncestorIteratively(BSTNode root, BSTNode p, BSTNode q) {
        if (root == null) {
            return null;
        }

        Map<BSTNode, BSTNode> parent = new HashMap<>();
        Stack<BSTNode> stack = new Stack<>();

        parent.put(root, null);
        stack.push(root);

        // Build parent map until both p and q are found
        // The stack is used with map to ensure that we do PreOrder traversal and visit all the nodes in the tree until both p and q are found.
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            BSTNode node = stack.pop();

            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
        }

        Set<BSTNode> ancestors = new HashSet<>();

        // Collect all ancestors of p
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // First ancestor of q that appears in p's ancestor chain is LCA
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }

    /**
     *
     * This is for a binary search tree.
     */
    public static BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q) {
        BSTNode curr = root;

        while (curr != null) {
            if (p.data < curr.data && q.data < curr.data) {
                curr = curr.left;
            } else if (p.data > curr.data && q.data > curr.data) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }

    /**
     * One side found → pass it up
     * Both sides found → current node is LCA
     */
    public static BSTNode lowestCommonAncestor(BSTNode root, int p, int q) {
        // Base condition for recursive calls
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        BSTNode left = lowestCommonAncestor(root.left, p, q);
        BSTNode right = lowestCommonAncestor(root.right, p, q);

        // This means that both the nodes are present in this tree, one is present in left subtree and other is present in right subtree.
        // So the current node is the LCA.
        if (left != null && right != null) {
            return root;
        }

        // This condition occurs under 2 conditions -
        // 1.) Both the nodes are present in the same subtree (right or left)
        // 2.) Only one node is present in the tree (either p or q)
        // Either way the information is passed upwards
        return (left != null) ? left : right;
    }
}
