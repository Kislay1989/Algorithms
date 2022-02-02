package sorting;

import LinkedList.LLNode;

import java.util.Arrays;

/**
 * Created by kislay on 5/23/17 at 5:33 PM .
 */
public class MergeSort {

    private static int[] intArray = { 9, 2, 4, 17, 3, 7, 10 };
    private static int[] tempArray;

    public static void main(String[] args)
    {
	int low = 0;
	int high = intArray.length - 1;

	tempArray = new int[intArray.length];
	mergeSort(low, high);
	System.out.println(Arrays.toString(intArray));

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

	n1 = mergeSortList(n1);
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
    Merge sort is divide and conquer algorithm.
    Its run time complexity is n log(n).
    It is a stable sort.
     */
    private static void mergeSort(int low, int high)
    {
	// base case check
	if (low >= high)
	    return;

	int middle = low + (high - low) / 2;

	mergeSort(low, middle);
	mergeSort(middle + 1, high);
	merge(low, middle, high);
    }

    private static void merge(int low, int middle, int high)
    {
	System.arraycopy(intArray, 0, tempArray, 0, intArray.length);
	int i = low;
	int j = middle + 1;
	int k = low;

	while (i <= middle && j <= high) {
	    if (tempArray[i] <= tempArray[j]) {
		intArray[k] = tempArray[i];
		i++;
	    } else {
		intArray[k] = tempArray[j];
		j++;
	    }
	    k++;
	}

	while (i <= middle) {
	    intArray[k] = tempArray[i];
	    k++;
	    i++;
	}
    }

    private static LLNode mergeSortList(LLNode head)
    {
	// edge cases check
	if (head == null || head.getNext() == null)
	    return head;

	// count the total no of elements
	int count = 0;
	LLNode temp = head;
	while (temp != null) {
	    count++;
	    temp = temp.getNext();
	}

	int middle = count / 2;
	LLNode r = null;
	LLNode p2 = head;
	int half = 0;
	while (p2 != null) {
	    half++;
	    if (half == middle) {
		r = p2.getNext();
		p2.setNext(null);
		break;
	    }
	    p2 = p2.getNext();
	}

	LLNode h1 = mergeSortList(head);
	LLNode h2 = mergeSortList(r);

	return mergeList(h1, h2);
    }

    private static LLNode mergeList(LLNode l, LLNode r)
    {
	LLNode merged, pointer;

	if (l == null && r == null)
	    return null;

	if (l == null)
	    return r;

	if (r == null)
	    return l;

	if (l.getData() <= r.getData()) {
	    merged = l;
	    l = l.getNext();
	} else {
	    merged = r;
	    r = r.getNext();
	}
	pointer = merged;

	while (l != null && r != null) {
	    if (l.getData() <= r.getData()) {
		pointer.setNext(l);
		l = l.getNext();
	    } else {
		pointer.setNext(r);
		r = r.getNext();
	    }
	    pointer = pointer.getNext();
	}

	if (l != null)
	    pointer.setNext(l);
	else
	    pointer.setNext(r);

	return merged;
    }
}
