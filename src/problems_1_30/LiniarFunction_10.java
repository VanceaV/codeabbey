package problems_1_30;

import java.util.Scanner;

public class LiniarFunction_10 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {
		LiniarFunction_10 lf = new LiniarFunction_10();
		lf.result();

	}

	private float finda(int x1, int y1, int x2, int y2) {
		return (float) (y1 - y2) / (float) (x1 - x2);
	}

	private float findb(float a, int x1, int y1) {
		return y1 - a * x1;

	}

	void result() {
		iter = Integer.parseInt(scan.next());
		int x1, y1, x2, y2;
		float a, b;

		while (iter-- > 0) {
			x1 = Integer.parseInt(scan.next());
			y1 = Integer.parseInt(scan.next());
			x2 = Integer.parseInt(scan.next());
			y2 = Integer.parseInt(scan.next());

			a = finda(x1, y1, x2, y2);
			b = findb(a, x1, y1);
			System.out.println("(" + (int)a + " " + (int)b + ")"+" ");

		}
	}

}
