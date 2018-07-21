package problems_31_60;

import java.util.Scanner;

public class KingAndQueen_53 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();
		scan.nextLine();
		while (iter-- > 0) {
			String[] st = scan.nextLine().split(" ");
			if (find(st[0], st[1]))
				System.out.print("Y" + " ");
			else
				System.out.print("N" + " ");
		}
	}

	private static boolean find(String king, String quin) {

		char[] _king = king.toCharArray();
		char[] _quin = quin.toCharArray();
		if (_king[0] == _quin[0] || _king[1] == _quin[1])
			return true;

		if (Math.abs(_king[0] - _quin[0]) == Math.abs(_king[1] - _quin[1]))
			return true;

		return false;
	}
}
