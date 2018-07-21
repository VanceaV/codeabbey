package problems_1_30;

import java.util.Scanner;

public class ArrayCounters_21 {
	private Scanner scan = new Scanner(System.in);
	private int iter;
	private int[] arrayCounters;

	public static void main(String[] args) {
		ArrayCounters_21 ac = new ArrayCounters_21();
		ac.result();
	}

	private void result() {
		iter = Integer.parseInt(scan.next());
		arrayCounters = new int[Integer.parseInt(scan.next())];
		while (iter-- > 0)
			arrayCounters[Integer.parseInt(scan.next()) - 1]++;
		for (int i = 0; i < arrayCounters.length; i++)
			System.out.print(arrayCounters[i] + " ");
	}
}
