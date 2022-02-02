package src.Tree;

/**
 * Created by kislay on 3/31/17 at 11:54 PM .
 */
public class BTNode {
    private int data;
    private BTNode left;
    private BTNode right;
    private BTNode adjacentRight;

    public BTNode(int data, BTNode left, BTNode right, BTNode adjacentRight)
    {
	this.data = data;
	this.left = left;
	this.right = right;
	this.adjacentRight = adjacentRight;
    }

    public int getData()
    {
	return data;
    }

    public BTNode getLeft()
    {
	return left;
    }

    public BTNode getRight()
    {
	return right;
    }

    public BTNode getAdjacentRight()
    {
	return adjacentRight;
    }

    public void setAdjacentRight(BTNode adjacentRight)
    {
	this.adjacentRight = adjacentRight;
    }
}
