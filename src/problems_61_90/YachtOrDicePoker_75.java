package problems_61_90;

import java.util.Scanner;

public class YachtOrDicePoker_75 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		YachtOrDicePoker_75 yod = new YachtOrDicePoker_75();
		yod.result();

	}

	private void result() {
		int iter = scan.nextInt();

		while (iter-- > 0) {
			int[] faces = new int[6];
			int[] dices = new int[5];
			int nextDice;
			int first = 0;
			for (int i = 0; i < 5; i++) {
				nextDice = scan.nextInt();
				dices[i] = nextDice;
				if (i == 0)
					first = nextDice;
				faces[nextDice - 1]++;
			}
			System.out.print(cobinationType(faces, dices, first) + " ");
		}
	}

	private String cobinationType(int[] faces, int[] dices, int first) {

		int type = max(faces, dices, first);
		if (type == 2)
			return "pair";
		else if (type == 3)
			return "three";
		else if (type == 4)
			return "four";
		else if (type == 5)
			return "yacht";
		else if (type == 6)
			return "two-pairs";
		else if (type == 7)
			return "full-house";
		else if (type == 8)
			return "small-straight";
		else if (type == 9)
			return "big-straight";
		else
			return "none";

	}

	private int sum(int[] dices) {
		int sum = 0;
		for (int i = 0; i < dices.length; i++) {
			sum += dices[i];
		}
		return sum;
	}

	private int max(int[] faces, int[] dices, int first) {

		int max = -1;
		int sum = sum(dices);

		boolean yacht = true;

		int two = 0, secondtwo = 0, three = 0;

		for (int i = 0; i < faces.length; i++) {
			if (faces[i] > max)
				max = faces[i];

			if (two == 2 && faces[i] == 2)
				secondtwo = 2;

			if (two != 2 && faces[i] == 2)
				two = 2;

			if (faces[i] == 3)
				three = 3;
			if (faces[i] != first)
				yacht = false;
		}

		if (two == 2 && secondtwo != 2 && three != 3)
			return 2; // pair
		if (three == 3 && two != 2)
			return 3; // three
		if (max == 4)
			return 4; // four;
		if (yacht)
			return 5; // yacht
		if (two == 2 && secondtwo == 2)
			return 6; // two-pairs
		if (two == 2 && three == 3)
			return 7; // full-house
		if (max == 1 && sum == 15)
			return 8; // small-straight
		if (max == 1 && sum == 20)
			return 9; // big-straight
		else
			return max;
	}
}
