package problems_1_30;

import java.util.Scanner;

public class GreatestCommonDivisor_26 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = new Integer(scan.next());

		while (iter-- > 0) {
			int a = new Integer(scan.next()), b = new Integer(scan.next()), _a = a, _b = b;
			while (a != b) {

				if (a > b)
					a -= b;
				else
					b -= a;
			}
			System.out.print("(" + a + " " + (_a * _b) / a + ")" + " ");
		}
	}
}
