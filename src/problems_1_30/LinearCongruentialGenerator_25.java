package problems_1_30;

import java.util.Scanner;

public class LinearCongruentialGenerator_25 {

	private Scanner scan = new Scanner(System.in);
	private int iter;
	private int A, C, M, X0, N;

	public static void main(String[] args) {
		LinearCongruentialGenerator_25 lg = new LinearCongruentialGenerator_25();
		lg.result();
	}

	private void result() {

		iter = Integer.parseInt(scan.next());
		while (iter-- > 0) {
			A = Integer.parseInt(scan.next());
			C = Integer.parseInt(scan.next());
			M = Integer.parseInt(scan.next());
			X0 = Integer.parseInt(scan.next());
			N = Integer.parseInt(scan.next());

			do {
				X0 = (A * X0 + C) % M;
			} while (--N > 0);

			System.out.println(X0 + " ");
		}
	}
}
