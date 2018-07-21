package problems_31_60;

import java.util.Scanner;

public class LifeIsSimple_56 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		LifeIsSimple_56 ls = new LifeIsSimple_56();
		ls.result();
	}

	private void result() {
		int iter = 5;

		char[][] grid = read();

		while (--iter >= 0) {

			char[][] cloned = cloneGrid(grid);

			for (int i = 0; i < grid.length; i++)
				for (int j = 0; j < grid[0].length; j++) {
					int count = countNeibours(grid, i, j);
					if (grid[i][j] == 'X' && ((count < 2) || count > 3))
						cloned[i][j] = 'D';
					if (grid[i][j] == '-' && count == 3)
						cloned[i][j] = 'B';
				}
			grid = transformation(cloned);

			System.out.print(countCells(grid) + " ");
		}
	}

	private char[][] read() {

		char[][] grid = new char[60][60];

		for (int i = 0; i < 60; i++)
			for (int j = 0; j < 60; j++)
				grid[i][j] = '-';

		for (int i = 0; i < 5; i++) {
			char[] temp = scan.nextLine().toCharArray();
			for (int j = 0; j < 7; j++) {
				grid[i + 20][j + 20] = temp[j];
			}

		}

		return grid;
	}

	private int countNeibours(char[][] grid, int i, int j) {

		int count = 0;

		if (i + 1 < grid.length && grid[i + 1][j] == 'X')
			count++;
		if (i - 1 >= 0 && grid[i - 1][j] == 'X')
			count++;
		if (j + 1 < grid[0].length && grid[i][j + 1] == 'X')
			count++;
		if (j - 1 >= 0 && grid[i][j - 1] == 'X')
			count++;
		if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 'X')
			count++;
		if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] == 'X')
			count++;
		if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 'X')
			count++;
		if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] == 'X')
			count++;

		return count;
	}

	private char[][] cloneGrid(char[][] grid) {
		char[][] cloned = new char[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				cloned[i][j] = grid[i][j];
		return cloned;
	}

	private int countCells(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == 'X')
					++count;
		return count;
	}

	private char[][] transformation(char[][] grid) {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'D')
					grid[i][j] = '-';

				if (grid[i][j] == 'B')
					grid[i][j] = 'X';
			}

		return grid;
	}
}
