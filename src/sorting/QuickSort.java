package sorting;

import java.util.Arrays;

/**
 * Created by kislay on 5/22/17 at 10:33 PM .
 */
public class QuickSort {

    public static void main(String[] args)
    {
	int[] intArray = { 9, 2, 4, 17, 3, 7, 10 };

	int low = 0;
	int high = intArray.length - 1;

	quickSort(intArray, low, high);
	System.out.println(Arrays.toString(intArray));
    }

    /*
    The average run time complexity of quick sort is n log(n) .
    The worst case run time complexity is n^2.
    Worst case occurs in quick sort when partition of n elements results in two sub arrays of
    size 1 and n-1.
    It is not a stable sort.
     */

    private static void quickSort(int[] intArray, int low, int high)
    {
	// edge cases check
	if (intArray == null || intArray.length == 0)
	    return;

	// base case check for recursion
	if (low >= high)
	    return;

	int middle = low + (high - low) / 2;
	int pivot = intArray[middle];

	int i = low, j = high;
	while (i <= j) {
	    while (intArray[i] < pivot)
		i++;
	    while (intArray[j] > pivot)
		j--;
	    if (i <= j) {
		int temp = intArray[i];
		intArray[i] = intArray[j];
		intArray[j] = temp;
		i++;
		j--;
	    }
	}

	//recursively sort the two sub parts
	if (low < j)
	    quickSort(intArray, low, j);
	if (high > i)
	    quickSort(intArray, i, high);
    }
}
