package problems_1_30;

import java.util.Scanner;

public class ModuloAndTimeDifference_12 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {
		ModuloAndTimeDifference_12 md = new ModuloAndTimeDifference_12();
		md.result();

	}

	private int seconds(int days, int hours, int minutes, int seconds) {

		return days * 24 * 60 * 60 + hours * 60 * 60 + minutes * 60 + seconds;
	}

	private void result() {
		iter = Integer.parseInt(scan.next());

		while (iter-- > 0) {
			int start = seconds(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()),
					Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
			int finish = seconds(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()),
					Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
			int finish_start = finish - start, days, hours, minutes, seconds;

			days = finish_start / (24 * 60 * 60);

			hours = (finish_start %= (24 * 60 * 60)) / (60 * 60);

			minutes = (finish_start %= (60 * 60)) / 60;

			seconds = finish_start % 60;

			System.out.print("(" + days + " " + hours + " " + minutes + " " + seconds + ") ");

		}

	}

}
