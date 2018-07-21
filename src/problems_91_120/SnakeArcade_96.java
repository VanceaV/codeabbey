package problems_91_120;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeArcade_96 {

	private static Scanner scan = new Scanner(System.in);
	private char[][] arcade;
	private List<Integer> snakeX;
	private List<Integer> snakeY;
	private int xh = 0, yh = 2;
	private String direction = "R";
	private int moves = 0;

	public SnakeArcade_96() {

		buildArcade();
		snakeX = new ArrayList<Integer>();
		snakeX.add(0);
		snakeX.add(0);
		snakeX.add(0);
		snakeY = new ArrayList<Integer>();
		snakeY.add(0);
		snakeY.add(1);
		snakeY.add(2);
	}

	public static void main(String[] args) {

		SnakeArcade_96 sa = new SnakeArcade_96();
		sa.result();
	}

	private void result() {

		String[] s = scan.nextLine().split(" ");
		int iter = 1;
		while (iter < s.length) {
			if (iter % 2 == 1) {
				boolean b = move(Integer.parseInt(s[iter - 1]));
				if (b)
					break;
			} else {
				direction = s[iter - 1];
			}
			iter++;
		}
		System.out.print(yh + " " + xh + " " + moves);
	}

	private boolean move(int _moves) {

		boolean b = false;

		int _x = 0, _y = 0;

		if (direction.equals("R")) {
			_y = 1;
		} else if (direction.equals("L")) {
			_y = -1;

		} else if (direction.equals("U")) {
			_x = -1;
		} else {
			_x = 1;
		}

		while (_moves-- > 0) {
			if (arcade[xh + _x][yh + _y] == 'X') {
				yh += _y;
				xh += _x;
				moves++;
				b = true;
				break;
			} else if (arcade[xh + _x][yh + _y] == '$') {
				moves++;
				snakeX.add(xh + _x);
				snakeY.add(yh + _y);
				arcade[xh + _x][yh + _y] = 'X';
				yh += _y;
				xh += _x;

			} else {
				moves++;
				arcade[xh + _x][yh + _y] = 'X';
				snakeX.add(xh + _x);
				snakeY.add(yh + _y);
				arcade[snakeX.get(0)][snakeY.get(0)] = '-';
				snakeX.remove(0);
				snakeY.remove(0);
				yh += _y;
				xh += _x;
			}

		}

		return b;
	}

	private void buildArcade() {

		arcade = new char[13][21];

		for (int i = 0; i < 13; i++) {
			String st = scan.nextLine();
			int k = 0;
			for (int j = 0; j < 41; j++) {
				if (st.charAt(j) == ' ') {
					continue;
				}
				arcade[i][k++] = st.charAt(j);
			}
		}
	}
}
