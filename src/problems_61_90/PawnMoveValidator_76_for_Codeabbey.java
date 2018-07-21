package problems_61_90;

import java.util.Scanner;

public class PawnMoveValidator_76_for_Codeabbey {

	private static Scanner scan = new Scanner(System.in);
	private static Square[][] board;

	public PawnMoveValidator_76_for_Codeabbey() {
		board = new Square[8][8];
	}

	public static void main(String[] args) {
		PawnMoveValidator_76_for_Codeabbey pmv = new PawnMoveValidator_76_for_Codeabbey();
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

interface Figure {
	public void Move(Square sq);
}

interface ValidMove {
	boolean goodSquare(char x, char y, char _x, char _y);
}

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

class Rock extends XY implements Figure {

	public Rock(char x, char y, String type) {
		super(x, y, type);
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {

		boolean valid = true;

		vm = (x, y, _x, _y) -> {

			if (x == _x || y == _y)
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
			return "R";
		else
			return "r";
	}

}

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

class Quin extends XY implements Figure {

	public Quin(char x, char y, String type) {
		super(x, y, type);
	}

	@Override
	public boolean isValidMove(ValidMove vm, Square sq, Square[][] board) {

		boolean valid = true;

		vm = (x, y, _x, _y) -> {

			if (x == _x || y == _y)
				return true;

			if (Math.abs(x - _x) == Math.abs(y - _y))
				return true;

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
			return "Q";
		else
			return "q";
	}
}
