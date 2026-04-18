package algoPatterns.prefixSumPattern;

public class PivotIndex {

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.findPivotIndex(arr)); // Output: 3
    }

    /**
     * The pivot index is the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
     */
    public int findPivotIndex(int[] arr) {
        int len = arr.length;
        int[] prefixSum = new int[len + 1];
        int pivotIndex = -1;

        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < len; i++) {
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[len] - prefixSum[i + 1];

            if (leftSum == rightSum) {
                pivotIndex = i;
                break;
            }
        }

        return pivotIndex;
    }
}
