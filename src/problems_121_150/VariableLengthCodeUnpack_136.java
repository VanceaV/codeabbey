package problems_121_150;

import java.util.Scanner;

public class VariableLengthCodeUnpack_136 {

	private Scanner scan = new Scanner(System.in);

	private final String base32 = "0123456789ABCDEFGHIJKLMNOPQRSTUV";

	private char charArray[] = { ' ', 't', 'n', 's', 'r', 'd', '!', 'c', 'm', 'g', 'b', 'v', 'k', 'q', 'e', 'o', 'a',
			'i', 'h', 'l', 'u', 'f', 'p', 'w', 'y', 'j', 'x', 'z' };

	private String stringArray[] = {

			"11", "1001", "10000", "0101", "01000", "00101", "001000", "000101", "000011", "0000100", "0000010",
			"00000001", "0000000001", "000000000001",

			"101", "10001", "011", "01001", "0011", "001001", "00011", "000100", "0000101", "0000011", "0000001",
			"000000001", "00000000001", "000000000000"
	};

	public static void main(String[] args) {

		VariableLengthCodeUnpack_136 vlcu = new VariableLengthCodeUnpack_136();
		vlcu.result();
	}

	private void result() {
		String st = scan.nextLine();
		st = buildTheString(st);
		st = decompress(st);
		System.out.println(st);
	}

	private int find(String st) {
		for (int i = 0; i < stringArray.length; i++) {
			if (st.equals(stringArray[i]))
				return i;
		}
		return -1;
	}

	private String decompress(String st) {

		String forReturn = "";

		while (st.length() != 0) {

			int start = 0;
			boolean b = true;

			for (int i = 0; i <= st.length(); i++) {
				String t = st.substring(start, i);
				int index = find(t);
				if (index != -1) {
					forReturn += charArray[index];
					st = st.substring(i);
					b=false;
					break;
				}
			}
			if(b) break;
		}

		return forReturn;
	}

	private String buildTheString(String st) {

		String forReturn = "";

		for (int i = 0; i < st.length(); i++) {
			int index = base32.indexOf(st.charAt(i));

			String t = Integer.toBinaryString(index);

			if (t.length() < 5) {
				int iter = t.length();
				for (int j = 0; j < (5 - iter); j++)
					t = "0" + t;
			}
			forReturn += t;
		}
		return forReturn;
	}
}
