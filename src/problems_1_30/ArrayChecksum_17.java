package problems_1_30;

import java.util.Scanner;

public class ArrayChecksum_17 {
	private Scanner scan = new Scanner(System.in);
	private int iter;
	private static final int mod = 10000007;
	private static final int mult = 113;
	private long result = 0;

	public static void main(String[] args) {

		ArrayChecksum_17 ac = new ArrayChecksum_17();
		System.out.println(ac.result());

	}

	private long result() {
		iter = Integer.parseInt(scan.nextLine());
		while (iter-- > 0) {
			result = ((result + Integer.parseInt(scan.next())) * mult) % mod;
		}

		return result;
	}
}
