package GreedyAlgorithm;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kislay on 5/28/17 at 8:57 PM .
 */

/*
A group of k friends want to buy n flowers where each flower  has some base cost, c(i). The florist
wants to maximize his number of new customers, so he increases the price of flowers purchased by
repeat customers; more precisely, if a customer has already purchased x flowers, the price, p, for
flower i is p(i) = (x + 1) X c(i).

Given n, k, and the base cost for each flower, find and print the minimum cost for the group to
purchase n flowers.
 */
public class MinCostForFlowers {

    public static void main(String[] args)
    {
	int persons = 2;
	int flowers = 3;
	int[] flowerPriceList = { 2, 5, 6 };

	System.out.println(getMinimumCost(persons, flowers, flowerPriceList));
    }

    /*
    The trick here is to buy the expensive flowers first
     */
    private static int getMinimumCost(int persons, int flowers, int[] flowerPriceList)
    {
	int minPrice = Integer.MAX_VALUE;

	int[] flowerCount = new int[persons];
	for (int i=0;i<persons;i++)
	    flowerCount[i]=0;

	Set<Integer> priceSet = new TreeSet<>();

	return minPrice;
    }
}
