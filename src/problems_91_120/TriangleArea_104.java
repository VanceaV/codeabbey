package problems_91_120;

import java.util.Scanner;

public class TriangleArea_104 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			int X1 = scan.nextInt();
			int Y1 = scan.nextInt();
			int X2 = scan.nextInt();
			int Y2 = scan.nextInt();
			int X3 = scan.nextInt();
			int Y3 = scan.nextInt();

			double a = Math.sqrt((X1 - X2) * (X1 - X2) + (Y1 - Y2) * (Y1 - Y2));
			double b = Math.sqrt((X2 - X3) * (X2 - X3) + (Y2 - Y3) * (Y2 - Y3));
			double c = Math.sqrt((X3 - X1) * (X3 - X1) + (Y3 - Y1) * (Y3 - Y1));

			double s = (a + b + c) / 2.0;

			double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			System.out.print(area + " ");

		}
	}
}
