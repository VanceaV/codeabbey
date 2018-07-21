package problems_31_60;

import java.util.Scanner;

public class DoubleDiceRoll_44 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();

		while (iter-- > 0) {
			System.out.print(sumDice(scan.nextInt(), scan.nextInt()) + " ");
		}

	}

	private static int sumDice(int a, int b) {
		return ((a % 6) + 1) + ((b % 6) + 1);
	}
}
