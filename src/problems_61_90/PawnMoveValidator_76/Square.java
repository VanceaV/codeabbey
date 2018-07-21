package problems_61_90.PawnMoveValidator_76;

class Square extends XY {

	private XY f = null;

	public Square(char x, char y, String type) {
		super(x, y, type);
	}

	public XY getF() {
		return f;
	}

	public void setF(XY f) {
		this.f = f;
	}

	@Override
	public String toString() {
		if (f == null)
			return "-";
		else
			return f.toString();
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {
		if (f != null)
			return f.isValidMove(vm, sq, board);
		else
			return false;
	}
}