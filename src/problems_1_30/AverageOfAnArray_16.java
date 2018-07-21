package problems_1_30;

import java.util.Scanner;

public class AverageOfAnArray_16 {
	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		AverageOfAnArray_16 aa = new AverageOfAnArray_16();
		aa.result();

	}

	private float averageArray(int... v) {

		float average = 0;

		for (int i : v) {
			average += i;
		}
		return average / v.length;

	}

	private int rounding(float c) {
		int a = Math.abs((int) c);
		float b = c - a;

		if (c > 0) {
			if (b >= 0.5)
				return a + 1;
			else
				return a;
		} else {
			if (b >= -0.5)
				return -a;
			else
				return -a - 1;

		}
	}

	private void result() {
		iter = Integer.parseInt(scan.nextLine());
		String array[];
		int[] v;

		while (iter-- > 0) {
			array = scan.nextLine().split(" ");
			v = new int[array.length - 1];
			for (int i = 0; i < array.length - 1; i++)
				v[i] = Integer.parseInt(array[i]);
			System.out.print(rounding(averageArray(v)) + " ");

		}
	}
}
