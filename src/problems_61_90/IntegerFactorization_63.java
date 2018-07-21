package problems_61_90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegerFactorization_63 {

	private static Scanner scan = new Scanner(System.in);

	public static List<Long> primeFactors(long numbers) {
		Long n = numbers;
		List<Long> factors = new ArrayList<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public static void main(String[] args) {

		int iter = new Integer(scan.next());
		List<Long> factors;

		while (iter-- > 0) {

			factors = primeFactors(scan.nextLong());

			for (int i = 0; i < factors.size(); i++) {
				if (i != factors.size() - 1)
					System.out.print(factors.get(i) + "*");
				else {
					System.out.print(factors.get(i) + " ");
				}
			}
		}
	}
}
