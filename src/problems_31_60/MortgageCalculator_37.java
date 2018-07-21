package problems_31_60;

import java.util.Scanner;

public class MortgageCalculator_37 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(
				morgageCalculator(new Integer(scan.next()), new Integer(scan.next()), new Integer(scan.next())));

	}

	private static long morgageCalculator(float p, float r, float l) {
		return Math.round((p * r / 1200 * Math.pow(1 + r / 1200, l)) / (Math.pow(1 + r / 1200, l) - 1));
	}
}
