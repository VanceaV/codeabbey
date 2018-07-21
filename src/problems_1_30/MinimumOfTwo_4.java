package problems_1_30;

import java.util.Scanner;

public class MinimumOfTwo_4 {

	private Scanner scan = new Scanner(System.in);

	private int iter;

	public static void main(String[] args) {
		MinimumOfTwo_4 mt = new MinimumOfTwo_4();

		mt.findMinims();

	}

	int minTwo(int a, int b) {

		if (a < b)
			return a;
		else
			return b;

	}

	void findMinims() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0)
			System.out.print(minTwo(Integer.parseInt(scan.next()), Integer.parseInt(scan.next())) + " ");

	}

}
