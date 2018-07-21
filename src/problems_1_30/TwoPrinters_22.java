package problems_1_30;

import java.util.Scanner;

public class TwoPrinters_22 {
	private Scanner scan = new Scanner(System.in);
	private int iter;
	private double x, y, n;

	public static void main(String[] args) {

		TwoPrinters_22 tp = new TwoPrinters_22();
		tp.result();
	}

	private void result() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0) {
			x = Integer.parseInt(scan.next());
			y = Integer.parseInt(scan.next());
			n = Integer.parseInt(scan.next());

			System.out.println(finalResult(seconds(x, y, n)) + " ");
		}
	}

	private int seconds(double x, double y, double n) {
		return (int) (n / ((1 / x) + (1 / y)));
	}

	private int finalResult(int seconds) {
		int xSec = seconds + (int) x - seconds % (int) x;
		int ySec = seconds + (int) y - seconds % (int) y;
		if (xSec < ySec)
			return xSec;
		else if (xSec == ySec)
			return xSec;
		else
			return ySec;

	}
}
