package problems_31_60;

import java.util.Scanner;

public class PathsInTheGrid_40 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PathsInTheGrid_40 pitg = new PathsInTheGrid_40();
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

		CountPaths cp = new CountPaths();

		getviaRecursion(grid, 0, 0, cp);
		System.out.println(cp);
	}

	private void getviaRecursion(char[][] grid, int i, int j, CountPaths cp) {

		if (i + 1 < grid.length && grid[i + 1][j] == '$' || j + 1 < grid[0].length && grid[i][j + 1] == '$')
			cp.increase();

		boolean b = true;

		if (i + 1 < grid.length && grid[i + 1][j] == '+') {
			getviaRecursion(grid, i + 1, j, cp);
			if (j + 1 < grid[0].length && grid[i][j + 1] == '+') {
				getviaRecursion(grid, i, j + 1, cp);
				b = false;
			}
		}

		if (b && (j + 1 < grid[0].length && grid[i][j + 1] == '+')) {
			getviaRecursion(grid, i, j + 1, cp);
			if (i + 1 < grid.length && grid[i + 1][j] == '+')
				getviaRecursion(grid, i + 1, j, cp);
		}

		if (i + 1 < grid.length && grid[i + 1][j] == 'X' || j + 1 < grid[0].length && grid[i][j + 1] == 'X')
			return;

	}

	class CountPaths {
		private int paths;

		public CountPaths() {
			paths = 0;
		}

		public void increase() {
			paths++;
		}

		@Override
		public String toString() {
			return String.valueOf(paths);
		}
	}

}
