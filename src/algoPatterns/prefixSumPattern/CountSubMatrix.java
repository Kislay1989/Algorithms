package algoPatterns.prefixSumPattern;

/**
 * Given a matrix of integers and an integer x, count the number of square sub-matrices that have a sum equals to x.
 */

public class CountSubMatrix {

    public static void main(String[] args) {
        int x = 10;
        int[][] matrix = {
                {2,   4,  7,  8,  10},
                {3,   1,  1,  1,  1},
                {9,   11, 1,  2,  1},
                {12, -17, 1,  1,  1}
        };

        //System.out.println(countSquare(matrix, x));

        System.out.println(countSquaresWithSumX(matrix, x)); // Output: 4
    }

    public static int countSquaresWithSumX(int[][] matrix, int x) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Build 2D prefix sum
        int[][] prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] = matrix[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int count = 0;

        // Step 2: Try all square sizes
        int maxSize = Math.min(rows, cols);

        for (int size = 1; size <= maxSize; size++) {
            for (int i = 0; i + size <= rows; i++) {
                for (int j = 0; j + size <= cols; j++) {
                    int r1 = i;
                    int c1 = j;
                    int r2 = i + size - 1;
                    int c2 = j + size - 1;

                    int sum = getSquareSum(prefix, r1, c1, r2, c2);

                    if (sum == x) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static int getSquareSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        return prefix[r2 + 1][c2 + 1]
                - prefix[r1][c2 + 1]
                - prefix[r2 + 1][c1]
                + prefix[r1][c1];
    }

    public static int countSquare(int[][] mat, int x) {
        int res = 0;
        int rowLen = mat.length;
        int colLen = mat[0].length;

        // Compute row-wise prefix sum
        int[][] rowPrefix = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            rowPrefix[i][0] = mat[i][0];
            for (int j = 1; j < colLen; j++) {
                rowPrefix[i][j] = rowPrefix[i][j - 1] + mat[i][j];
            }
        }

        int maxSize = Math.min(rowLen, colLen);

        // Try each possible square size
        for (int size = 1; size <= maxSize; size++) {
            for (int i = 0; i <= colLen - size; i++) {
                int colIndex = i + size - 1;
                int sum = 0;

                for (int row = 0; row < size - 1; row++) {
                    sum += rowPrefix[row][colIndex] - (i > 0 ? rowPrefix[row][i - 1] : 0);
                }

                // This loop is for sliding the square down the rows
                for (int row = size - 1; row < rowLen; row++) {
                    sum += rowPrefix[row][colIndex] - (i > 0 ? rowPrefix[row][i - 1] : 0);

                    if (sum == x) {
                        res++;
                    }

                    sum -= rowPrefix[row - size + 1][colIndex] - (i > 0 ? rowPrefix[row - size + 1][i - 1] : 0);
                }
            }
        }

        return res;
    }
}
