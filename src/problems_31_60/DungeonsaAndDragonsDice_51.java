package problems_31_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DungeonsaAndDragonsDice_51 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		DungeonsaAndDragonsDice_51 dadd = new DungeonsaAndDragonsDice_51();
		dadd.result();

	}

	private void result() {

		int lines = 3;

		String st;
		String[] array;
		List<Dice> dices;

		while (lines-- > 0) {
			st = scan.nextLine();
			array = st.split(" ");
			dices = new ArrayList<Dice>();
			for (int i = 1; i <= 5; i++)
				for (int j = 2; j <= 12; j += 2) {
					dices.add(new Dice(i, j));
				}
			int temp;
			for (int i = 0; i < 100; i++) {
				temp = new Integer(array[i]);
				for (Dice d : dices) {
					if (d.isFlag())
						d.toheck(temp);
				}
			}

			Collections.sort(dices);

			double min = Integer.MAX_VALUE;
			Dice bestDice = null;
			int score = dices.get(0).getScore();

			for (Dice d : dices) {

				if (d.getScore() == score) {
					if (min > d.getDif()) {
						min = d.getDif();
						bestDice = d;
					}

				}

			}
			System.out.print(bestDice + " ");
		}

	}

}

class Dice implements Comparable<Dice> {

	private int x;
	private int y;

	private int min;
	private int max;

	private boolean flag;

	private int score;

	private double dif;

	private double value;

	public Dice(int x, int y) {
		this.x = x;
		this.y = y;
		flag = true;
		setMin();
		setMax();

		value = (min + max) / 2.0;
		
	}

	public void toheck(int check) {
		if (check >= min && check <= max) {
			increaseScore();
			dif+=Math.abs(check-value);
		}

		else
			flag = false;
	}

	public int getMin() {
		return min;
	}

	public void setMin() {
		min = x;
	}

	public int getMax() {
		return max;
	}

	public void setMax() {
		max = x * y;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore() {
		score++;
	}

	@Override
	public String toString() {
		return String.valueOf(x) + "d" + String.valueOf(y);
	}

	@Override
	public int compareTo(Dice arg0) {
		if (score < arg0.score) {

			if (dif < arg0.dif)
				return 1;
			else
				return -1;
		} else
			return -1;
	}

	public double getDif() {
		return dif;
	}

}
