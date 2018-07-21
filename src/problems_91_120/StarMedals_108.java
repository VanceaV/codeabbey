package problems_91_120;

import java.util.Scanner;

public class StarMedals_108 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();

		while (iter-- > 0) {
			int N = scan.nextInt();
			int T = scan.nextInt();
			System.out.print(N * T - N + " ");
		}
	}
}
