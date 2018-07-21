package problems_91_120;

import java.util.Scanner;

public class GirlsAndPigs_97 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GirlsAndPigs_97 gap = new GirlsAndPigs_97();
		gap.result();
	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0)
			System.out.print(solutions(scan.nextInt(), scan.nextInt()) + " ");

	}

	private int solutions(int legs, int breasts) {

		int count = 0;

		for (int i = 2; i <= legs - 4; i += 2)
			if ((legs - i) % 4 == 0 && ((breasts - i) % ((legs - i) / 4) == 0)
					&& ((breasts - i) / ((legs - i) / 4)) % 2 == 0)
				count++;
		return count;
	}
}
