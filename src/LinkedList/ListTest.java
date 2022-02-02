package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kislay on 2/17/17 at 12:36 PM .
 */
public class ListTest
{
	public static void main (String[] args) {
		LLNode head = createList();
		LinkedList list = new LinkedList();
		LLNode newHead  = list.removeDuplicateNodes(head);

		while (newHead!=null)
		{
			System.out.println(newHead.getData());
			newHead = newHead.getNext();
		}
	}

	private static LLNode createList () {
		LLNode head = new LLNode(4);

		LLNode n1 = new LLNode(3);
		head.setNext(n1);

		LLNode n2 = new LLNode(5);
		n1.setNext(n2);

		LLNode n3 = new LLNode(3);
		n2.setNext(n3);

		LLNode n4 = new LLNode(6);
		n3.setNext(n4);

		LLNode n5 = new LLNode(7);
		n4.setNext(n5);

		LLNode n6 = new LLNode(6);
		n5.setNext(n6);

		LLNode n7 = new LLNode(4);
		n6.setNext(n7);

		return head;
	}
}
