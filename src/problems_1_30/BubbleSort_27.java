package problems_1_30;

import java.util.Scanner;

public class BubbleSort_27 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = new Integer(scan.next()), pass = 0, swap = 0, t;
		boolean isSwap = true;
		int array[] = new int[iter];

		for (int i = 0; i < iter; i++)
			array[i] = new Integer(scan.next());

		while (isSwap) {
			isSwap = false;
			pass++;
			for (int i = 0; i < iter - 1; i++) {
				if (array[i] > array[i + 1]) {
					t = array[i];
					array[i] = array[i + 1];
					array[i + 1] = t;
					swap++;
					isSwap = true;

				}
			}
		}
		System.out.println(pass + " " + swap);
	}
}
