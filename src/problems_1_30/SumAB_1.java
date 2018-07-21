package problems_1_30;

import java.util.Scanner;

public class SumAB_1 {

	private static Scanner scan = new Scanner(System.in);

	private static int a, b, c;

	public static void main(String[] args) {

		a = Integer.parseInt(scan.next());
		b = Integer.parseInt(scan.next());
		c = sumTwoNumbers(a, b);
		System.out.println(c);
	}

	static int sumTwoNumbers(int a, int b) {
		return a + b;
	}

}
