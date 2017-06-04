package string_array_matrix.Array;

/**
 * Created by kislay on 4/20/17 at 11:52 PM .
 */
public class Array {

    public static void main(String[] args)
    {
	Array array = new Array();
	int[] data = { -2, -3, 4, -1, -12, 23, 5, -3 };
	System.out.println(array.maxSubArraySum(data));
    }

    private int maxSubArraySum(int dataList[])
    {
	int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

	for (int data : dataList) {
	    max_ending_here = max_ending_here + data;
	    if (max_so_far < max_ending_here)
		max_so_far = max_ending_here;
	    if (max_ending_here < 0)
		max_ending_here = 0;
	}
	return max_so_far;
    }
}
