package problems_31_60;

import java.util.Scanner;

public class QuadraticEquation_38 {

	private static Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		QuadraticEquation_38 qe = new QuadraticEquation_38();
		qe.result();
	}

	private void result() {

		iter = scan.nextInt();
		double a, b, c;

		while (iter-- > 0) {

			a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();

			if (discriminat(a, b, c) >= 0) {
				int[] roots = roots(a, b, c);
				if (iter != 0)
					System.out.print(roots[0] + " " + roots[1] + "; ");
				else
					System.out.print(roots[0] + " " + roots[1]);
			} else {
				String[] complexRoots = complexRoots(a, b, c);
				if (iter != 0)
					System.out.print(complexRoots[0] + " " + complexRoots[1] + "; ");
				else
					System.out.print(complexRoots[0] + " " + complexRoots[1]);
			}
		}
	}

	private double discriminat(double a, double b, double c) {

		return Math.pow(b, 2) - 4 * a * c;

	}

	private int[] roots(double a, double b, double c) {
		int[] roots = new int[2];

		roots[0] = (int) ((-b + Math.sqrt(discriminat(a, b, c))) / (2 * a));

		roots[1] = (int) ((-b - Math.sqrt(discriminat(a, b, c))) / (2 * a));

		return roots;
	}

	private String[] complexRoots(double a, double b, double c) {

		String[] complexRoots = new String[2];

		double posD = Math.sqrt(Math.abs(discriminat(a, b, c)));

		complexRoots[0] = String.valueOf((int) (-b / (2 * a))) + "+" + String.valueOf((int) (posD / (2 * a))) + "i";
		complexRoots[1] = String.valueOf((int) (-b / (2 * a))) + "-" + String.valueOf((int) (posD / (2 * a))) + "i";

		return complexRoots;
	}
}
