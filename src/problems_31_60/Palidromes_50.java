package problems_31_60;

import java.util.Scanner;

public class Palidromes_50 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Palidromes_50 p = new Palidromes_50();
		p.result();

	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();
		String st;
		while (iter-- > 0) {
			st = scan.nextLine();
			if (isPolidrome(st))
				System.out.print("Y" + " ");
			else
				System.out.print("N" + " ");

		}
	}

	private boolean isPolidrome(String st) {

		boolean r = true;
		st = st.replaceAll("\\W", "");
		st = st.toLowerCase();

		int iter = st.length() / 2;

		for (int i = 0; i < iter; i++) {
			if (st.charAt(i) != st.charAt(st.length() - 1 - i)) {
				r = false;
				break;
			}
		}
		return r;
	}
}
