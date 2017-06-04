package recursion;

/**
 * Created by kislay on 4/13/17 at 12:31 AM .
 */
public class Recursion {

    public static void main(String[] args)
    {
	Recursion rec = new Recursion();
	//System.out.println(rec.minimumStepsToReachDestination(4));
	//System.out.println(rec.minimumStepsToReachDestination(11));

	int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	//rec.printAllPathsIn2DArray(0, 0, a, 3, 3, "");
	System.out.println(rec.longestCommonSubSequence("AGGTAB", "GXTXAYB"));
    }

    private int minimumStepsToReachDestination(int destination)
    {
	int source = 0;
	int step = 0;
	return minimum(source, step, destination);
    }

    private int minimum(int source, int step, int destination)
    {
	//Base case
	if (source == destination)
	    return step;
	if (Math.abs(source) > destination)
	    return Integer.MAX_VALUE;

	int positive = minimum(source + step + 1, step + 1, destination);
	int negative = minimum(source - step - 1, step + 1, destination);

	return Math.min(positive, negative);
    }

    private void printAllPathsIn2DArray(int currentRow, int currentCol, int[][] matrix,
		    int rowCount, int colCount, String path)
    {
	// base conditions
	if (currentRow == rowCount - 1) {
	    StringBuilder pathBuilder = new StringBuilder(path);
	    for (int i = currentCol; i < colCount; i++)
		pathBuilder.append("-").append(matrix[currentRow][i]);
	    path = pathBuilder.toString();
	    System.out.println(path);
	    return;
	}
	if (currentCol == colCount - 1) {
	    StringBuilder pathBuilder = new StringBuilder(path);
	    for (int i = currentRow; i < rowCount; i++)
		pathBuilder.append("-").append(matrix[i][currentCol]);
	    path = pathBuilder.toString();
	    System.out.println(path);
	    return;
	}

	path += "-" + matrix[currentRow][currentCol];
	printAllPathsIn2DArray(currentRow + 1, currentCol, matrix, rowCount, colCount, path);
	printAllPathsIn2DArray(currentRow, currentCol + 1, matrix, rowCount, colCount, path);
    }

    private int longestCommonSubSequence(String input1, String input2)
    {
	char[] array1 = input1.toCharArray();
	int len1 = array1.length;

	char[] array2 = input2.toCharArray();
	int len2 = array2.length;

	return findLCSCount(array1, len1, array2, len2);
    }

    private int findLCSCount(char[] array1, int len1, char[] array2, int len2)
    {
	// base case
	if (len1 == 0 || len2 == 0)
	    return 0;

	if (array1[len1 - 1] == array2[len2 - 1])
	    return 1 + findLCSCount(array1, len1 - 1, array2, len2 - 1);
	else
	    return Math.max(findLCSCount(array1, len1, array2, len2 - 1),
			    findLCSCount(array1, len1 - 1, array2, len2));

    }
}
