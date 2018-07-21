package problems_31_60;

import java.util.Scanner;

public class CollatzSequence_48 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();
		while (iter-- > 0) {
			int x = scan.nextInt();
			int k = 0;
			while (x != 1) {
				k++;
				if (x % 2 == 0)
					x /= 2;
				else
					x = 3 * x + 1;
			}
			System.out.print(k + " ");
		}
	}
}
