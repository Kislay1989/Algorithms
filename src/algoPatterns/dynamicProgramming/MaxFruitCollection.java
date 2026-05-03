package algoPatterns.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCollection {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 1, 1},
                {1, 0, 5}
        };
        int startX = 0, startY = 0, k = 2;

        map.clear();
        int result = getMaxFruit(grid, startX, startY, k);
        System.out.println("Maximum fruit collected: " + result);
    }

    /**
     * Given a 2D grid where each cell contains a certain number of fruits, and a starting position (row, col) along with a maximum number of steps k,
     * determine the maximum number of fruits that can be collected by moving up, down, left, or right from the starting position.
     * Each move counts as one step, and you can only move within the bounds of the grid.
     * <p>
     * This is Dynamic Programming problem where to get the current state, we often rely on its previous states.
     * So to reach i,j with max fruit is equals to fruits in i,j + Max of (i+1->j , i-1->j, i->j-1, i->j+1).
     * The solution does involve recursion but we can optimize it using memoization to avoid redundant calculations and improve efficiency.
     */
    public static int getMaxFruit(int[][] grid, int row, int col, int steps) {
        // Base Condition for recursive call
        if (steps == 0) {
            return grid[row][col];
        }

        String key = row + "-" + col + "-" + steps;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int rowLimit = grid.length;
        int colLimit = grid[0].length;
        int fruit1 = 0, fruit2 = 0, fruit3 = 0, fruit4 = 0;

        if (row - 1 >= 0 && row - 1 < rowLimit && col >= 0 && col < colLimit) {
            fruit1 = getMaxFruit(grid, row - 1, col, steps - 1);
        }
        if (row + 1 >= 0 && row + 1 < rowLimit && col >= 0 && col < colLimit) {
            fruit2 = getMaxFruit(grid, row + 1, col, steps - 1);
        }
        if (row >= 0 && row < rowLimit && col - 1 >= 0 && col - 1 < colLimit) {
            fruit3 = getMaxFruit(grid, row, col - 1, steps - 1);
        }
        if (row >= 0 && row < rowLimit && col + 1 >= 0 && col + 1 < colLimit) {
            fruit4 = getMaxFruit(grid, row, col + 1, steps - 1);
        }

        int currMaxFruit = grid[row][col] + Math.max(Math.max(fruit1, fruit2), Math.max(fruit3, fruit4));

        map.put(key, currMaxFruit);

        return currMaxFruit;
    }
}
