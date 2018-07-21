package problems_61_90.PawnMoveValidator_76;

class Pawn extends XY implements Figure {

	private boolean firstmove = true;

	public Pawn(char x, char y, String type) {
		super(x, y, type);
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {

		boolean valid = true;

		vm = (x, y, _x, _y) -> {

			if (type.equals("white") && (_y < y))
				return false;
			if (type.equals("black") && (_y > y))
				return false;

			if (firstmove) {
				if (Math.abs(y - _y) == 2 && x - _x == 0) // move forward
					return true;
				else if (Math.abs(y - _y) == 1 && (Math.abs(x - _x) == 1 || x - _x == 0)) // take the figure + move
																							// forward
					return true;
				else
					return false;
			} else {
				if (Math.abs(y - _y) == 1 && (Math.abs(x - _x) == 1 || x - _x == 0))// // take the figure + move forward
					return true;
				else
					return false;
			}

		};

		if (vm.goodSquare(x, y, sq.getX(), sq.getY())) {

			int xIter, yIter, xTemp = x, yTemp = y;
			if ((sq.getX() - x) != 0) {
				xIter = Math.abs(sq.getX() - x) / (sq.getX() - x);
			} else
				xIter = 0;

			if ((sq.getY() - y) != 0) {
				yIter = Math.abs(sq.getY() - y) / (sq.getY() - y);
			} else
				yIter = 0;

			int range = (Math.abs(sq.getX() - x) >= Math.abs(sq.getY() - y)) ? Math.abs(sq.getX() - x)
					: Math.abs(sq.getY() - y);

			if (x != sq.getX()) {
				if (board[Math.abs(sq.getY() - 56)][sq.getX() - 97].getF().getType().equals(type)) {
					valid = false;
				}

			} else {

				for (int i = 0; i < range; i++) {
					if (board[Math.abs((yTemp += yIter) - 56)][(xTemp += xIter) - 97].getF() != null) {
						valid = false;
						break;
					}
				}
			}

			if (valid) {
				board[Math.abs(y - 56)][x - 97].setF(null);
				Move(sq);
				firstmove = false;
				board[Math.abs(sq.getY() - 56)][sq.getX() - 97].setF(this);
			}

			return valid;

		} else
			return false;
	}

	@Override
	public void Move(Square sq) {
		x = sq.getX();
		y = sq.getY();
	}

	@Override
	public String toString() {

		if (type.equals("white"))
			return "P";
		else
			return "p";
	}
}