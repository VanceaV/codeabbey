package problems_31_60;

import java.util.Scanner;

public class MedianOfThree_41 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();

		while (iter-- > 0) {
			System.out.print(median(scan.nextInt(), scan.nextInt(), scan.nextInt()) + " ");
		}

	}

	static private int median(int a, int b, int c) {
		if (a > b && a < c || a > c && a < b)
			return a;
		else if (b > a && b < c || b > c && b < a)
			return b;
		else
			return c;
	}
}
