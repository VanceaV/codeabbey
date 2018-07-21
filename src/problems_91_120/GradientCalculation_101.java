package problems_91_120;

import java.util.Scanner;

public class GradientCalculation_101 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GradientCalculation_101 gc = new GradientCalculation_101();
		gc.result();
	}

	private void result() {
		int iter = scan.nextInt();
		double A = scan.nextDouble();
		double B = scan.nextDouble();
		double C = scan.nextDouble();

		double dt = 0.001;

		while (iter-- > 0) {
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			double fx0y0 = function(A, B, C, x, y);
			double fx0_dty0 = function(A, B, C, x + dt, y);
			double fx0y0_dt = function(A, B, C, x, y + dt);
			double gx = (fx0_dty0 - fx0y0) / dt;
			double gy = (fx0y0_dt - fx0y0) / dt;
			int degree = (int) Math.round(atan(gy, gx));
			System.out.print(degree + 180 + " ");
		}

	}

	private double atan(double y, double x) {
		return Math.toDegrees(Math.atan2(y, x));
	}

	private double function(double A, double B, double C, double x, double y) {

		return (x - A) * (x - A) + (y - B) * (y - B) + C * Math.exp(-((x + A) * (x + A)) - ((y + B) * (y + B)));

	}
}