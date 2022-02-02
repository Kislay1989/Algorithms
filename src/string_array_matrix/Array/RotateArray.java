package string_array_matrix.Array;

/**
 * Created by kislay on 5/31/17 at 11:04 PM .
 */

/*
Rotate an array of n elements to the right by k steps in O(1) space and in O(n) time.
 */
public class RotateArray {

    public static void main(String[] args)
    {
	int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
	int factor = 3;

	int[] reverseArr = reverseArray(arr, factor);
	for (int data : reverseArr) {
	    System.out.println(data);
	}
    }

    private static int[] reverseArray(int[] arr, int factor)
    {
	// edge case check
	if (arr == null || arr.length == 0 || factor < 0)
	    throw new IllegalArgumentException("Illegal Arguments");

	int length = arr.length;

	if (factor > length)
	    factor = factor % length;

	int firstPartLength = length - factor;

	reverse(arr, 0, firstPartLength - 1);
	reverse(arr, firstPartLength, length - 1);
	reverse(arr, 0, length - 1);

	return arr;
    }

    private static void reverse(int[] arr, int left, int right)
    {
	if (arr == null || arr.length == 1)
	    return;

	while (left < right) {
	    int temp = arr[left];
	    arr[left] = arr[right];
	    arr[right] = temp;
	    left++;
	    right--;
	}
    }
}
