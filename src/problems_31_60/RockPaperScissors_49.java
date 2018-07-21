package problems_31_60;

import java.util.Scanner;

public class RockPaperScissors_49 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		RockPaperScissors_49 rps = new RockPaperScissors_49();
		rps.result();
	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();

		String st;
		String[] array;

		while (iter-- > 0) {
			st = scan.nextLine();
			array = st.split(" ");
			int first = 0, second = 0;
			for (String t : array) {
				int r = check(t);
				if (r == 1)
					first++;
				if (r == 2)
					second++;
			}
			if (first > second)
				System.out.print(1 + " ");
			else
				System.out.print(2 + " ");
		}
	}

	private int check(String st) {
		int result = 0;

		int temp = st.charAt(0) + st.charAt(1);

		if (temp == 165 && st.charAt(0) < st.charAt(1))
			return 1;
		if (temp == 165 && st.charAt(0) > st.charAt(1))
			return 2;

		if (temp == 163 && st.charAt(0) > st.charAt(1))
			return 1;
		if (temp == 163 && st.charAt(0) < st.charAt(1))
			return 2;

		if (temp == 162 && st.charAt(0) < st.charAt(1))
			return 1;
		if (temp == 162 && st.charAt(0) > st.charAt(1))
			return 2;

		return result;
	}
}
