package problems_61_90;

import java.util.Scanner;

public class PointToSegmentDistance_77 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PointToSegmentDistance_77 psd = new PointToSegmentDistance_77();
		psd.result();
	}

	private void result() {

		int iter = scan.nextInt();
		while (iter-- > 0) {
			int x1 = scan.nextInt(), y1 = scan.nextInt(), x2 = scan.nextInt(), y2 = scan.nextInt(), xp = scan.nextInt(),
					yp = scan.nextInt();
			double b = distance_2_Points(x1, y1, x2, y2);
			double a = distance_2_Points(x2, y2, xp, yp);
			double c = distance_2_Points(x1, y1, xp, yp);
			double result = 0;

			if (angle(a, b, c)) {
				result = min(a, c);
			} else {
				double area = triangleArea(a, b, c);
				result = height(b, area);
			}
			System.out.println(result + " ");

		}
	}

	private boolean angle(double a, double b, double c) {

		if (b == (a + c))
			return true;

		if (a * a > (b * b + c * c) || c * c > (a * a + b * b))
			return true;

		else
			return false;
	}

	private double distance_2_Points(int x0, int y0, int x1, int y1) {
		return Math.sqrt((x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1));
	}

	private double triangleArea(double a, double b, double c) {
		double p = (a + b + c) / 2.0;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	private double height(double b, double area) {
		return 2 * (area / b);
	}

	private double min(double a, double b) {
		if (a < b)
			return a;
		else
			return b;
	}
}
