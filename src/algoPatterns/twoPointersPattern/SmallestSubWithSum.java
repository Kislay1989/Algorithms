package algoPatterns.twoPointersPattern;

public class SmallestSubWithSum {

    public static void main(String[] args) {
        SmallestSubWithSum ss = new SmallestSubWithSum();
        int[] arr = {1, 4, 45, 6, 0, 19};
        int target = 51;
        System.out.println(ss.smallestSubWithSum(arr, target));
    }

    public int smallestSubWithSum(int[] arr, int target) {
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            while (currentSum > target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }


        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
