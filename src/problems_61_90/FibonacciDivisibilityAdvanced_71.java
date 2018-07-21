package problems_61_90;

import java.util.Scanner;

public class FibonacciDivisibilityAdvanced_71 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		FibonacciDivisibilityAdvanced_71 fd = new FibonacciDivisibilityAdvanced_71();
		fd.result();

	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			System.out.print(index(scan.nextInt()) + " ");
		}
	}

	private static int index(int m) {

		int iter = 1, incr1 = 0, incr2 = 1, temp;
		do {
			++iter;
			temp = incr1 % m + incr2 % m;
			int even = temp % m;
			if (even == 0) {
				break;
			}
			incr1 = incr2;
			incr2 = temp;
		} while (true);

		return iter;
	}
}