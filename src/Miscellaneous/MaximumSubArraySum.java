package Miscellaneous;

/**
 * Created by kislay on 5/26/17 at 6:48 PM .
 */
public class MaximumSubArraySum {

    public static void main(String[] args)
    {
	int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
	System.out.println(maxSubArraySum(arr));
    }

    private static int maxSubArraySum(int[] arr)
    {
	int maxSum = Integer.MIN_VALUE;
	int sum = 0;

	for (int data : arr) {
	    sum += data;
	    if (maxSum < sum)
		maxSum = sum;
	    if (sum < 0)
		sum = 0;
	}

	return maxSum;
    }
}
