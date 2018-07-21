package problems_61_90.PawnMoveValidator_76;

class Init {

	public static void fillTheBoard(Square[][] board) {

		char x, y = '8';

		for (int i = 0; i < 8; i++) {
			x = 'a';
			for (int j = 0; j < 8; j++) {
				Square sq = new Square(x, y, null);
				if (i == 0) {
					if (j == 0) {
						Rock r = new Rock(x, y, "black");
						sq.setF(r);
					} else if (j == 1) {
						Night n = new Night(x, y, "black");
						sq.setF(n);

					} else if (j == 2) {
						Bishop b = new Bishop(x, y, "black");
						sq.setF(b);

					} else if (j == 3) {
						Quin q = new Quin(x, y, "black");
						sq.setF(q);

					} else if (j == 4) {
						King k = new King(x, y, "black");
						sq.setF(k);
					} else if (j == 5) {
						Bishop b = new Bishop(x, y, "black");
						sq.setF(b);

					} else if (j == 6) {
						Night n = new Night(x, y, "black");
						sq.setF(n);

					} else if (j == 7) {
						Rock r = new Rock(x, y, "black");
						sq.setF(r);
					}

				}
				if (i == 1) {
					Pawn p = new Pawn(x, y, "black");
					sq.setF(p);
					board[i][j] = sq;
				}
				if (i > 1 && i < 6) {
					board[i][j] = sq;
				}

				if (i == 6) {
					Pawn p = new Pawn(x, y, "white");
					sq.setF(p);
					board[i][j] = sq;
				}
				if (i == 7) {
					if (j == 0) {
						Rock r = new Rock(x, y, "white");
						sq.setF(r);
					} else if (j == 1) {
						Night n = new Night(x, y, "white");
						sq.setF(n);

					} else if (j == 2) {
						Bishop b = new Bishop(x, y, "white");
						sq.setF(b);

					} else if (j == 3) {
						Quin q = new Quin(x, y, "white");
						sq.setF(q);

					} else if (j == 4) {
						King k = new King(x, y, "white");
						sq.setF(k);
					} else if (j == 5) {
						Bishop b = new Bishop(x, y, "white");
						sq.setF(b);

					} else if (j == 6) {
						Night n = new Night(x, y, "white");
						sq.setF(n);

					} else if (j == 7) {
						Rock r = new Rock(x, y, "white");
						sq.setF(r);
					}

				}

				board[i][j] = sq;
				x++;
			}

			y--;
		}
	}

	public static void print(Square[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}

			System.out.println();
		}
	}
}
