package Miscellaneous;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by kislay on 5/25/17 at 3:37 PM .
 */
public class PairDifference {

    public static void main(String[] args)
    {
	int pairCount = 0;
	Scanner scanner = new Scanner(System.in);

	int length = scanner.nextInt();
	int difference = scanner.nextInt();
	Set<Integer> set = new HashSet<>();
	for (int i = 0; i < length; i++) {
	    int data = scanner.nextInt();
	    set.add(data);
	}

	for (Object value : set) {
	    int data = (int) value;
	    int res = data - difference;
	    if (res > 0 && set.contains(res))
		pairCount++;
	}

	System.out.println(pairCount);
    }
}
