package problems_61_90;

import java.util.Scanner;

public class LevenshteinDistance_82 {

	private static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		LevenshteinDistance_82 ld = new LevenshteinDistance_82();
		ld.result();
	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();

		while (iter-- > 0) {
			String[] array = scan.nextLine().split(" ");
			System.out.print(levenshteinDistance(array[0], array[1]) + " ");
		}
	}

	private int levenshteinDistance(String first, String second) {

		char[] s = createCharArray(first);
		char[] t = createCharArray(second);
		int d[][] = new int[s.length + 1][t.length + 1];

		for (int i = 1; i <= s.length; i++)
			d[i][0] = i;
		for (int j = 1; j <= t.length; j++)
			d[0][j] = j;

		int substitutionCost = 0;

		for (int j = 1; j < t.length; j++)
			for (int i = 1; i < s.length; i++) {
				if (s[i] == t[j])
					substitutionCost = 0;
				else
					substitutionCost = 1;

				d[i][j] = minThree(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + substitutionCost);
			}

		return d[s.length - 1][t.length - 1];
	}

	private char[] createCharArray(String st) {
		char[] charArray = new char[st.length() + 1];
		for (int i = 0; i < st.length(); i++)
			charArray[i + 1] = st.charAt(i);
		return charArray;
	}

	private int minThree(int a, int b, int c) {
		if (a < b && a < c)
			return a;
		else if (b < a && b < c)
			return b;
		else
			return c;
	}
}
