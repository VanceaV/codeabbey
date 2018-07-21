package problems_31_60;

import java.util.Scanner;

public class DiceRolling_43 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		DiceRolling_43 dr = new DiceRolling_43();
		dr.result();
	}

	private void result() {

		int iter = new Integer(scan.next());
		scan.nextLine();

		while (iter-- > 0) {

			double d = scan.nextDouble();
			d *= 6;
			System.out.print(floor(d) + " ");
		}
	}

	private int floor(double d) {
		return (int) d + 1;
	}
}
