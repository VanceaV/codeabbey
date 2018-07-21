package problems_31_60;

import java.util.Scanner;

public class CaesarShiftCipher_47 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		CaesarShiftCipher_47 csc = new CaesarShiftCipher_47();
		csc.result();
	}

	private void result() {
		int iter = scan.nextInt();
		int k = scan.nextInt();
		scan.nextLine();

		while (iter-- > 0) {
			String[] array = scan.nextLine().split(" ");
			for (String st : array)
				System.out.print(decode(st, k) + " ");
			System.out.print(" ");
		}
	}

	private String decode(String st, int k) {

		char[] array = st.toCharArray();

		char a = 'A', z = 'Z';

		k = 26 - k;

		char temp;
		for (int i = 0; i < st.length(); i++) {
			if (array[i] == '.')
				continue;
			temp = (char) (array[i] + k);
			if (temp > z)
				temp = (char) (a + temp - z - 1);
			array[i] = temp;
		}
		return String.valueOf(array);
	}

}
