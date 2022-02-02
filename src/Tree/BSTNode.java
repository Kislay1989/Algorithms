package Tree;

/**
 * Created by kislay on 3/30/17 at 4:54 PM .
 */
public class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int data)
    {
	this.data = data;
    }

    int getData()
    {
	return data;
    }

    BSTNode getLeft()
    {
	return left;
    }

    BSTNode getRight()
    {
	return right;
    }

    public void setData(int data)
    {
	this.data = data;
    }

    public void setLeft(BSTNode left)
    {
	this.left = left;
    }

    public void setRight(BSTNode right)
    {
	this.right = right;
    }
}
