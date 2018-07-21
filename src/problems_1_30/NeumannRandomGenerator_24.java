package problems_1_30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeumannRandomGenerator_24 {

	private Scanner scan = new Scanner(System.in);
	private int iter;
	private List<Integer> loops;

	public static void main(String[] args) {
		NeumannRandomGenerator_24 ng = new NeumannRandomGenerator_24();
		ng.result();
	}
	private void result() {

		iter = Integer.parseInt(scan.next());
		int loop = 0, startNumber = 0;
		loops = new ArrayList<Integer>();
		while (iter-- > 0) {
			loop = 0;
			startNumber = Integer.parseInt(scan.next());
			loops.clear();
			do {
				loop++;
				startNumber = startNumber * startNumber;
				startNumber = truncate(startNumber);

				if (loops.contains(startNumber))
					break;
				else
					loops.add(startNumber);
			} while (true);

			System.out.print(loop + " ");
		}
	}

	private int truncate(int t) {

		return (t / 100) % 10000;
	}
}
