package problems_31_60;

import java.util.Scanner;

public class PythagoreanTriples_54 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();
		while (iter-- > 0) {
			System.out.print(find_cpower2(scan.nextInt()) + " ");
		}
	}

	private static long find_cpower2(long num) {
		long a = 0, b = 0; 
		long c = 0;

		for (int i = 1; i < num / 2; i++) {
			if (num * ((num / 2) - i) % (num - i) == 0) {
				b = i;
				break;
			}
		}
		a = num * ((num / 2) - b) / (num - b);

		c = num - a - b;
		c = c * c;
		return c;
	}
}
