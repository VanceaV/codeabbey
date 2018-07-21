package problems_61_90;

import java.util.Scanner;

public class MazePathfinder_64 {

	private static Scanner scan = new Scanner(System.in);
	private char grid[][];

	public static void main(String[] args) {

		MazePathfinder_64 mpf = new MazePathfinder_64();
		mpf.read();
		mpf.result();

	}

	private void read() {

		int j = scan.nextInt();
		int i = scan.nextInt();
		scan.nextLine();

		grid = new char[i][j];

		for (int j2 = 0; j2 < i; j2++)
			grid[j2] = scan.nextLine().toCharArray();

	}

	private void result() {

		path(0, grid[0].length - 1, "", "", grid);

		path(grid.length - 1, 0, "", "", grid);

		path(grid.length - 1, grid[0].length - 1, "", "", grid);

	}

	private void path(int i, int j, String p, String root, char[][] grid) {

		if (i == 0 & j == 0) {

			System.out.print(count(p) + " ");
		}

		if (i - 1 >= 0 && !root.equals("D") && grid[i - 1][j] != '0') {
			path(i - 1, j, p + "U", "U", grid);
		}

		if (i + 1 < grid.length && !root.equals("U") && grid[i + 1][j] != '0') {
			path(i + 1, j, p + "D", "D", grid);
		}

		if (j + 1 < grid[0].length && !root.equals("L") && grid[i][j + 1] != '0') {
			path(i, j + 1, p + "R", "R", grid);
		}
		if (j - 1 >= 0 && !root.equals("R") && grid[i][j - 1] != '0') {
			path(i, j - 1, p + "L", "L", grid);
		}

	}

	private String count(String p) {

		String result = "";

		char temp = p.charAt(0);
		int count = 0;

		for (int i = 0; i < p.length(); i++) {

			if (temp == p.charAt(i))
				count++;
			else {
				result += count + String.valueOf(temp);
				temp = p.charAt(i);
				count = 1;
			}
		}
		result += count + String.valueOf(temp);

		return result;
	}
}
