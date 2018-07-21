package problems_61_90.PawnMoveValidator_76;

class King extends XY implements Figure {

	public King(char x, char y, String type) {
		super(x, y, type);
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {

		boolean valid = true;

		vm = (x, y, _x, _y) -> {

			if ((Math.abs(x - _x) == 0 || Math.abs(y - _x) == 1) && (Math.abs(y - _y) == 0 || Math.abs(y - _y) == 1))
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

			if (board[Math.abs((yTemp += yIter) - 56)][(xTemp += xIter) - 97].getF() != null
					&& board[Math.abs(yTemp - 56)][xTemp - 97].getF().getType().equals(this.type))
				valid = false;

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
			return "K";
		else
			return "k";
	}
}
