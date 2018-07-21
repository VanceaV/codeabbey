package problems_1_30;

import java.util.Scanner;

public class SquareRoot_18 {
	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		SquareRoot_18 sr = new SquareRoot_18();
		sr.result();

	}

	double step(double r, double x) {

		double step = 0;
		step = (r + x / r) / 2;

		return step;
	}

	private void result() {

		double r, x, i;

		iter = Integer.parseInt(scan.next());
		while (iter-- > 0) {
			x = Integer.parseInt(scan.next());
			i = Integer.parseInt(scan.next());
			r = 1;
			while (i-- > 0)
				r = step(r, x);
			System.out.print(r + " ");

		}
	}
}
