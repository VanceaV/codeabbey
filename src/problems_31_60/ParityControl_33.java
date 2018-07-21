package problems_31_60;

import java.util.Scanner;

public class ParityControl_33 {

	private final int b = 0b1000_0000;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ParityControl_33 pc = new ParityControl_33();
		pc.result();
	}

	private void result() {

		int temp = 0, mod;
		do {
			temp = scan.nextInt();
			mod = bitsInInteger(temp);
			if (mod % 2 == 0) {
				if (temp > b)
					System.out.print((char) (temp - b));
				else
					System.out.print((char) (temp));
			}

		} while (temp != 32);
	}

	private int bitsInInteger(int no) {

		int count;
		for (count = 0; no > 0; ++count) {
			no &= no - 1;
		}
		return count;
	}
}
