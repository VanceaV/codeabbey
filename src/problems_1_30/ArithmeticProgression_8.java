package problems_1_30;

import java.util.Scanner;

public class ArithmeticProgression_8 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		ArithmeticProgression_8 ap = new ArithmeticProgression_8();

		ap.result();

	}

	int calculateTheSum(int A, int B, int N) {

		return A * N + B * ((N-1 * (N - 2)) / 2);
	}

	void result() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0) {
			
			System.out.print(calculateTheSum(Integer.parseInt(scan.next()),Integer.parseInt(scan.next()),Integer.parseInt(scan.next()))+" ");

		}
	}

}
