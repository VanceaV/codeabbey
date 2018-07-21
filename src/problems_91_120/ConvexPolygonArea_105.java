package problems_91_120;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConvexPolygonArea_105 {

	private static Scanner scan = new Scanner(System.in);

	private double XY[][];

	public ConvexPolygonArea_105() {
		readData();
	}

	public static void main(String[] args) {

		ConvexPolygonArea_105 cpa = new ConvexPolygonArea_105();
		System.out.println(cpa.polygonArea());
	}

	private String polygonArea() {
		double area = 0;

		double xRoot = XY[0][0];
		double yRoot = XY[0][1];

		for (int i = 1; i < XY.length - 1; i++) {

			double a = Math.sqrt((xRoot - XY[i][0]) * (xRoot - XY[i][0]) + (yRoot - XY[i][1]) * (yRoot - XY[i][1]));
			double b = Math.sqrt(
					(xRoot - XY[i + 1][0]) * (xRoot - XY[i + 1][0]) + (yRoot - XY[i + 1][1]) * (yRoot - XY[i + 1][1]));
			double c = Math.sqrt((XY[i][0] - XY[i + 1][0]) * (XY[i][0] - XY[i + 1][0])
					+ (XY[i][1] - XY[i + 1][1]) * (XY[i][1] - XY[i + 1][1]));
			area += triangleArea(a, b, c);

		}

		DecimalFormat df = new DecimalFormat("#.##");
		df.format(area);

		return df.format(area);
	}

	private double triangleArea(double a, double b, double c) {
		double s = (a + b + c) / 2.0;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	private void readData() {
		int iter = scan.nextInt();
		XY = new double[iter][2];

		for (int i = 0; i < iter; i++) {
			XY[i][0] = scan.nextInt();
			XY[i][1] = scan.nextInt();
		}
	}
}
