package problems_31_60;

import java.util.Scanner;

public class BlackjackCounting_42 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		BlackjackCounting_42 bc = new BlackjackCounting_42();
		bc.result();

	}

	private void result() {

		int iter = new Integer(scan.nextLine());

		TypeX tx;
		while (iter-- > 0) {
			tx = scoring(scan.nextLine());
			System.out.print(tx + " ");
		}

	}

	private TypeX scoring(String st) {
		TypeX tx = new TypeX();

		String[] array = st.split(" ");
		int scoring = 0;
		boolean existAce = false;

		for (String t : array) {
			try {
				scoring += Integer.parseInt(t);
			} catch (NumberFormatException e) {
				if (t.equals("T") || t.equals("J") || t.equals("Q") || t.equals("K"))
					scoring += 10;
				else {
					scoring += 1;
					existAce = true;
				}

				continue;
			}
		}

		if (!existAce && scoring <= 21) {
			tx.setType(true);
			tx.setScoring(scoring);
		}

		if (!existAce && scoring > 21) {
			tx.setType(false);
		}

		if (existAce && scoring == 21) {
			tx.setType(true);
			tx.setScoring(scoring);
		}

		if (existAce && 21 - scoring >= 10) {
			tx.setType(true);
			tx.setScoring(scoring + 10);
		}

		if (existAce && 21 - scoring < 10) {
			tx.setType(true);
			tx.setScoring(scoring);
		}

		if (existAce && scoring > 21) {
			tx.setType(false);
		}

		return tx;
	}

	class TypeX {

		private String result = "Bust";
		private int scoring;
		private boolean type;

		public void setScoring(int scoring) {
			this.scoring = scoring;
		}

		public void setType(boolean type) {
			this.type = type;
		}

		@Override
		public String toString() {

			if (type)
				return String.valueOf(scoring);
			else
				return result;
		}
	}
}
