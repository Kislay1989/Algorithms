package algoPatterns.greedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kislay on 5/28/17 at 8:57 PM .
 */

/*
A group of k friends want to buy n flowers where each flower  has some base cost, c(i). The florist
wants to maximize his profit , so he increases the price of flowers purchased by
repeat customers; more precisely, if a customer has already purchased x flowers, the price p for
flower i is p(i) = (x + 1) * c(i).

Given number of persons and the base cost for each flower, find the minimum cost for the group to
purchase n flowers.
 */
public class MinCostForFlowers {

    public static void main(String[] args) {
        int persons = 2;
        int[] flowerPriceList = {2, 6, 5};

        System.out.println(getMinimumCost(persons, flowerPriceList));
    }

    /*
    The trick here is to buy the expensive flowers first (For this data will be sorted in descending order)
    Give them to people when their multiplier is still small
    so that expensive flowers should not get multiplied by bigger numbers.
    The other point is that after every k flowers, multiplier increases by 1, so we can calculate multiplier by doing (i / k) + 1
    where i is the index of the flower in sorted order and k is the number of persons.
     */
    private static int getMinimumCost(int persons, int[] flowerPriceList) {
        Arrays.sort(flowerPriceList);
        int totalCost = 0;
        int len = flowerPriceList.length;

        for (int i = 0; i < len; i++) {
            int cost = flowerPriceList[len - 1 - i];
            int multiplier = (i / persons) + 1;
            totalCost += cost * multiplier;
        }

        return totalCost;
    }
}
