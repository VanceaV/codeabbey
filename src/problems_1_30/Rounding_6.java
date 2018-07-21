package problems_1_30;

import java.util.Scanner;

public class Rounding_6 {
	private Scanner scan = new Scanner(System.in);

	private int iter;

	public static void main(String[] args) {
		Rounding_6 r = new Rounding_6();

		r.rounding_1();

	}

	float divide(int a, int b) {

		return (float) a / (float) b;

	}

	private int rounding(float c) {
		int a = Math.abs((int) c);
		float b = c - a;

		if (c > 0) {
			if (b >= 0.5)
				return a + 1;
			else
				return a;
		} else {
			if (b >= -0.5)
				return -a;
			else
				return -a - 1;

		}
	}

	void rounding_1() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0)
			System.out.print(rounding(divide(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()))) + " ");

	}

}
