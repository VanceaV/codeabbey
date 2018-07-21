package problems_1_30;

import java.util.Scanner;

public class WeightedSumOfDigits_13 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		WeightedSumOfDigits_13 wd = new WeightedSumOfDigits_13();
		wd.result();

	}

	private int numberOfDigits(int number) {

		int numOfDig = 0;

		while (number / 10.0 > 0) {
			numOfDig++;
			number /= 10;
			if (number == 10) {
				numOfDig+=2;
				break;
			}
		}

		return numOfDig;
	}

	private void result() {
		iter = Integer.parseInt(scan.next());
		int sum, testCase, numberOfDigits;

		while (iter-- > 0) {
			testCase = Integer.parseInt(scan.next());
			numberOfDigits = numberOfDigits(testCase);
			sum = 0;
			while (testCase / 10.0 > 0) {
				sum += (testCase % 10) * numberOfDigits--;
				testCase /= 10;
				if (testCase == 10) {
					sum++;
					break;
				}
			}

			System.out.print(sum + " ");

		}

	}

}
