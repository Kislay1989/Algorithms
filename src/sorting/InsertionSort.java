package sorting;

import LinkedList.LLNode;

import java.util.Arrays;

/**
 * Created by kislay on 5/22/17 at 11:31 PM .
 */
public class InsertionSort {

    public static void main(String[] args)
    {
	int arr[] = { 12, 11, 13, 5, 6 };
	insertionSort(arr);
	System.out.println(Arrays.toString(arr));

	LLNode n1 = new LLNode(3);
	LLNode n2 = new LLNode(6);
	LLNode n3 = new LLNode(1);

	LLNode n4 = new LLNode(5);
	LLNode n5 = new LLNode(4);
	LLNode n6 = new LLNode(2);

	n1.setNext(n2);
	n2.setNext(n3);
	n3.setNext(n4);
	n4.setNext(n5);
	n5.setNext(n6);

	n1 = insertionSortList(n1);
	printList(n1);
    }

    private static void printList(LLNode node)
    {
	while (node != null) {
	    System.out.print(node.getData());
	    if (node.getNext() != null) {
		System.out.print(" : ");
	    }
	    node = node.getNext();
	}
    }

    /*
    * Explanation - According to the logic, for any given index i (element at i as key)
    * all the elements to the left of i are less than key. Hence, iterative scanning from left to
    * right ensures sorting being done. As for deducing the logic at a given index i, all elements
    * to the left of i and less than key are moved one position right, until the point comes when
    * the element is less than key. Correspondingly key is inserted at that position
    * (hence, the name insertion sort). Its run time complexity is always n^2. Its is a stable sort.
    * */

    private static void insertionSort(int[] arr)
    {
	int length = arr.length;
	for (int i = 1; i < length; i++) {
	    int key = arr[i];
	    int j = i - 1;
	    while (j >= 0 && arr[j] > key) {
		arr[j + 1] = arr[j];
		j = j - 1;
	    }
	    arr[j + 1] = key;
	}
    }

    private static LLNode insertionSortList(LLNode head)
    {
	// edge cases check
	if (head == null || head.getNext() == null)
	    return head;

	LLNode newHead = new LLNode(head.getData());
	LLNode pointer = head.getNext();

	while (pointer != null) {

	    LLNode innerPointer = newHead;
	    LLNode next = pointer.getNext();

	    if (pointer.getData() <= newHead.getData()) {
		LLNode oldHead = newHead;
		newHead = pointer;
		newHead.setNext(oldHead);
	    } else {
		while (innerPointer.getNext() != null) {
		    if (pointer.getData() > innerPointer.getData() &&
				    pointer.getData() <= innerPointer.getNext().getData()) {
			LLNode oldNext = innerPointer.getNext();
			innerPointer.setNext(pointer);
			pointer.setNext(oldNext);
		    }
		    innerPointer = innerPointer.getNext();
		}

		if (innerPointer.getNext() == null && pointer.getData() > innerPointer.getData()) {
		    innerPointer.setNext(pointer);
		    pointer.setNext(null);
		}
	    }

	    pointer = next;
	}

	return newHead;
    }
}
