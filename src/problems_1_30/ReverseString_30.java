package problems_1_30;

import java.util.Scanner;

public class ReverseString_30 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ReverseString_30 rs = new ReverseString_30();
		// String temp = rs.stringReverse(scan.nextLine());
		// System.out.println(temp);
		System.out.println(rs.stringReverse(scan.nextLine()));
	}

	String stringReverse(String st) {
		StringBuilder sb = new StringBuilder("");
		for (int i = st.length() - 1; i >= 0; i--) {
			sb.append(st.charAt(i));
		}
		return sb.toString();
	}
}
