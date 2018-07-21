package problems_61_90.PawnMoveValidator_76;

import java.util.Scanner;

public class PawnMoveValidator {

	private static Scanner scan = new Scanner(System.in);
	private static Square[][] board;

	public PawnMoveValidator() {
		board = new Square[8][8];
	}

	public static void main(String[] args) {
		PawnMoveValidator pmv = new PawnMoveValidator();
		pmv.result();
	}

	private void fillTheBoard() {
		Init.fillTheBoard(board);
	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();

		System.out.println();
		while (iter-- > 0) {

			fillTheBoard();

			String[] array = scan.nextLine().split(" ");
			int count = 0;
			boolean move = true;
			ValidMove vm = null;
			for (int i = 0; i < array.length; i++) {
				XY xy = getFigure(array[i].charAt(0), array[i].charAt(1));
				Square sq = new Square(array[i].charAt(2), array[i].charAt(3), null);
				move = xy.isValidMove(vm, sq, board);
				count++;
				if (!move)
					break;
			}

			if (move) {
				System.out.print(0 + " ");
			}

			else {
				System.out.print(count + " ");
			}
		}
	}

	private XY getFigure(char x, char y) {
		return board[Math.abs(y - 56)][x - 97];
	}
}
