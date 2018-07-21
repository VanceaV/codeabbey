package problems_121_150;

import java.util.Scanner;

public class SelectionSort_120 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ss();
	}

	private static void ss() {
		int r = scan.nextInt();
		int[] v = new int[r];
		for (int i = 0; i < r; i++) {
			v[i] = scan.nextInt();
		}
		for (int i = 0; i < r - 1; i++) {
			int max = 0;
			int indM = 0;
			int temp = 0;
			for (int j = 0; j < r - i; j++) {
				if (v[j] > max) {
					max = v[j];
					indM = j;
				}
			}
			temp = v[r - i - 1];
			v[r - i - 1] = v[indM];
			v[indM] = temp;
			System.out.print(indM + " ");
		}
	}
}