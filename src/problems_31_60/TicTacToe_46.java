package problems_31_60;

import java.util.Scanner;

public class TicTacToe_46 {

	private static Scanner scan = new Scanner(System.in);

	private int board[][];

	public static void main(String[] args) {
		TicTacToe_46 ttt = new TicTacToe_46();
		ttt.result();
	}

	private void result() {
		int iter = scan.nextInt();
		boolean result = false;

		label: while (iter-- > 0) {
			board = new int[3][3];
			int number, i, j;
			boolean player = true;
			result = false;
			for (int ii = 0; ii < 9; ii++) {
				number = scan.nextInt();
				i = findI(number);
				j = findJ(number);
				if (player) {
					board[i][j] = 1;
					result = check(board, player);
					if (result) {
						System.out.print(ii + 1 + " ");
						int k = 8 - ii;
						while (k-- > 0)
							scan.nextInt();
						continue label;
					}
					player = !player;
				} else {
					board[i][j] = 1000;
					result = check(board, player);
					if (result) {
						System.out.print(ii + 1 + " ");
						int k = 8 - ii;
						while (k-- > 0)
							scan.nextInt();
						continue label;
					}

					player = !player;
				}
			}

			System.out.print(0 + " ");

		}
	}

	private boolean check(int board[][], boolean player) {
		boolean result = false;
		int toCheck = 0;
		if (player)
			toCheck = 1;
		else
			toCheck = 1000;

		toCheck *= 3;

		int oriz = 0, vert = 0, diag1 = 0, diag2 = 0;

		label: for (int i = 0; i < board.length; i++) {
			oriz = 0;
			vert = 0;
			diag2 += board[i][2 - i];
			for (int j = 0; j < board[0].length; j++) {
				oriz += board[i][j];
				vert += board[j][i];
				if (i == j)
					diag1 += board[i][j];

				if (oriz == toCheck || vert == toCheck || diag1 == toCheck || diag2 == toCheck) {
					result = true;
					break label;
				}
			}
		}

		return result;
	}

	private int findI(int number) {
		if (number % 3 == 0)
			return number / 3 - 1;
		else
			return number / 3;
	}

	private int findJ(int number) {
		if (number % 3 == 0)
			return 3 - 1;
		else
			return number % 3 - 1;
	}
}
