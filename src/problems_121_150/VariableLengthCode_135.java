package problems_121_150;

import java.util.Scanner;

public class VariableLengthCode_135 {

	private Scanner scan = new Scanner(System.in);

	private char charArray[] = { ' ', 't', 'n', 's', 'r', 'd', '!', 'c', 'm', 'g', 'b', 'v', 'k', 'q', 'e', 'o', 'a',
			'i', 'h', 'l', 'u', 'f', 'p', 'w', 'y', 'j', 'x', 'z' };

	private String stringArray[] = {

			"11", "1001", "10000", "0101", "01000", "00101", "001000", "000101", "000011", "0000100", "0000010",
			"00000001", "0000000001", "000000000001",

			"101", "10001", "011", "01001", "0011", "001001", "00011", "000100", "0000101", "0000011", "0000001",
			"000000001", "00000000001", "000000000000"

	};

	public static void main(String[] args) {
		VariableLengthCode_135 vlc = new VariableLengthCode_135();
		vlc.result();
	}

	private void result() {
		String st = scan.nextLine();
		st = singleSequence(st);

		int start = 0, finish = 8;

		for (int i = 0; i < st.length() / 8; i++) {

			String t = st.substring(start, finish);

			int decimal = Integer.parseInt(t, 2);
			String hexStr = Integer.toString(decimal, 16);
			t = hexStr.toUpperCase();
			if (t.length() == 1)
				t = "0" + t;
			System.out.print(t + " ");
			start = finish;
			finish += 8;

		}
	}

	private int findCharIndex(char c) {
		int index = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (c == charArray[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	private String returnString(int index) {
		return stringArray[index];
	}

	private String singleSequence(String input) {

		String ss = "";
		for (int i = 0; i < input.length(); i++) {
			ss += returnString(findCharIndex(input.charAt(i)));
		}

		if (ss.length() % 8 != 0)
			for (int i = 0; i < ss.length() % 8; i++)
				ss += "0";
		return ss;
	}
}
