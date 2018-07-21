package problems_201_213;

import java.util.Arrays;
import java.util.Scanner;

public class InformationEntropy_211 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int messagesCount = scanner.nextInt();
			scanner.nextLine();
			String message;
			StringBuilder result = new StringBuilder();
			while (messagesCount-- > 0) {
				message = scanner.nextLine();

				result.append(calcEntropy(message)).append(" ");
			}
			System.out.print(result.toString().trim());
		}
	}

	private static double calcEntropy(String message) {
		double entropy = 0.0;
		char[] symbols = message.toCharArray();
		Arrays.sort(symbols);
		char symbol = symbols[0];
		int count = 1;
		double frequency;
		for (int i = 1; i < symbols.length; i++) {
			if (symbols[i] == symbol) {
				count++;
			} else {
				frequency = (double) count / symbols.length;
				entropy += -frequency * Math.log(frequency) / Math.log(2);
				symbol = symbols[i];
				count = 1;
			}
		}
		frequency = (double) count / symbols.length;
		entropy += -frequency * Math.log(frequency) / Math.log(2);

		return entropy;
	}
}