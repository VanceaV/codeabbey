package problems_61_90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeRanges_62 {

	private Scanner scan = new Scanner(System.in);
	private static List<Integer> primes;

	public PrimeRanges_62(int n) {
		primes = new ArrayList<Integer>();
		generatePrimes(n);
	}

	public static void main(String[] args) {

		PrimeRanges_62 png = new PrimeRanges_62(3000_000);
		png.result();
	}

	private void result() {

		int iter = scan.nextInt();

		while (iter-- > 0) {

			int start = scan.nextInt();
			int finish = scan.nextInt();

			System.out.print(binarySearch(start, finish) + " ");
		}
	}

	private int binarySearch(int start, int finish) {

		int initS = 0, middle = 0, finishF = primes.size();
		int _start = 0, _finish = 0;
		int indexI = 0, indexJ = 0;

		while (_start != start) {
			middle = (finishF + initS) / 2;
			_start = primes.get(middle);
			if (_start < start)
				initS = middle;
			else
				finishF = middle;
		}

		initS = middle;
		indexI = middle;
		finishF = primes.size();

		while (_finish != finish) {
			middle = (finishF + initS) / 2;
			_finish = primes.get(middle);
			if (_finish < finish)
				initS = middle;
			else
				finishF = middle;
		}

		indexJ = middle;

		return (indexJ - indexI) + 1;
	}

	private void generatePrimes(int n) {
		primes.add(2);
		primes.add(3);
		primes.add(5);
		double radic = 0.0;
		int next = 5;
		int div = 0;
		do {
			next = next + 2;
			radic = Math.sqrt(next);
			for (int i = 0; i < primes.size(); i++) {
				if (primes.get(i) <= radic) {
					div = next % primes.get(i);
				}
				if (div == 0)
					break;
				if (primes.get(i) > radic) {
					primes.add(next);
					break;
				}
			}
		} while (next < n);
	}
}