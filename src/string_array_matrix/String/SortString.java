package string_array_matrix.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kislay on 5/23/17 at 10:27 PM .
 */
public class SortString {

    //private static String[] arr_strings = { "HELLO", "TO", "MY", "WORLD", "Dk" };
    private static String[] arr_strings = { "HELLO", "TO", "MY", "WORLD", "MADE" };

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args)
    {
	//String b = "ABCEFGHIKLMNOPQRSTUVWXYZDk";

	String n = "BCEWATMZHGFINKLPOSRUVXYQDk";

	String[] res = sortStrings(n);
	System.out.println(Arrays.toString(res));
    }

    private static String[] sortStrings(String language_order)
    {
	char[] charArray = language_order.toCharArray();
	int length = charArray.length;

	int stringLength = arr_strings.length;

	for (int i = 0; i < length; i++) {
	    String s = language_order.substring(i, i + 1);
	    if (s.equals("D") || s.equals("k"))
		continue;
	    map.put(s, i);
	}
	map.put("Dk", 24);

	mergeSortStrings(0, stringLength - 1);

	return arr_strings;
    }

    private static void mergeSortStrings(int low, int high)
    {
	// edge cases check
	if (arr_strings == null)
	    return;

	if (low >= high)
	    return;

	int middle = low + (high - low) / 2;

	mergeSortStrings(low, middle);
	mergeSortStrings(middle + 1, high);

	mergeStrings(low, middle, high);
    }

    private static void mergeStrings(int low, int middle, int high)
    {
	int length = arr_strings.length;
	String[] tempString = new String[length];
	System.arraycopy(arr_strings, 0, tempString, 0, length);

	int i = low;
	int j = middle + 1;
	int k = low;

	while (i <= middle && j <= high) {
	    if (compareString(tempString[i], tempString[j])) {
		arr_strings[k] = tempString[i];
		i++;
	    } else {
		arr_strings[k] = tempString[j];
		j++;
	    }
	    k++;
	}

	while (i <= middle) {
	    arr_strings[k] = tempString[i];
	    k++;
	    i++;
	}
    }

    private static boolean compareString(String first, String second)
    {
	int firLength = first.length();
	int secLength = second.length();

	int min = Math.min(firLength, secLength);

	for (int i = 0; i < min; i++) {
	    String a = first.substring(i, i + 1);
	    String b = second.substring(i, i + 1);

	    if (a.equals(b))
		continue;

	    if (a.equals("D"))
		return false;

	    return b.equals("D") || map.get(a) < map.get(b);
	}

	return false;
    }

}
