package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by kislay on 3/30/17 at 4:53 PM .
 */
public class BinaryTree {

    public void printLevelOrderWithoutRecursion(BSTNode root) {
        if (root == null) {
            return;
        }

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode tempBSTNode = queue.poll();
            System.out.print(tempBSTNode.getData() + " ");

            if (tempBSTNode.getLeft() != null) {
                queue.add(tempBSTNode.getLeft());
            }

            if (tempBSTNode.getRight() != null) {
                queue.add(tempBSTNode.getRight());
            }
        }
    }

    public int getHeightIteratively(BSTNode node) {
        if (node == null) {
            return 0;
        }

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                BSTNode current = queue.poll();
                size--;

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            height++;
        }

        return height;
    }

    public void connectNodesAtSameLevel(BTNode node) {
        if (node == null)
            return;

        node.setAdjacentRight(null);

        while (node != null) {
            BTNode temp = node;
            while (temp != null) {
                if (temp.getLeft() != null) {
                    if (temp.getRight() != null)
                        temp.getLeft().setAdjacentRight(temp.getRight());
                    else
                        temp.getLeft().setAdjacentRight(getNextRight(temp));
                }
                if (temp.getRight() != null)
                    temp.getRight().setAdjacentRight(getNextRight(temp));
                temp = temp.getAdjacentRight();
            }
            if (node.getLeft() != null)
                node = node.getLeft();
            else if (node.getRight() != null)
                node = node.getRight();
            else
                node = getNextRight(node);
        }
    }

    private BTNode getNextRight(BTNode node) {
        BTNode temp = node.getAdjacentRight();

        while (temp != null) {
            if (temp.getLeft() != null)
                return temp.getLeft();
            if (temp.getRight() != null)
                return temp.getRight();
            temp = temp.getAdjacentRight();
        }

        return null;
    }

    public void inOrderTraversalWithoutRecursion(BSTNode root) {
        if (root == null)
            return;

        Stack<BSTNode> stack = new Stack<>();
        BSTNode current = root;

        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.println(current.getData() + " ");
            current = current.getRight();
        }
    }

    public void inOrderTraversalIterativelyWithoutStack(BSTNode root) {
        if (root == null)
            return;
        BSTNode current = root, previous;
        while (current != null) {
            if (current.getLeft() == null) {
                System.out.println(current.getData());
                current = current.getRight();
            } else {
                /*
                Set previous as the rightmost node in the left subtree (inorder predecessor)
                 */
                previous = current.getLeft();
                while (previous.getRight() != null && previous.getRight() != current) {
                    previous = previous.getRight();
                }
                /* Make current as right child of its inorder predecessor */
                if (previous.getRight() == null) {
                    previous.setRight(current);
                    current = current.getLeft();
                } else {
                     /* Revert the changes made in the 'if' part to restore the original tree i.e., fix
                   the right child of predecessor */
                    previous.setRight(null);
                    System.out.println(current.getData());
                    current = current.getRight();
                }
            }
        }
    }

    public void preOrderTraversalWithoutRecursion(BSTNode root) {
        // Base Case
        if (root == null)
            return;

        Stack<BSTNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {
            BSTNode temp = stack.pop();
            System.out.println(temp.getData());

            if (temp.getRight() != null)
                stack.push(temp.getRight());

            if (temp.getLeft() != null)
                stack.push(temp.getLeft());
        }
    }

    public void postOrderTraversalWithoutRecursion(BSTNode root) {
        if (root == null)
            return;

        Stack<BSTNode> stack = new Stack<>();
        stack.push(root);
        BSTNode previous = null, current;

        while (stack.size() > 0) {
            current = stack.peek();

            //traversing down the tree
            if (previous == null || previous.getLeft() == current ||
                    previous.getRight() == current) {
                if (current.getLeft() != null)
                    stack.push(current.getLeft());
                else if (current.getRight() != null)
                    stack.push(current.getRight());
                else {
                    stack.pop();
                    System.out.println(current.getData());
                }
            }

            // traversing up the tree from the left
            else if (current.getLeft() == previous) {
                if (current.getRight() != null)
                    stack.push(current.getRight());
                else {
                    stack.pop();
                    System.out.println(current.getData());
                }
            }

            // we are traversing up the tree from the right
            else if (current.getRight() == previous) {
                stack.pop();
                System.out.println(current.getData());
            }

            previous = current;
        }

    }

    public void inOrderTraversalWithoutRecursionAndWithoutStack(BSTNode root) {
        // This is also  called Morris Traversal
        BSTNode current, previous;
        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.getLeft() == null) {
                System.out.print(current.getData() + " ");
                current = current.getRight();
            } else {
                /* Find the inorder predecessor of current */
                previous = current.getLeft();
                while (previous.getRight() != null && previous.getRight() != current)
                    previous = previous.getRight();
                /* Make current as getRight() child of its inorder predecessor */
                if (previous.getRight() == null) {
                    current = previous.getRight();
                    current = current.getLeft();
                }
		 /* Revert the changes made in if part to restore the
		    original tree i.e.,fix the getRight() child of predecessor*/
                else {
                    //previous.getRight() = null;
                    System.out.print(current.getData() + " ");
                    current = current.getRight();
                }
            }
        }
    }

    private int sizeOfTree(BSTNode root) {
        if (root == null)
            return 0;

        return sizeOfTree(root.getLeft()) + 1 + sizeOfTree(root.getRight());
    }

    public void printRootToLeafPathsOnePerLine(BSTNode root) {
        List<Integer> path = new ArrayList<>();
        printPathsRecur(root, path);
    }

    private void printPathsRecur(BSTNode node, List<Integer> path) {
        if (node == null)
            return;

        path.add(node.getData());

        if (node.getLeft() == null && node.getRight() == null)
            printArray(path);
        else {
            printPathsRecur(node.getLeft(), new ArrayList<>(path));
            printPathsRecur(node.getRight(), new ArrayList<>(path));
        }
    }

    private void printArray(List<Integer> path) {
        for (Integer data : path)
            System.out.println(data);
        System.out.println("\n");
    }

    private int search(char arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    private BSTNode buildTreeFromInOrderAndPreOrder(char in[], char pre[], int start, int end) {
        if (start > end)
            return null;

        BSTNode node = new BSTNode(pre[start++]);
        if (start == end)
            return node;

        int inIndex = search(in, start, end, node.getData());

        node.setLeft(buildTreeFromInOrderAndPreOrder(in, pre, start, inIndex - 1));
        node.setRight(buildTreeFromInOrderAndPreOrder(in, pre, inIndex + 1, end));

        return node;
    }

    private boolean checkChildrenSumProperty(BSTNode node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null))
            return true;

        int leftData = 0, rightData = 0;
        int nodeData = node.getData();

        if (node.getLeft() != null)
            leftData = node.getLeft().getData();
        if (node.getRight() != null)
            rightData = node.getRight().getData();

        return (nodeData == (leftData + rightData) && checkChildrenSumProperty(node.getLeft()) &&
                checkChildrenSumProperty(node.getRight()));

    }

    private void convertTreeToChildrenSumProperty(BSTNode node) {
        if (node == null || (node.getRight() == null && node.getLeft() == null))
            return;
        int leftData = 0, rightData = 0, difference, nodeData = node.getData();

        convertTreeToChildrenSumProperty(node.getLeft());
        convertTreeToChildrenSumProperty(node.getRight());

        if (node.getLeft() != null)
            leftData = node.getLeft().getData();
        if (node.getRight() != null)
            rightData = node.getRight().getData();

        difference = Math.abs(leftData + rightData - nodeData);

        if (difference > 0)
            node.setData(nodeData + difference);
        if (difference < 0)
            incrementTree(node, difference);
    }

    private void incrementTree(BSTNode node, int difference) {
        if (node.getLeft() != null) {
            node.getLeft().setData(node.getLeft().getData() + difference);
            incrementTree(node.getLeft(), difference);
        } else if (node.getRight() != null) {
            node.getRight().setData(node.getLeft().getData() + difference);
            incrementTree(node.getRight(), difference);
        }
    }

    /*public boolean isCompleteBT(Tree.BSTNode node)
    {

    }*/
}
