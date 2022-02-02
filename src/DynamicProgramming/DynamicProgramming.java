package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kislay on 4/3/17 at 10:41 PM .
 */
class DynamicProgramming {

    public static void main(String[] args)
    {
	DynamicProgramming dp = new DynamicProgramming();
	//System.out.println(dp.minPalindromePartition("ababbbabbababa"));
	dp.printLCSCount("AGGTAB", "GXTXAYB");
    }

    int maxDiff(int arr[])
    {
	int minNumber = arr[0];
	int maxDifference = 0;
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] - minNumber > maxDifference)
		maxDifference = arr[i] - minNumber;
	    if (arr[i] < minNumber)
		minNumber = arr[i];
	}
	return maxDifference;
    }

    void stockBuySell(int price[])
    {
	if (price == null || price.length < 2)
	    return;

	List<Interval> solution = new ArrayList<>();
	for (int i = 0; i < price.length - 1; i++) {
	    if (price[i + 1] <= price[i])
		continue;
	    Interval e = new Interval();
	    e.setBuy(i);
	    i++;
	    while (i < price.length && (price[i] >= price[i - 1]))
		i++;
	    e.setSell(i);
	    solution.add(e);
	}
	for (Interval interval : solution)
	    System.out.println(
			    "Buy on :" + interval.getBuy() + " and sell on :" + interval.getSell
					    ());
    }

    public void printMaxSubSquare(short M[][])
    {
	int maxNumber = 0, maxNumberX = 0, maxNumberY = 0;
	int rowLength = M.length;
	int columnLength = M[0].length;

	int[][] S = new int[rowLength][columnLength];

	/* Set first columns of S[][] */
	for (int i = 0; i < rowLength; i++) {
	    S[i][0] = M[i][0];
	}

	/* Set first rows of S[][] */
	for (int i = 0; i < columnLength; i++) {
	    S[0][i] = M[0][i];
	}

	/* Construct other entries of S[][]*/
	for (int i = 1; i < rowLength; i++) {
	    for (int j = 1; j < columnLength; j++) {
		if (M[i][j] == 1) {
		    S[i][j] = minimum(S[i][j - 1], S[i - 1][j], S[i - 1][j - 1]) + 1;
		    if (S[i][j] > maxNumber) {
			maxNumber = S[i][j];
			maxNumberX = i;
			maxNumberY = j;
		    }
		} else
		    S[i][j] = 0;
	    }
	}

	// print Max size square sub-matrix
	for (int i = maxNumberX; i > maxNumberX - maxNumber; i--) {
	    for (int j = maxNumberX; j > maxNumberY - maxNumber; j--) {
		System.out.println(M[i][j]);
	    }
	    System.out.println("\n");
	}
    }

    private int minimum(int i, int i1, int i2)
    {
	int min = i;
	if (i1 < min)
	    min = i1;
	if (i2 < min)
	    min = i2;

	return min;
    }

    int minimumCoinsToSum(int[] coins, int sumData)
    {
	if (sumData == 0)
	    return 0;

	int result = Integer.MAX_VALUE;
	int[] minimumCoins = new int[sumData + 1];
	for (int i = 0; i < minimumCoins.length; i++)
	    minimumCoins[i] = result;

	minimumCoins[0] = 0;

	for (int i = 1; i <= sumData; i++) {
	    for (int coin : coins) {
		if (coin <= i) {
		    int res = minimumCoins[i - coin];
		    if (res != result && res + 1 < minimumCoins[i])
			minimumCoins[i] = res + 1;
		}
	    }
	}
	return minimumCoins[sumData];
    }

    int countWaysForCoinChange(int[] coins, int sumData)
    {
	int coinsLength = coins.length;

	int[][] solution = new int[coinsLength + 1][sumData + 1];

	//base case
	for (int i = 0; i < coinsLength; i++)
	    solution[i][0] = 1;
	for (int i = 1; i < sumData; i++)
	    solution[0][i] = 0;

	for (int i = 1; i <= coinsLength; i++) {
	    for (int j = 1; j <= sumData; j++) {
		if (coins[i - 1] <= j) {
		    solution[i][j] = solution[i - 1][j] + solution[i][j - coins[i - 1]];
		} else
		    solution[i][j] = solution[i - 1][j];
	    }
	}
	return solution[coins.length][sumData];
    }

    int longestIncreasingSubSequence(int arr[])
    {
	int max = 0;
	int length = arr.length;
	if (length == 0)
	    return 0;

	int[] list = new int[length];

	for (int i = 0; i < length; i++)
	    list[i] = 1;

	for (int i = 1; i < length; i++) {
	    for (int j = 0; j < i; j++) {
		if (arr[i] > arr[j] && list[i] < list[j] + 1) {
		    list[i] = list[j] + 1;
		    if (max < list[i])
			max = list[i];
		}
	    }
	}

	return max;
    }

    int maxApplesCollected(int[][] apples)
    {
	int maxApples = 0;
	int rowLength = apples.length;
	int columnLength = apples[0].length;

	int[][] max = new int[rowLength][columnLength];

	for (int i = 0; i < rowLength; i++)
	    max[i][0] = apples[i][0];

	for (int i = 0; i < columnLength; i++)
	    max[0][i] = apples[0][i];

	for (int i = 1; i < columnLength; i++) {
	    for (int j = 1; j < rowLength; j++) {
		max[i][j] = apples[i][j] + Math.max(max[i - 1][j], max[i][j - 1]);
		if (maxApples < max[i][j])
		    maxApples = max[i][j];
	    }
	}

	return maxApples;
    }

    public int findOptimalKeysPressed(int times)
    {
	if (times <= 6)
	    return times;

	int[] screen = new int[times];
	for (int i = 1; i <= 6; i++)
	    screen[i - 1] = i;

	for (int i = 7; i <= times; i++) {
	    screen[i - 1] = 0;
	    for (int j = i - 3; j >= 1; j--) {
		int count = (i - j - 1) * screen[j - 1];
		if (count > screen[i - 1])
		    screen[i - 1] = count;
	    }
	}
	return screen[times - 1];
    }

    public int minJumpsToReachEnd(int[] data)
    {
	int length = data.length;
	int maxValue = Integer.MAX_VALUE;

	if (length == 0 || data[0] == 0)
	    return maxValue;

	int[] jumps = new int[length];
	jumps[0] = 0;

	for (int i = 1; i < length; i++)
	    jumps[i] = maxValue;

	for (int i = 1; i < length; i++) {
	    for (int j = 0; j < i; j++) {
		if (i <= j + data[j] && jumps[j] != maxValue) {
		    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
		    break;
		}
	    }
	}

	return jumps[length - 1];
    }

    private int minPalindromePartition(String data)
    {
	int length = data.length();
	char[] array = data.toCharArray();

	int[][] palindrome = new int[length][length];
	boolean[][] palindromeStatus = new boolean[length][length];

	// Every substring of length 1 is a palindrome
	for (int i = 0; i < length; i++) {
	    palindrome[i][i] = 0;
	    palindromeStatus[i][i] = true;
	}

	/* Build the solution in bottom up manner by
	considering all the substring of length starting from 2 to n */
	for (int len = 2; len <= length; len++) {
	    // For substring of length len, set different possible starting indexes for cutting
	    for (int start = 0; start < length - len + 1; start++) {
		// set ending index
		int end = start + len - 1;

		if (len == 2)
		    palindromeStatus[start][end] = array[start] == array[end];
		else
		    palindromeStatus[start][end] = (array[start] == array[end]) &&
				    palindromeStatus[start + 1][end - 1];

		if (palindromeStatus[start][end])
		    palindrome[start][end] = 0;
		else {
		    palindrome[start][end] = Integer.MAX_VALUE;
		    for (int range = start; range < end - 1; range++)
			palindrome[start][end] = Math.min(palindrome[start][end],
					palindrome[start][range] + palindrome[range + 1][end] + 1);
		}
	    }
	}

	return palindrome[0][length - 1];
    }

    private int longestPalindromeSubstring(String input)
    {
	int maxLength = 0;
	char[] array = input.toCharArray();
	int length = array.length;

	boolean[][] table = new boolean[length][length];

	// All substring of length 1 are palindromes
	for (int i = 0; i < length; i++)
	    table[i][i] = true;

	// check for sub-string of length 2.
	for (int i = 0; i < length - 1; i++)
	    table[i][i + 1] = array[i] == array[i + 1];

	// Check for lengths greater than 2. k is length of substring
	for (int k = 3; k <= length; k++) {
	    // Fix the starting index
	    for (int i = 0; i < length - k + 1; i++) {
		// Get the ending index of substring from starting index i and length k
		int j = i + k - 1;
		if (table[i + 1][j - 1] && array[i] == array[j]) {
		    table[i][j] = true;
		    if (maxLength < k)
			maxLength = k;
		} else
		    table[i][j] = false;
	    }
	}
	return maxLength;
    }

    private int findLCSCount(char[] array1, int len1, char[] array2, int len2)
    {
	int[][] table = new int[len1][len2];

	for (int i = 0; i < len1; i++)
	    for (int j = 0; j < len2; j++) {
		if (i == 0 || j == 0) {
		    table[i][j] = 0;
		    continue;
		}

		if (array1[i] == array2[j])
		    table[i][j] = 1 + table[i - 1][j - 1];
		else
		    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
	    }

	return table[len1 - 1][len2 - 1];
    }

    private void printLCSCount(String input1, String input2)
    {
	char[] array1 = input1.toCharArray();
	int len1 = array1.length;

	char[] array2 = input2.toCharArray();
	int len2 = array2.length;

	int[][] table = new int[len1 + 1][len2 + 1];
	for (int i = 0; i <= len1; i++) {
	    for (int j = 0; j <= len2; j++) {
		if (i == 0 || j == 0) {
		    table[i][j] = 0;
		    continue;
		}

		if (array1[i - 1] == array2[j - 1])
		    table[i][j] = 1 + table[i - 1][j - 1];
		else
		    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
	    }
	}

	System.out.println(table[len1 - 1][len2 - 1]);

	int lcsLength = table[len1 - 1][len2 - 1];
	int i = len1, j = len2;
	char[] data = new char[lcsLength];

	while (i > 0 && j > 0) {
	    if (array1[i - 1] == array2[j - 1]) {
		data[lcsLength - 1] = array1[i - 1];
		i--;
		j--;
		lcsLength--;
	    } else if (table[i - 1][j] > table[i][j - 1])
		i--;
	    else
		j--;
	}

	System.out.println(data);
    }
}
