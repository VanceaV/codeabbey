package problems_61_90;

import java.util.Scanner;

public class PrimeNumberGeneration_61 {

	private Scanner scan = new Scanner(System.in);

	public PrimeNumberGeneration_61(int n) {
		primes = new int[n];
		generatePrimes(n);
	}

	private static int[] primes;

	public static void main(String[] args) {

		PrimeNumberGeneration_61 png = new PrimeNumberGeneration_61(200000);
		png.result();
	}

	private void result() {

		int iter = scan.nextInt();

		while (iter-- > 0) {

			int toCheck = scan.nextInt();

			System.out.print(primes[toCheck - 1] + " ");
		}
	}

	private void generatePrimes(int n) {
		primes[0] = 2;
		primes[1] = 3;

		int index = 1, numbersOfPrimes = 2, checkForPrime = 4;
		while (numbersOfPrimes < n) {
			if (isPrime(checkForPrime)) {
				primes[++index] = checkForPrime;
				checkForPrime++;
				numbersOfPrimes++;
			} else {
				checkForPrime++;
			}
		}
	}

	boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
