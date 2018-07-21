package problems_1_30;

import java.util.Scanner;

public class MaximumOfArray_15 {

	private Scanner scan = new Scanner(System.in);
	private int iter = 300, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		MaximumOfArray_15 ma = new MaximumOfArray_15();
		ma.result();

	}

	private void result() {

		int read = 0;
		while (iter-- > 0) {

			read = Integer.parseInt(scan.next());
			if (read > max)
				max = read;
			if (read < min)
				min = read;
		}

		System.out.println(max + " " + min);
	}

}
