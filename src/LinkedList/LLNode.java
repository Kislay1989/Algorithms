package LinkedList;

/**
 * Created by kislay on 3/30/17 at 5:17 PM .
 */
public final class LLNode {
    private final int data;
    private LLNode next;

    public LLNode(int data)
    {
	this.data = data;
    }

    public int getData()
    {
	return data;
    }

    public void setNext(LLNode next)
    {
	this.next = next;
    }

    public LLNode getNext()
    {
	return next;
    }
}
