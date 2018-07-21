package problems_1_30;

import java.util.Scanner;

public class FahrenheitToCelsius_7 {

	private Scanner scan = new Scanner(System.in);

	private final static float FREEZ_C = 0;
	private final static float BOIL_C = 100;
	private final static float FREEZ_F = 32;
	private final static float BOIL_F = 212;

	private final static float COEF = (BOIL_F - FREEZ_F) / (BOIL_C - FREEZ_C);

	private int iter;

	public static void main(String[] args) {
		FahrenheitToCelsius_7 fc = new FahrenheitToCelsius_7();
		fc.conversionF_C();

	}

	int rounding(float c) {
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

	void conversionF_C() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0)
			System.out.print(rounding((float) (Integer.parseInt(scan.next())-32) / COEF) + " ");

	}

}
