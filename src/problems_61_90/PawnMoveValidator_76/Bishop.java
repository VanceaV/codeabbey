package problems_61_90.PawnMoveValidator_76;

class Bishop extends XY implements Figure {

	public Bishop(char x, char y, String type) {
		super(x, y, type);
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {

		boolean valid = true;

		vm = (x, y, _x, _y) -> {

			if (Math.abs(x - _x) == Math.abs(y - _y))
				return true;
			else
				return false;
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
			for (int i = 0; i < range - 1; i++) {
				if (board[Math.abs((yTemp += yIter) - 56)][(xTemp += xIter) - 97].getF() != null) {
					valid = false;
					break;
				}
			}
			if (valid) {
				if (board[Math.abs((yTemp += yIter) - 56)][(xTemp += xIter) - 97].getF() != null) {
					if (board[Math.abs(yTemp - 56)][xTemp - 97].getF().getType().equals(this.type))
						valid = false;
				}
			}

			if (valid) {
				board[Math.abs(y - 56)][x - 97].setF(null);
				Move(sq);
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
			return "B";
		else
			return "b";
	}

}
