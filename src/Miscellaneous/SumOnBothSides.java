package Miscellaneous;

/**
 * Created by kislay on 5/25/17 at 3:56 PM .
 */
public class SumOnBothSides {

    /*
    Given an array of integers, find if it’s possible to remove exactly one integer from the
    array that divides the array into two sub arrays with the same sum
     */

    private static final String YES_RESPONSE = "YES";
    private static final String NO_RESPONSE = "NO";

    public static void main(String[] args)
    {
	int[] list = { 1, 2, 3 };
	int[] list2 = { 1, 2, 3, 3 };

	System.out.println(solve(list));
	System.out.println(solve(list2));

    }

    // run-time complexity of O(n)
    private static String solve(int[] list)
    {
	int sum = 0, leftSum = 0;

	for (int data : list)
	    sum += data;

	for (int data : list) {
	    sum -= data;

	    if (sum == leftSum)
		return YES_RESPONSE;

	    leftSum += data;
	}
	return NO_RESPONSE;

    }
}
