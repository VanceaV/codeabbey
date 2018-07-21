package problems_31_60;

import java.util.Scanner;

public class CardsShuffling_45 {

	private static Scanner scan = new Scanner(System.in);
	private String array[];
	private String ranks[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
	private String suits[] = { "C", "D", "H", "S" };

	public CardsShuffling_45() {
		array = new String[52];
		fillTheArray(array, suits, ranks);
	}

	public static void main(String[] args) {

		CardsShuffling_45 cs = new CardsShuffling_45();
		cs.result();

	}

	private void result() {
		int forScan;
		for (int i = 0; i < 52; i++) {
			forScan = scan.nextInt();
			if (forScan > 52)
				forScan = forScan % 52;
			swap(array, i, forScan);
		}
		for (String s : array) {
			System.out.print(s + " ");
		}
	}

	private void fillTheArray(String array[], String suits[], String ranks[]) {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 13; j++)
				array[i * 13 + j] = suits[i] + ranks[j];

	}

	private void swap(String array[], int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
