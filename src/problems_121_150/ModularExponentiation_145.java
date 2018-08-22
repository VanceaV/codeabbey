package problems_121_150;

import java.util.Scanner;

public class ModularExponentiation_145 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int iter = scan.nextInt();
		scan.nextLine();

		while (iter-- > 0)

			System.out.print(operation(scan.nextLong(), scan.nextLong(), scan.nextLong()) + " ");
	}

	private static long operation(long a, long b, long m) {

		long result = 1;

		while (b > 0) {
			if (b % 2 == 1) {
				result = (result * a) % m;
			}
			a = (a * a) % m;
			b /= 2;
		}
		return result;
	}
}
