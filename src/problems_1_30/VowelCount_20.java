package problems_1_30;

import java.util.Scanner;

public class VowelCount_20 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {
		VowelCount_20 vc = new VowelCount_20();
		vc.result();
	}

	private void result() {
		iter = Integer.parseInt(scan.nextLine());
		while (iter-- > 0)
			System.out.print(numbersOfVowels(scan.nextLine()) + " ");
	}

	private int numbersOfVowels(String st) {
		int result = 0;
		char temp;

		for (int i = 0; i < st.length(); i++) {
			temp = st.charAt(i);
			if (temp == 'a' || temp == 'o' || temp == 'u' || temp == 'i' || temp == 'e' || temp == 'y')
				result++;
		}
		return result;
	}
}
