package problems_1_30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModularCalculator_14 {
	private Scanner scan = new Scanner(System.in);
	private List<String> numbers = new ArrayList<String>();
	private List<String> signs = new ArrayList<String>();
	private int mod;

	public static void main(String[] args) {
		ModularCalculator_14 mc = new ModularCalculator_14();
		mc.result();
	}

	private int result() {

		String read;
		int result = 1;

		while (scan.hasNext()) {

			read = scan.nextLine();

			if (read.charAt(0) == '%') {
				mod = Integer.parseInt(read.substring(2));
				break;
			}

			if (read.charAt(0) == '*') {
				numbers.add(read.substring(2));
				signs.add("*");
			} else if (read.charAt(0) == '+') {
				numbers.add(read.substring(2));
				signs.add("+");
			} else
				numbers.add(read);

		}

		for (int i = 0; i < numbers.size(); i++) {

			if (i == 0)
				result = Integer.parseInt(numbers.get(i));
			else if (signs.get(i - 1).equals("*"))
				result = (result * Integer.parseInt(numbers.get(i))) % mod;
			else if (signs.get(i - 1).equals("+"))
				result = (result + Integer.parseInt(numbers.get(i))) % mod;
		}

		System.out.println(result);

		return result;

	}
}
