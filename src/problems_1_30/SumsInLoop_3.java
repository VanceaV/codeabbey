package problems_1_30;

import java.util.Scanner;

public class SumsInLoop_3 {

	private Scanner scan = new Scanner(System.in);

	private int iter;

	public static void main(String[] args) {
		SumsInLoop_3 si = new SumsInLoop_3();

		si.sumsLoop();

	}

	void sumsLoop() {
		int result = 0, inneriter = 0;
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0) {

			result = 0;
			inneriter = 2;

			while (inneriter-- > 0)
				result += Integer.parseInt(scan.next());

			System.out.print(result + " ");
		}

	}

}
