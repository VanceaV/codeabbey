package problems_91_120;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnightsTour_107 {

	private static Scanner scan = new Scanner(System.in);
	private int M, N, X, Y;
	private int[][] board;

	private int cx[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	private int cy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	private List<Integer> Path;

	private int[][] ordersOfMove = { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 2, 1, 3, 4, 5, 6, 7, 8 }, { 3, 1, 2, 4, 5, 6, 7, 8 },
			{ 1, 3, 2, 4, 5, 6, 7, 8 }, { 2, 3, 1, 4, 5, 6, 7, 8 }, { 3, 2, 1, 4, 5, 6, 7, 8 },
			{ 4, 2, 1, 3, 5, 6, 7, 8 }, { 2, 4, 1, 3, 5, 6, 7, 8 }, { 1, 4, 2, 3, 5, 6, 7, 8 },
			{ 4, 1, 2, 3, 5, 6, 7, 8 }, { 2, 1, 4, 3, 5, 6, 7, 8 }, { 1, 2, 4, 3, 5, 6, 7, 8 },
			{ 1, 3, 4, 2, 5, 6, 7, 8 }, { 3, 1, 4, 2, 5, 6, 7, 8 }, { 4, 1, 3, 2, 5, 6, 7, 8 },
			{ 1, 4, 3, 2, 5, 6, 7, 8 }, { 3, 4, 1, 2, 5, 6, 7, 8 }, { 4, 3, 1, 2, 5, 6, 7, 8 },
			{ 4, 3, 2, 1, 5, 6, 7, 8 } };

	private int nx, ny;

	public KnightsTour_107() {
		M = scan.nextInt();
		N = scan.nextInt();
		board = new int[M][N];
		X = scan.nextInt();
		Y = M - scan.nextInt() - 1;
		board[Y][X] = 1;
		Path = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		KnightsTour_107 kt = new KnightsTour_107();
		kt.result();
	}

	private void result() {

		for (int i = 0; i < ordersOfMove.length; i++) {

			clearTheBoard();

			while (!neighbour()) {
				if(nextMove(ordersOfMove[i]))	
				break;
			}

			if (neighbour()) {
				clearTheBoard();
				while (!neighbour()) {
					nextMove(ordersOfMove[i]);
				}

				for (int p : Path)
				System.out.print(p + " ");
				break;
			}
		}
	}

	private boolean neighbour() {

		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				if (board[i][j] == 0)
					return false;

		return true;
	}

	private boolean nextMove(int orders[]) {
		int min_deg_idx = -1, c, min_deg = 9;

		int x, y;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 8; i++) {
			x = nx + cx[i];
			y = ny + cy[i];

			boolean b = isempty(x, y);
			c = getDegree(x, y);

			if (b && c < min_deg) {
				min_deg_idx = i;
				min_deg = c;
				list.clear();
				list.add(i + 1);
			} else if (b && c == min_deg) {
				list.add(i + 1);
			}
		}

		if (list.size() == 1 && min_deg_idx != -1) {
			nx += cx[min_deg_idx];
			ny += cy[min_deg_idx];
			newSquare(min_deg_idx);
		} else {

			for (int i = 0; i < orders.length; i++) {
				if (list.contains(orders[i])) {
					nx += cx[orders[i] - 1];
					ny += cy[orders[i] - 1];
					newSquare(orders[i] - 1);
					break;
				}
			}

		}
		board[ny][nx] = 1;

		return min_deg_idx == -1;
	}

	public void clearTheBoard() {

		nx = 0;
		ny = 0;
		Path.clear();
		Path.add(0);
		Path.add(M-1);

		for (int i = 0; i < M; ++i)
			for (int j = 0; j < N; j++)
				board[i][j] = 0;

		board[ny][nx] = 1;

		board[Y][X] = 1;
	}

	private void newSquare(int sq) {
		if (sq == 0)
			Path.add(1);
		else if (sq == 1)
			Path.add(0);
		else if (sq == 2)
			Path.add(7);
		else if (sq == 3)
			Path.add(6);
		else if (sq == 4)
			Path.add(5);
		else if (sq == 5)
			Path.add(4);
		else if (sq == 6)
			Path.add(3);
		else if (sq == 7)
			Path.add(2);

	}

	private int getDegree(int x, int y) {
		int count = 0;
		for (int i = 0; i < 8; i++)
			if (isempty((x + cx[i]), (y + cy[i])))
				count++;
		return count;
	}

	private boolean limits(int x, int y) {
		return ((x >= 0 && y >= 0) && (x < N && y < M));
	}

	private boolean isempty(int x, int y) {
		return (limits(x, y)) && (board[y][x] != 1);
	}
}
