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

	int treeCount = scanner.nextInt();
    }

    public static final class TreeNode {

	private final int index;
	private final int data;
	private TreeNode nextNode;

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

	public TreeNode getNextNode()
	{
	    return nextNode;
	}

	public void setNextNode(TreeNode nextNode)
	{
	    this.nextNode = nextNode;
	}
    }
}
