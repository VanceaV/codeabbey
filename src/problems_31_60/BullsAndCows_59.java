package problems_31_60;

import java.util.Scanner;

public class BullsAndCows_59 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String secrretCode = scan.next();
		int iter = scan.nextInt();
		scan.nextLine();

		int result[];

		while (iter-- > 0) {
			result = b_and_C(secrretCode, scan.next());
			System.out.print(result[0] + "-" + result[1] + " ");
		}
	}

	private static int[] b_and_C(String secrretCode, String guess) {

		int[] forReturn = new int[2];

		int first = 0, second = 0;

		for (int i = 0; i < secrretCode.length(); i++) {
			if (guess.charAt(i) == secrretCode.charAt(i))
				first++;
			for (int j = 0; j < secrretCode.length(); j++) {
				if (i != j && guess.charAt(i) == secrretCode.charAt(j))
					second++;
			}
		}

		forReturn[0] = first;
		forReturn[1] = second;

		return forReturn;
	}
}
