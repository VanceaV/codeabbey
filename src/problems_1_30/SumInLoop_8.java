package problems_1_30;

import java.util.Scanner;

public class SumInLoop_8 {

	private Scanner scan = new Scanner(System.in);

	private int iter;

	public static void main(String[] args) {
		SumInLoop_8 si = new SumInLoop_8();

		System.out.println(si.sumLoop());

	}

	int sumLoop() {
		int result = 0;
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0)
			result += Integer.parseInt(scan.next());
		return result;
	}

}
