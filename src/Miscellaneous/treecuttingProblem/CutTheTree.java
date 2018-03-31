package Miscellaneous.treecuttingProblem;

import java.util.Scanner;

/**
 * Created by kislay on 6/7/17 at 10:19 PM .
 */
public final class CutTheTree {

    public static int MINIMUM_SCORE = Integer.MAX_VALUE;

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	TreeNode root;

	int treeCount = scanner.nextInt();

	for (int index = 1; index <= treeCount; index++) {
	    int data = scanner.nextInt();
	    TreeNode node = new TreeNode(index, data);
	    if (index == 1)
		root = node;
	}
    }

    private static int sumOfTree(TreeNode node)
    {
	// edge case
	if (node == null)
	    return 0;

	int rightData = 0;
	int leftData = 0;

	if (node.getLeftNode() != null)
	    leftData = sumOfTree(node.getLeftNode());

	if (node.getRightNode() != null)
	    leftData = sumOfTree(node.getRightNode());

	return node.getData() + rightData + leftData;
    }

    public static final class TreeNode {

	private final int index;
	private final int data;
	private TreeNode leftNode;
	private TreeNode rightNode;

	public TreeNode(int index, int data)
	{
	    this.index = index;
	    this.data = data;
	}

	public int getIndex()
	{
	    return index;
	}

	public int getData()
	{
	    return data;
	}

	public TreeNode getLeftNode()
	{
	    return leftNode;
	}

	public void setLeftNode(TreeNode leftNode)
	{
	    this.leftNode = leftNode;
	}

	public TreeNode getRightNode()
	{
	    return rightNode;
	}

	public void setRightNode(TreeNode rightNode)
	{
	    this.rightNode = rightNode;
	}
    }
}
