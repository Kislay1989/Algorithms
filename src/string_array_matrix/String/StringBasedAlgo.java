package string_array_matrix.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by kislay on 4/3/17 at 3:17 PM .
 */
public class StringBasedAlgo {

    public static void main(String[] args)
    {
	StringBasedAlgo sba = new StringBasedAlgo();
	//System.out.println(sba.getFrequency("bcaaccba"));
	//System.out.println(sba.checkIfStringAnagramIsPalindrome("aab"));
	//sba.findAllPalindromicSubString("aabcb");
	//sba.findAllPalindromicSubString("abba");
	System.out.println(sba.findMinInsertionToMakePalindrome("abbcd"));
	//sba.permuteString("abcde");

	//sba.printAllPossiblePalindromes("aabbcadad");
	//System.out.println(sba.checkIfStringsAreAnagram("abcdefabcdefk", "fdcbeafdcbeaa"));
    }

    public void permuteString(String data)
    {
	int length = data.length();
	permute(data, 0, length - 1);
    }

    private void permute(String data, int start, int end)
    {
	//base case
	if (start == end)
	    System.out.println(data);
	for (int i = start; i <= end; i++) {
	    data = swap(data, start, i);
	    permute(data, start + 1, end);
	    data = swap(data, start, i);
	}
    }

    private String swap(String data, int start, int end)
    {
	char temp;
	char[] charArray = data.toCharArray();
	temp = charArray[start];
	charArray[start] = charArray[end];
	charArray[end] = temp;
	return String.valueOf(charArray);
    }

    private String getFrequency(String data)
    {
	int length = data.length();
	// corner cases check
	if (length == 0)
	    return "";
	if (length == 1)
	    return data + "1";

	Map<String, Integer> sortedMap = new TreeMap<>();
	for (int i = 0; i < length; i++) {
	    String s = data.substring(i, i + 1);
	    int count = 1;
	    if (sortedMap.containsKey(s)) {
		count = count + sortedMap.get(s);
	    }
	    sortedMap.put(s, count);
	}

	StringBuilder sb = new StringBuilder(length);

	for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
	    sb.append(entry.getKey());
	    sb.append(entry.getValue());
	}

	return sb.toString();
    }

    private boolean checkIfStringAnagramIsPalindrome(String input, int[] count)
    {
	for (int i = 0; i < input.length(); i++) {
	    char ch = input.charAt(i);
	    count[ch - 'a']++;
	}
	int oddOccur = 0;
	for (int cnt : count) {
	    if (oddOccur > 1)
		return false;
	    if (cnt % 2 == 1)
		oddOccur++;
	}
	return true;
    }

    private int findMinInsertionToMakePalindrome(String input)
    {
	int length = input.length();
	return findMinInsertionForPalindrome(input.toCharArray(), 0, length - 1);
    }

    private int findMinInsertionForPalindrome(char[] array, int startIndex, int endIndex)
    {
	int diff = endIndex - startIndex;

	//corner case check
	if (diff <= 0)
	    return 0;

	//base case
	if (diff == 1)
	    return array[startIndex] == array[endIndex] ? 0 : 1;

	return array[startIndex] == array[endIndex] ?
			findMinInsertionForPalindrome(array, startIndex + 1, endIndex - 1) :
			Math.min(findMinInsertionForPalindrome(array, startIndex, endIndex - 1),
					findMinInsertionForPalindrome(array, startIndex + 1,
							endIndex)) + 1;
    }

    private int findMinInsertionForPalindromeOnLeft(String input)
    {
	char[] array = input.toCharArray();
	int length = array.length;

	for (int i = length - 1; i >= 0; i--) {
	    if (isPalindrome(array, 0, i))
		return length - i - 1;
	}
	return length - 1;
    }

    private boolean isPalindrome(char[] array, int startIndex, int endIndex)
    {
	while (startIndex < endIndex) {
	    if (array[startIndex] != array[endIndex])
		return false;
	    startIndex++;
	    endIndex--;
	}
	return true;
    }

    private void findAllPalindromicSubString(String data)
    {
	Set<String> set = new HashSet<>();
	int length = data.length();

	for (int i = 0; i < length; i++) {
	    // even length substring
	    findPalindromeSubStrings(data, i, i + 1, set);
	    // odd length substring
	    findPalindromeSubStrings(data, i, i, set);
	}
	System.out.println(set);
    }

    private void findPalindromeSubStrings(String data, int start, int end, Set<String> set)
    {
	// base case
	if (start < 0 || end > data.length() - 1)
	    return;

	if (data.charAt(start) == data.charAt(end)) {
	    set.add(data.substring(start, end + 1));
	    findPalindromeSubStrings(data, start - 1, end + 1, set);
	}
    }

    private void printAllPossiblePalindromes(String data)
    {
	int[] count = new int[26];
	if (!checkIfStringAnagramIsPalindrome(data, count))
	    return;

	char[] array = data.toCharArray();
	int length = array.length;

	StringBuilder sb = new StringBuilder(length / 2);
	char centralChar = 0;
	for (int i = 0; i < count.length; i++) {
	    if (count[i] == 0)
		continue;
	    if (count[i] % 2 == 1)
		centralChar = (char) (i + 'a');
	    else {
		int res = count[i] / 2;
		char c = (char) (i + 'a');
		for (int j = 1; j <= res; j++)
		    sb.append(c);
	    }
	}
	String val = sb.toString();
	int len = val.length();

	printAllData(val, 0, len - 1, centralChar);

    }

    private void printAllData(String val, int start, int end, char centralChar)
    {
	//base case
	if (start == end) {
	    String reverse = reverseString(val);
	    System.out.println(val + centralChar + reverse);
	}

	for (int i = start; i <= end; i++) {
	    val = swap(val, start, i);
	    printAllData(val, start + 1, end, centralChar);
	    val = swap(val, start, i);
	}
    }

    private String reverseString(String val)
    {
	StringBuilder sb = new StringBuilder(val.length());
	for (int i = val.length() - 1; i >= 0; i--)
	    sb.append(val.charAt(i));

	return sb.toString();
    }

    private void checkIfStringIsPangram(String data)
    {
	data = data.toLowerCase().replaceAll(" ", "");
	char[] array = data.toCharArray();
	if (array.length < 26) {
	    System.out.println("String is not Panagram");
	    return;
	}

	Set<Character> set = new HashSet<>();
	for (char c : array)
	    set.add(c);

	if (set.size() == 26)
	    System.out.println("String is a Panagram");
	else
	    System.out.println("String is not Panagram");
    }

    private boolean checkIfStringsAreAnagram(String firstData, String secondData)
    {
	int length = firstData.length();
	if (!(length == secondData.length()))
	    return false;

	Map<Character, Integer> map = new HashMap<>();

	for (int i = 0; i < length; i++) {
	    int count = 1;
	    char c = firstData.charAt(i);
	    if (map.containsKey(c))
		count = map.get(c) + 1;
	    map.put(c, count);
	}
	for (int i = 0; i < length; i++) {
	    char c = secondData.charAt(i);
	    if (map.containsKey(c)) {
		int count = map.get(c) - 1;
		map.put(c, count);
	    } else
		return false;
	}
	for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	    int value = entry.getValue();
	    if (value > 0)
		return false;
	}
	return true;
    }

}
