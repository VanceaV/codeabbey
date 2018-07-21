package problems_31_60;

import java.util.Scanner;

public class SavingsCalculator_35 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = new Integer(scan.next());

		while (iter-- > 0)

			System.out.print(
					savingCalculator(new Integer(scan.next()), new Integer(scan.next()), new Integer(scan.next()))+" ");
	}
	private static int savingCalculator(double s, double r, double p) {
		int years = 0;
		do {
			s *= (1 + p / 100);
			years++;
		} while (s < r);
		return years;
	}
}
