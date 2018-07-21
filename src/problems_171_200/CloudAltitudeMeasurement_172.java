package problems_171_200;

import java.util.Scanner;

public class CloudAltitudeMeasurement_172 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		for (int i = 0; i < r; i++) {
			double d1 = sc.nextDouble();
			double a = sc.nextDouble();
			double b = sc.nextDouble();

			Height(d1, a, b);
		}
		sc.close();
	}

	static void Height(double d1, double a, double b) {

		final double PI = Math.PI;

		double rada = (a * PI) / 180.0;
		double radb = (b * PI) / 180.0;
		double d2 = (Math.tan(rada) * d1) / (Math.tan(radb) - Math.tan(rada));

		int HG = (int) Math.round(d2 * Math.tan(radb));

		System.out.print(HG + " ");

	}
}