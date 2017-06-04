package Miscellaneous;

import java.util.Scanner;

/**
 * Created by kislay on 5/30/17 at 3:05 PM .
 */

/*
Ron and Hermione are deep in the Forbidden Forest collecting potion ingredients, and they've
managed to lose their way. The path out of the forest is blocked, so they must make their way to
a port key that will transport them back to Hogwarts.

Consider the forest as an N x M grid. Each cell is either empty (represented by .) or blocked by a
tree (represented by X). Ron and Hermione can move (together inside a single cell) LEFT, RIGHT,
UP, and DOWN through empty cells, but they cannot travel through a tree cell. Their starting cell
 is marked with the character M, and the cell with the port key is marked with a *. The upper-left
 corner is indexed as (0,0).
 */
public class CountLuck {

    private static final String POSITIVE_RESPONSE = "Impressed";
    private static final String NEGATIVE_RESPONSE = "Oops!";
    private static final String TREE = "X";
    private static final String ROUTE = ".";
    private static final String INITIAL = "M";
    private static final String FINAL = "*";
    private static int ROW_LENGTH;
    private static int COL_LENGTH;
    private static int ACTUAL_WAVES_COUNT = 0;

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);

	int cases = scanner.nextInt();

	for (int i = 0; i < cases; i++) {
	    ROW_LENGTH = scanner.nextInt();
	    COL_LENGTH = scanner.nextInt();
	    int[][] forest = new int[ROW_LENGTH][COL_LENGTH];

	    int initialX = 0, initialY = 0;

	    for (int row = 0; row < ROW_LENGTH; row++) {
		String data = scanner.next();
		for (int col = 0; col < COL_LENGTH; col++) {
		    String colValue = data.substring(col, col + 1);
		    switch (colValue) {
		    case ROUTE:
			forest[row][col] = 1;
			break;
		    case TREE:
			forest[row][col] = 0;
			break;
		    case INITIAL:
			forest[row][col] = -1;
			initialX = row;
			initialY = col;
			break;
		    case FINAL:
			forest[row][col] = 2;
			break;
		    }
		}
	    }

	    // searching the path in matrix
	    int assumedWaves = scanner.nextInt();
	    setWavesCount(forest, initialX, initialY);
	    if (assumedWaves == ACTUAL_WAVES_COUNT)
		System.out.println(POSITIVE_RESPONSE);
	    else
		System.out.println(NEGATIVE_RESPONSE);

	    ACTUAL_WAVES_COUNT = 0;
	}
    }

    private static void setWavesCount(int[][] forest, int currentX, int currentY)
    {
	if (currentX == ROW_LENGTH || currentY == COL_LENGTH || currentX < 0 || currentY < 0)
	    return;

	int data = forest[currentX][currentY];
	if (data == 0 || data == 2 || data == 3)
	    return;

	forest[currentX][currentY] = 3;

	if (currentX == 0) {
	    if (currentY == 0) {
		int validPos = 0;
		if (forest[currentX + 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY + 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    } else if (currentY == COL_LENGTH - 1) {
		int validPos = 0;
		if (forest[currentX + 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY - 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    } else {
		int validPos = 0;
		if (forest[currentX + 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY + 1] == 1)
		    ++validPos;
		if (forest[currentX][currentY - 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    }
	} else if (currentX == ROW_LENGTH - 1) {
	    if (currentY == 0) {
		int validPos = 0;
		if (forest[currentX - 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY + 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    } else if (currentY == COL_LENGTH - 1) {
		int validPos = 0;
		if (forest[currentX - 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY - 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    } else {
		int validPos = 0;
		if (forest[currentX - 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY + 1] == 1)
		    ++validPos;
		if (forest[currentX][currentY - 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    }
	} else {
	    if (currentY == 0) {
		int validPos = 0;
		if (forest[currentX + 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX - 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY + 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    } else if (currentY == COL_LENGTH - 1) {
		int validPos = 0;
		if (forest[currentX + 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX - 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY - 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    } else {
		int validPos = 0;
		if (forest[currentX + 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX - 1][currentY] == 1)
		    ++validPos;
		if (forest[currentX][currentY + 1] == 1)
		    ++validPos;
		if (forest[currentX][currentY - 1] == 1)
		    ++validPos;

		if (validPos >= 2)
		    ++ACTUAL_WAVES_COUNT;
	    }
	}

	setWavesCount(forest, currentX + 1, currentY);
	setWavesCount(forest, currentX - 1, currentY);
	setWavesCount(forest, currentX, currentY + 1);
	setWavesCount(forest, currentX, currentY - 1);
    }
}
