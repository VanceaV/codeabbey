package problems_61_90;

import java.util.Scanner;

public class FunnyWordsGenerator_72 {
	private static Scanner scan = new Scanner(System.in);
	private final int A = 445;
	private final int C = 700001;
	private final int M = 2097152;
	private final String consonants = "bcdfghjklmnprstvwxz";
	private final String vowels = "aeiou";
	private final int[] randomNumbers;

	private int numberOfWords;
	private int seed;

	public FunnyWordsGenerator_72() {
		numberOfWords = scan.nextInt();
		seed = scan.nextInt();
		randomNumbers = LinearCongruentialGenerator(seed, 1000);
	}

	public static void main(String[] args) {
		FunnyWordsGenerator_72 fwg = new FunnyWordsGenerator_72();
		fwg.result();
	}

	private void result() {
		int counter = 0;
		while (numberOfWords-- > 0) {
			int letters = scan.nextInt();
			for (int i = 1; i <= letters; i++) {
				if (i % 2 == 0) {
					int rand = randomNumbers[counter++];
					int mod = rand % 5;
					System.out.print(vowels.charAt(mod));

				} else {
					int rand = randomNumbers[counter++];
					int mod = rand % 19;
					System.out.print(consonants.charAt(mod));
				}
			}
			System.out.print(" ");
		}
	}

	private int[] LinearCongruentialGenerator(int seed, int numberOF) {
		int[] randomGenerated = new int[numberOF];

		for (int i = 0; i < numberOF; i++) {
			seed = (A * seed + C) % M;
			randomGenerated[i] = seed;
		}
		return randomGenerated;
	}
}
