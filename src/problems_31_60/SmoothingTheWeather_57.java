package problems_31_60;

import java.util.Scanner;

public class SmoothingTheWeather_57 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		SmoothingTheWeather_57 stw = new SmoothingTheWeather_57();
		stw.result();
	}

	private void result() {
		int iter = new Integer(scan.next());
		scan.nextLine();

		double array[] = new double[iter];

		for (int i = 0; i < iter; i++)
			array[i] = scan.nextDouble();

		double temp = array[0];

		for (int i = 1; i < iter - 1; i++) {
			double med = (temp + array[i] + array[i + 1]) / 3;
			temp = array[i];
			array[i] = med;
		}

		for (int i = 0; i < iter; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
