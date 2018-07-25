package problems_91_120;

import java.math.BigInteger;
import java.util.Scanner;

public class LuckyTicketsAdvanced_110 {

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		LuckyTicketsAdvanced_110 lta = new LuckyTicketsAdvanced_110();
		lta.result();
	}

	private void result() {

		int n = scan.nextInt();
		int b = scan.nextInt();
		System.out.print(CountLucky(n, b) + " ");
	}

	private BigInteger CountLucky(int digits, int base) {

		if (digits == 1)
			return BigInteger.valueOf(base);

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
		BigInteger luckyNumbers = BigInteger.ZERO;
		for (int i = 0; i < perm.length; i++) {
			luckyNumbers = luckyNumbers.add(BigInteger.valueOf(perm[i]).pow(2));
		}

		return luckyNumbers;
	}
}
