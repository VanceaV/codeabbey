package problems_61_90.PawnMoveValidator_76;

class Night extends XY implements Figure {

	public Night(char x, char y, String type) {
		super(x, y, type);
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {

		boolean valid = true;

		vm = (x, y, _x, _y) -> {

			int difX = Math.abs(x - _x);
			int difY = Math.abs(y - _y);

			if (difY == 2 && difX == 1)
				return true;
			if (difX == 2 && difY == 1)
				return true;

			return false;
		};

		if (vm.goodSquare(x, y, sq.getX(), sq.getY())) {

			if (board[Math.abs(sq.getY() - 56)][sq.getX() - 97].getF() != null
					&& type.equals(board[Math.abs(sq.getY() - 56)][sq.getX() - 97].getF().getType()))
				valid = false;

			if (valid) {
				board[Math.abs(y - 56)][x - 97].setF(null);
				Move(sq);
				board[Math.abs(sq.getY() - 56)][sq.getX() - 97].setF(this);
			}

			return valid;
		}

		else
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
			return "N";
		else
			return "n";
	}
}