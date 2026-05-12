package string_array_matrix.String;

/**
 * Given a string s of length 2n containing exactly n '[' and n ']' brackets. Find the minimum number of adjacent swaps needed to make the string balanced.
 * Note: A string is balanced if every '[' has a matching ']' such that no closing bracket appears before its corresponding opening bracket, and the total counts of both are equal.
 *
 * The "imbalance" doesn't actually require you to perform the swap in the array physically.
 * Because we only care about the number of adjacent swaps, every time we find a "[" that needs to move left to fix a previous "]",
 * the number of swaps required is exactly equal to the number of unbalanced "]" characters currently sitting to its left.
 * Since , the problem mentions adjacent swaps, we can swap any element only with its adjacent element.
 * So, if we have an imbalance of 2, it means we have 2 unbalanced "]" characters to the left of the current "[" character.
 * To fix this imbalance, we need to swap the current "[" character with each of those unbalanced "]" characters one by one, which results in 2 swaps.
 */
public class MinNoOfSwaps {

    public static void main(String[] args) {
        String s = "[]]][[";
        int res = minSwaps(s);
        System.out.println(res);
    }

    public static int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int balance = 0;
        int swaps = 0;
        int imbalance = 0;

        for (char aChar : chars) {
            if (aChar == '[') {
                balance++;

                if (imbalance > 0) {
                    swaps += imbalance;
                    imbalance--;
                }
            } else {
                balance--;
                if (balance < 0) {
                    imbalance++;
                }
            }
        }
        return swaps;
    }
}
