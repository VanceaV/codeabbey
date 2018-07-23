package problems_91_120;

import java.util.Scanner;

public class LuckyTickets_109 {

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		LuckyTickets_109 lt = new LuckyTickets_109();
		lt.result();
	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			int n = scan.nextInt();
			int b = scan.nextInt();
			System.out.print(CountLucky(n, b) + " ");
		}
	}

	private long CountLucky(int digits, int base) {

		if (digits == 1)
			return base;

		long[] perm = new long[digits * base];
		for (int i = 0; i < base; i++) {
			perm[i] = 1;
		}
		for (int k = 1; k < digits / 2; k++) {
			long[] temp = new long[perm.length];
			for (int i = 0; i < base; i++) {
				for (int j = perm.length - 1; j >= i; j--) {
					temp[j] += perm[j - i];
				}
			}
			perm = temp;
		}
		long luckyNumbers = 0;
		for (int i = 0; i < perm.length; i++) {
			luckyNumbers += (long) perm[i] * perm[i];
		}
		if (digits % 2 == 1)
			luckyNumbers *= base;
		return luckyNumbers;
	}
}
