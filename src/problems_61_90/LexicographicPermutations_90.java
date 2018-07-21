package problems_61_90;

import java.util.Scanner;

public class LexicographicPermutations_90 {

	private final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		LexicographicPermutations_90 lp = new LexicographicPermutations_90();
		lp.result();
	}

	void permutation(int[] numbers, int p) {

		for (int i = 0; i < p; i++) {
			int k = findIndexK(numbers);
			int l = findIndexL(numbers, k);
			swap(numbers, k, l);
			reverse(numbers, k);
		}
	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {

			int[] numbers = new int[12];
			for (int i = 0; i < 12; i++)
				numbers[i] = i + 1;

			int _iter = scan.nextInt();

			while (_iter-- > 0) {
				int k = findIndexK(numbers);
				int l = findIndexL(numbers, k);
				swap(numbers, k, l);
				reverse(numbers, k);
			}

			for (int i = 0; i < numbers.length; i++) {
				char a = (char) ('A' + numbers[i] - 1);
				System.out.print(a);
			}
			System.out.print(" ");
		}

	}

	private void reverse(int[] numbers, int k) {
		int index = 0;
		for (int i = k + 1; i <= k + ((numbers.length - k) / 2); i++) {
			int temp = numbers[i];
			numbers[i] = numbers[numbers.length - 1 - index];
			numbers[numbers.length - 1 - index] = temp;
			index++;
		}

	}

	private void swap(int[] numbers, int k, int l) {
		int temp = numbers[k];
		numbers[k] = numbers[l];
		numbers[l] = temp;
	}

	private int findIndexK(int[] numbers) {
		int k = 0;

		for (int i = 0; i < numbers.length - 1; i++) {

			if (numbers[i] < numbers[i + 1]) {
				k = i;
			}
		}
		return k;
	}

	private int findIndexL(int[] numbers, int k) {
		int l = 0;
		int _k = numbers[k];

		for (int i = k + 1; i < numbers.length; i++) {

			if (numbers[i] > _k) {
				l = i;
			}
		}
		return l;
	}
}
