package recursion;

/**
 * Created by kislay on 5/25/17 at 7:16 PM .
 */
public class PartitionProblem {

    /*
    Partition problem is to determine whether a given set can be partitioned into two subsets
    such that the sum of elements in both subsets is same
     */

    public static void main(String[] args)
    {
	int[] arr = { 1, 5, 11, 5 };
	int[] arr1 = { 1, 5, 3 };

	System.out.println(findPartition(arr));
	System.out.println(findPartition(arr1));
    }

    // Time complexity O(2^n)
    private static boolean findPartition(int[] arr)
    {
	int length = arr.length;

	int sum = 0;
	for (int data : arr)
	    sum += data;

	return sum % 2 == 0 && isSubSetSum(arr, length, sum / 2);
    }

    private static boolean isSubSetSum(int[] arr, int length, int sum)
    {
	// Edge cases check
	if (arr == null || (length == 0 && sum != 0))
	    return false;

	// Base case
	if (sum == 0)
	    return true;

	if (arr[length - 1] > sum)
	    return isSubSetSum(arr, length - 1, sum);

	return isSubSetSum(arr, length - 1, sum) ||
			isSubSetSum(arr, length - 1, sum - arr[length - 1]);
    }
}
