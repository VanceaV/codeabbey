package problems_61_90;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciDivisibility_69 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		FibonacciDivisibility_69 fd = new FibonacciDivisibility_69();
		fd.result();

	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			System.out.print(index(scan.nextInt()) + " ");
		}
	}

	private static int index(int m) {

		BigInteger preced = new BigInteger("1"), next = new BigInteger("1"), temp = new BigInteger("0"),
				_m = new BigInteger(String.valueOf(m));
		int iter = 2;
		BigInteger zero = BigInteger.ZERO;

		while (next.mod(_m).compareTo(zero) != 0) {
			temp = next;
			next = next.add(preced);
			preced = temp;
			iter++;
		}
		return iter;
	}
}
