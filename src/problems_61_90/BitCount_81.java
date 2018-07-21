package problems_61_90;

import java.util.Scanner;

public class BitCount_81 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String a[]) {
		result();
	}

	public static void result() {
		int iter = scan.nextInt();
		while (iter-- > 0)
			System.out.print(numberOfBits(scan.nextInt()) + " ");
	}

	public static int numberOfBits(int n) {
		int count = 0;
		Integer i = new Integer(n);
		String binary = Integer.toBinaryString(i);

		for (int j = 0; j < binary.length(); j++)
			if (binary.charAt(j) == '1')
				count++;
		return count;
	}
}
