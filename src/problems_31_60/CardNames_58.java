package problems_31_60;

import java.util.Scanner;

public class CardNames_58 {

	private static Scanner scan = new Scanner(System.in);

	private static String[] suits = { "Clubs", "Spades", "Diamonds", "Hearts" };
	private static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	public static void main(String[] args) {
		int iter = new Integer(scan.next());
		scan.nextLine();

		for (int i = 0; i < iter; i++) {
			int card_value = scan.nextInt();
			int suit_value = card_value / 13;
			int rank_value = card_value % 13;

			System.out.print(ranks[rank_value] + "-of-" + suits[suit_value] + " ");
		}
	}
}
