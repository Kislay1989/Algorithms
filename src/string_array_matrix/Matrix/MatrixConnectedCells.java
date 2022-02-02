package string_array_matrix.Matrix;

import java.util.Scanner;

/**
 * Created by kislay on 5/28/17 at 2:16 PM .
 */

/*
For a given n x m matrix , find the largest region filled with 1's.
This problem is a case of DFS where for anf given node (or entity) we go as deep as possible
before backtracking and moving to another node.

The run-time complexity is exponential O(8^n) as for every individual call 8 different calls are
again made.
 */

public class MatrixConnectedCells {

    private static int[][] table;
    private static int rowLength;
    private static int colLength;

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	int large = 0;

	rowLength = scanner.nextInt();
	colLength = scanner.nextInt();

	table = new int[rowLength][colLength];

	// fill the table
	for (int i = 0; i < rowLength; i++)
	    for (int j = 0; j < colLength; j++)
		table[i][j] = scanner.nextInt();

	// scan the table
	for (int i = 0; i < rowLength; i++)
	    for (int j = 0; j < colLength; j++)
		large = Math.max(large, largestRegionMatrix(i, j));

	System.out.println(large);
    }

    private static int largestRegionMatrix(int rowIndex, int colIndex)
    {
	if (rowIndex < 0 || colIndex < 0 || rowIndex >= rowLength || colIndex >= colLength ||
			table[rowIndex][colIndex] == 0 || table[rowIndex][colIndex] == -1)
	    return 0;
	table[rowIndex][colIndex] = -1;
	return 1 + largestRegionMatrix(rowIndex - 1, colIndex - 1) +
			largestRegionMatrix(rowIndex - 1, colIndex) +
			largestRegionMatrix(rowIndex, colIndex - 1) +
			largestRegionMatrix(rowIndex - 1, colIndex + 1) +
			largestRegionMatrix(rowIndex + 1, colIndex - 1) +
			largestRegionMatrix(rowIndex + 1, colIndex + 1) +
			largestRegionMatrix(rowIndex, colIndex + 1) +
			largestRegionMatrix(rowIndex + 1, colIndex);
    }
}
