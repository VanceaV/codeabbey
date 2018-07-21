package problems_121_150;

import java.util.Scanner;
import java.math.*;

public class CombinationsCounting_128 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CombinationsCounting_128 cc = new CombinationsCounting_128();
		cc.result();
	}

	private void result() {
		int r = scan.nextInt();
		for (int i = 0; i < r; i++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			System.out.print(numberOfCombinations(n, k) + " ");
		}
	}

	private BigDecimal numberOfCombinations(int n, int k) {
		BigDecimal count = BigDecimal.valueOf(1L);
		for (int j = 1; j <= n; j++) {
			BigDecimal inc = BigDecimal.valueOf(j);
			count = count.multiply(inc);
		}
		BigDecimal count1 = BigDecimal.valueOf(1L);
		for (int s = 1; s <= k; s++) {
			BigDecimal inc1 = BigDecimal.valueOf(s);
			count1 = count1.multiply(inc1);
		}
		BigDecimal count2 = BigDecimal.valueOf(1L);
		for (int l = 1; l <= (n - k); l++) {
			BigDecimal inc2 = BigDecimal.valueOf(l);
			count2 = count2.multiply(inc2);
		}
		BigDecimal f = count.divide(count1.multiply(count2));
		return f;
	}
}