package problems_31_60;

import java.util.Scanner;

public class PathsInTheGrid_40_1 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PathsInTheGrid_40_1 pitg = new PathsInTheGrid_40_1();
		pitg.result();

	}

	private void result() {

		int m = new Integer(scan.next()), n = new Integer(scan.next());
		scan.nextLine();

		char grid[][] = new char[m][n];
		String[] array;

		for (int i = 0; i < m; i++) {
			array = scan.nextLine().split(" ");
			for (int j = 0; j < n; j++)
				grid[i][j] = array[j].charAt(0);
		}

		System.out.println(getviaRecursion(grid, 0, 0, m, n));

	}

	private int getviaRecursion(char[][] grid, int i, int j, int m, int n) {

		int forReturn = 0;
		if (grid[i][j] == '$') {
			return 1;
		}

		int t1, t2;
		if ((grid[i][j] == '@' || grid[i][j] == '+') && grid[i][j] != 'X') {
			t1 = i + 1;
			t2 = j + 1;
			if (t1 < m)
				forReturn += getviaRecursion(grid, t1, j, m, n);
			if (t2 < n)
				forReturn += getviaRecursion(grid, i, t2, m, n);
		}

		return forReturn;

	}
}
