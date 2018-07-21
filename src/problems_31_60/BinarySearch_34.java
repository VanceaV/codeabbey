package problems_31_60;

import java.util.Scanner;

public class BinarySearch_34 {
	private static Scanner scan = new Scanner(System.in);
	private static final double precision = 1E-7;

	public static void main(String[] args) {

		int iter = new Integer(scan.next());

		while (iter-- > 0) {

			double a = new Double(scan.nextDouble());
			double b = new Double(scan.nextDouble());
			double c = new Double(scan.nextDouble());
			double d = new Double(scan.nextDouble());

			result(a, b, c, d);

			System.out.print(result(a, b, c, d) + " ");
		}

	}

	private static double result(double a, double b, double c, double d) {

		double temp = 1;
		double initS = 0, middle;
		double finishF = 100;

		while (Math.abs(temp) > precision) {
			middle = (finishF + initS) / 2.0;
			temp = equation(a, b, c, d, middle);
			if (temp<0)
				initS = middle;
			else
				finishF = middle;
		}

		return initS;
	}

	private static double equation(double a, double b, double c, double d, double x) {

		return a * x + b * Math.sqrt(Math.pow(x, 3.0)) - c * Math.exp((x * -1) / 50.0) - d;

	}
}
