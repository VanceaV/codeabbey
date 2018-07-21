package problems_31_60;

import java.util.Scanner;

public class PythagoreanTheorem_52 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();
		while (iter-- > 0) {
			int t = pitagora(scan.nextInt(), scan.nextInt(), scan.nextInt());
			if (t == 1)
				System.out.print("R" + " ");
			else if (t == 2)
				System.out.print("A" + " ");
			else
				System.out.print("O" + " ");
		}
	}

	private static int pitagora(int a, int b, int c) {

		double pitagora = Math.sqrt(a * a + b * b);
		if (pitagora == c)
			return 1;
		else if (pitagora > c)
			return 2;
		else
			return 3;

	}
}
