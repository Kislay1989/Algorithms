package Miscellaneous;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by kislay on 5/25/17 at 1:36 PM .
 */
public class MissingList {

    /*
    There are two lists A and B, such that B was a permutation of A.
    Unfortunately, while transporting them from one exhibition to another,
    some numbers were left out of A. Find the missing numbers.
    Notes

    If a number occurs multiple times in the lists, you must ensure that the frequency of that
    number in both lists is the same. If that is not the case, then it is also a missing number.
    You have to print all the missing numbers in ascending order.
    Print each missing number once, even if it is missing multiple times.
    The difference between maximum and minimum number in B is less than or equal to 100.
     */

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	int firstLength = scanner.nextInt();
	Map<Integer, Integer> firstMap = new TreeMap<>();
	for (int i = 0; i < firstLength; i++) {
	    int data = scanner.nextInt();
	    int count = 1;
	    if (firstMap.containsKey(data))
		count = count + firstMap.get(data);
	    firstMap.put(data, count);
	}

	int secondLength = scanner.nextInt();
	Map<Integer, Integer> secondMap = new TreeMap<>();
	for (int i = 0; i < secondLength; i++) {
	    int data = scanner.nextInt();
	    int count = 1;
	    if (secondMap.containsKey(data))
		count = count + secondMap.get(data);
	    secondMap.put(data, count);
	}

	for (Map.Entry<Integer, Integer> entry : secondMap.entrySet()) {
	    int data = entry.getKey();
	    int count = entry.getValue();

	    boolean isPresent = firstMap.containsKey(data);
	    if (!isPresent) {
		System.out.print(data + " ");
		continue;
	    }

	    int firCount = firstMap.get(data);
	    if (count != firCount)
		System.out.print(data + " ");
	}
    }
}
