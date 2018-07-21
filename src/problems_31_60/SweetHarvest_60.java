package problems_31_60;

import java.util.Scanner;

public class SweetHarvest_60 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();
		scan.nextLine();

		while (iter-- > 0) {

			String[] array = scan.nextLine().split(" ");
			int[] _array = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				_array[i] = Integer.parseInt(array[i]);
			}

			System.out.print(bestResult(_array, 0, _array[0]) + " ");
		}
	}

	private static int bestResult(int[] array, int i, int collect) {
		if (i == array.length - 1 || i == array.length - 2)
			return collect;
		else {
			int a = 0, b = 0;
			if (i + 2 <= array.length - 1)
				a = bestResult(array, i + 2, collect + array[i + 2]);
			if (i + 3 <= array.length - 1)
				b = bestResult(array, i + 3, collect + array[i + 3]);

			if (a > b)
				return a;
			else
				return b;
		}
	}
}
