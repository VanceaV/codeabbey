package problems_61_90.PawnMoveValidator_76;

abstract class XY {

	protected char x, y;
	protected String type;

	public XY(char x, char y, String type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	abstract public String toString();

	abstract public boolean isValidMove(ValidMove vm, Square sq, Square[][] board);

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	public char getY() {
		return y;
	}

	public void setY(char y) {
		this.y = y;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}