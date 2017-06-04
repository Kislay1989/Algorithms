package Miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by kislay on 5/27/17 at 11:31 AM .
 */
public class LowestPrice {

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	int vendorCount = scanner.nextInt();

	Map<Integer, Integer> map = new TreeMap<>();
	int[] initialPriceArray = new int[vendorCount];
	List<Integer> finalPriceArray = new ArrayList<>();

	Map<Integer, Integer> timeGapMap = new TreeMap<>();

	for (int i = 0; i < vendorCount; i++) {
	    int startTime = scanner.nextInt();
	    int endTime = scanner.nextInt();
	    int price = scanner.nextInt();
	    map.put(startTime, endTime);
	    initialPriceArray[i] = price;
	}

	int preStartTime, preEndTime;
	int currStartTime = 0, currEndTime = 0;
	int count = 0;

	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	    if (currStartTime == 0 && currEndTime == 0) {
		currStartTime = entry.getKey();
		currEndTime = entry.getValue();
		continue;
	    }
	    preStartTime = currStartTime;
	    preEndTime = currEndTime;

	    currStartTime = entry.getKey();
	    currEndTime = entry.getValue();

	    if (currStartTime < preEndTime) {
		int tempEndTime = currStartTime - 1;
		timeGapMap.put(preStartTime, tempEndTime);
		finalPriceArray.add(initialPriceArray[count]);
		count++;
	    }
	    else
	    {
	        if (!((currStartTime - preEndTime)>2))
		{
		    timeGapMap.put(currStartTime, currEndTime);
		    finalPriceArray.add(initialPriceArray[count]);
		    count++;
		}
		else
		{
		    timeGapMap.put(preEndTime+1, currStartTime-1);
		    finalPriceArray.add(0);

		    timeGapMap.put(currStartTime, currEndTime);
		    finalPriceArray.add(initialPriceArray[count]);
		    count++;
		}
	    }
	}

	timeGapMap.put(currStartTime, currEndTime);
	finalPriceArray.add(initialPriceArray[count]);

	int newCount = 0;
	for (Map.Entry<Integer, Integer> entry : timeGapMap.entrySet()) {
	    System.out.println(entry.getKey() + " " + entry.getValue() + " " +
			    finalPriceArray.get(newCount));
	    newCount++;
	}

    }
}
