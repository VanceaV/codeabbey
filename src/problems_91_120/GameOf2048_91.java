package problems_91_120;

import java.util.*;

public class GameOf2048_91 {
	private static Scanner scan = new Scanner(System.in);
	private int board[][];

	public GameOf2048_91() {
		board = board();

	}

	public static void main(String[] args) {

		GameOf2048_91 g = new GameOf2048_91();
		g.result();
	}

	private void result() {
		String moves = scan.nextLine();
		moves = moves.replaceAll(" ", "");
		for (int i = 0; i < moves.length(); i++)
			DRLU(board, String.valueOf(moves.charAt(i)));

		int count[] = count(board);

		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i] + " ");

		}
	}

	private int[] count(int board[][]) {
		int max = 0;

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (board[i][j] > max)
					max = board[i][j];
			}

		int counts[] = new int[number(max)];

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != 0)
					counts[number(board[i][j]) - 1]++;
			}

		return counts;
	}

	private int number(int n) {
		int count = 1;
		while (true) {

			if (n == 2) {
				break;
			} else
				count++;
			n /= 2;
		}
		return count;
	}

	private int[][] board() {
		int[][] board = new int[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				board[i][j] = scan.nextInt();
			}
		scan.nextLine();
		return board;
	}

	static void DRLU(int[][] D, String st) {
		char ch = st.charAt(0);
		switch (ch) {
		case 'D': {
			for (int i = 0; i < 4; i++) {

				if (D[0][i] == D[1][i] && D[2][i] == D[3][i]) {
					D[1][i] *= 2;
					D[0][i] = 0;
					D[3][i] *= 2;
					D[2][i] = 0;
					continue;
				}
				if (D[0][i] == D[1][i] && D[1][i] == D[2][i]) {
					D[2][i] *= 2;
					D[1][i] = 0;
					continue;
				}
				if (D[1][i] == D[2][i] && D[2][i] == D[3][i]) {
					D[3][i] *= 2;
					D[2][i] = 0;
					continue;
				}
				if (D[1][i] == D[2][i] && D[1][i] != D[0][i] && D[2][i] != D[3][i]) {
					D[2][i] *= 2;
					D[1][i] = 0;
					continue;
				}

				if (D[2][i] == D[3][i] && D[2][i] != D[1][i]) {
					D[3][i] *= 2;
					D[2][i] = 0;
					continue;
				}
				if (D[0][i] == D[1][i] && D[1][i] != D[2][i]) {
					D[1][i] *= 2;
					D[0][i] = 0;
					continue;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (D[0][i] == 0 && D[1][i] == 0 && D[2][i] == 0 && D[3][i] == 0)
					continue;
				for (int j = 3; j >= 0; j--) {
					if (D[j][i] == 0) {
						for (int s = j - 1; s >= 0; s--) {
							D[s + 1][i] = D[s][i];
							D[s][i] = 0;
						}
					}
					if (D[3][i] == 0)
						++j;
				}
			}
			break;
		}
		case 'U': {
			for (int i = 0; i < 4; i++) {

				if (D[3][i] == D[2][i] && D[1][i] == D[0][i]) {
					D[0][i] *= 2;
					D[1][i] = 0;
					D[2][i] *= 2;
					D[3][i] = 0;
					continue;
				}
				if (D[3][i] == D[2][i] && D[1][i] == D[2][i]) {
					D[1][i] *= 2;
					D[2][i] = 0;
					continue;
				}
				if (D[2][i] == D[1][i] && D[1][i] == D[0][i]) {
					D[0][i] *= 2;
					D[1][i] = 0;
					continue;
				}
				if (D[1][i] == D[2][i] && D[1][i] != D[0][i] && D[2][i] != D[3][i]) {
					D[1][i] *= 2;
					D[2][i] = 0;
					continue;
				}

				if (D[3][i] == D[2][i] && D[2][i] != D[1][i]) {
					D[2][i] *= 2;
					D[3][i] = 0;
					continue;
				}
				if (D[0][i] == D[1][i] && D[1][i] != D[2][i]) {
					D[0][i] *= 2;
					D[1][i] = 0;
					continue;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (D[0][i] == 0 && D[1][i] == 0 && D[2][i] == 0 && D[3][i] == 0)
					continue;
				for (int j = 0; j < 4; j++) {
					if (D[j][i] == 0) {
						for (int s = j + 1; s < 4; s++) {
							D[s - 1][i] = D[s][i];
							D[s][i] = 0;
						}
					}
					if (D[j][i] == 0 && D[0][i] == 0)
						--j;
				}
			}
			break;
		}
		case 'L': {
			for (int i = 0; i < 4; i++) {

				if (D[i][0] == D[i][1] && D[i][2] == D[i][3]) {
					D[i][0] *= 2;
					D[i][1] = 0;
					D[i][2] *= 2;
					D[i][3] = 0;
					continue;
				}
				if (D[i][0] == D[i][1] && D[i][1] == D[i][2]) {
					D[i][0] *= 2;
					D[i][1] = 0;
					continue;
				}
				if (D[i][1] == D[i][2] && D[i][2] == D[i][3]) {
					D[i][1] *= 2;
					D[i][2] = 0;
					continue;
				}
				if (D[i][1] == D[i][2] && D[i][1] != D[i][0] && D[i][2] != D[i][3]) {
					D[i][1] *= 2;
					D[i][2] = 0;
					continue;
				}
				if (D[i][2] == D[i][3] && D[i][2] != D[i][1]) {
					D[i][2] *= 2;
					D[i][3] = 0;
					continue;
				}
				if (D[i][0] == D[i][1] && D[i][1] != D[i][2]) {
					D[i][0] *= 2;
					D[i][1] = 0;
					continue;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (D[i][0] == 0 && D[i][1] == 0 && D[i][2] == 0 && D[i][3] == 0)
					continue;
				for (int j = 0; j < 4; j++) {
					if (D[i][j] == 0) {
						for (int s = j + 1; s < 4; s++) {
							D[i][s - 1] = D[i][s];
							D[i][s] = 0;
						}
						if (D[i][j] == 0 && D[i][0] == 0)
							--j;
					}
				}
			}
			break;
		}
		case 'R': {
			for (int i = 0; i < 4; i++) {
				if (D[i][0] == D[i][1] && D[i][2] == D[i][3]) {
					D[i][1] *= 2;
					D[i][0] = 0;
					D[i][3] *= 2;
					D[i][2] = 0;
					continue;
				}
				if (D[i][0] == D[i][1] && D[i][1] == D[i][2]) {
					D[i][2] *= 2;
					D[i][1] = 0;
					continue;
				}
				if (D[i][1] == D[i][2] && D[i][2] == D[i][3]) {
					D[i][3] *= 2;
					D[i][2] = 0;
					continue;
				}
				if (D[i][1] == D[i][2] && D[i][1] != D[i][0] && D[i][2] != D[i][3]) {
					D[i][2] *= 2;
					D[i][1] = 0;
					continue;
				}
				if (D[i][2] == D[i][3] && D[i][2] != D[i][1]) {
					D[i][3] *= 2;
					D[i][2] = 0;
					continue;
				}
				if (D[i][0] == D[i][1] && D[i][1] != D[i][2]) {
					D[i][1] *= 2;
					D[i][0] = 0;
					continue;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (D[i][0] == 0 && D[i][1] == 0 && D[i][2] == 0 && D[i][3] == 0)
					continue;
				for (int j = 3; j >= 0; j--) {
					if (D[i][j] == 0) {
						for (int s = j - 1; s >= 0; s--) {
							D[i][s + 1] = D[i][s];
							D[i][s] = 0;
						}
					}
					if (D[i][3] == 0)
						++j;
				}
			}
			break;
		}
		}
	}
}