package problems_1_30;

import java.util.Scanner;

public class MinimumOfThree_5 {

	private Scanner scan = new Scanner(System.in);

	private int iter;

	public static void main(String[] args) {
		MinimumOfThree_5 mt = new MinimumOfThree_5();

		mt.findMinims();

	}

	int minThree(int a, int b, int c) {

		if (a < b && a < c)
			return a;
		else if (b < a && b < c)
			return b;
		else return c;

	}

	void findMinims() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0)
			System.out.print(minThree(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()),Integer.parseInt(scan.next())) + " ");

	}

}
