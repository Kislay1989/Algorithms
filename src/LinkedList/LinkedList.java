package LinkedList;

/**
 * Created by kislay on 3/30/17 at 5:18 PM .
 */
public class LinkedList {
    public LLNode reverseLinkedListViaIterativeApproach(LLNode node)
    {
	if (node == null || node.getNext() == null)
	    return node;

	LLNode current = node;
	LLNode next, previous = null;

	while (current.getNext() != null) {
	    next = current.getNext();
	    current.setNext(previous);
	    previous = current;
	    current = next;
	}
	return current;
    }

    private LLNode reverseLinkedListViaRecursiveApproach(LLNode node)
    {
	//base case
	if (node.getNext() == null)
	    return node;

	LLNode rest = node.getNext();

	LLNode head = reverseLinkedListViaRecursiveApproach(rest);
	rest.setNext(node);

	return head;
    }

    /*public LinkedList.LLNode reverseDoublyLinkedList(LinkedList.LLNode node)
    {

    }*/

    public LLNode mergeTwoSortedLinkedLists(LLNode firstList, LLNode secondList)
    {
	if (firstList == null && secondList == null)
	    return null;
	if (firstList == null)
	    return secondList;
	if (secondList == null)
	    return firstList;

	LLNode head = null;
	LLNode current1 = null, current2 = null;

	if (firstList.getData() < secondList.getData()) {
	    head = firstList;
	    current1 = firstList.getNext();
	    current2 = secondList;
	} else if (firstList.getData() > secondList.getData()) {
	    head = secondList;
	    current1 = firstList;
	    current2 = secondList.getNext();
	}

	LLNode tail = head;

	while (true) {
	    if (current1 == null) {
		tail.setNext(current2);
		break;
	    }
	    if (current2 == null) {
		tail.setNext(current1);
		break;
	    }
	    if (current1.getData() < current2.getData()) {
		tail.setNext(current1);
		current1 = current1.getNext();
	    }
	    if (current1.getData() > current2.getData()) {
		tail.setNext(current2);
		current2 = current2.getNext();
	    }

	    tail = tail.getNext();
	}

	return head;
    }
}
