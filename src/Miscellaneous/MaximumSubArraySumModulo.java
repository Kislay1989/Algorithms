package Miscellaneous;

import java.util.Scanner;

/**
 * Created by kislay on 5/26/17 at 2:29 PM .
 */
public class MaximumSubArraySumModulo {

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	int noOfOperations = scanner.nextInt();

	for (int i = 0; i < noOfOperations; i++) {
	    int maxModulus = 0;
	    int length = scanner.nextInt();
	    int[] arr = new int[length];
	    int operand = scanner.nextInt();

	    for (int j = 0; j < length; j++)
		arr[i] = scanner.nextInt();

	}
    }
}
