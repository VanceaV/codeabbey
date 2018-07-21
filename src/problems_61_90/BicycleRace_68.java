package problems_61_90;

import java.util.Scanner;

public class BicycleRace_68 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		BicycleRace_68 bc = new BicycleRace_68();
		bc.result();
	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			System.out.print(distanceAndPoint(scan.nextInt(), scan.nextInt(), scan.nextInt()) + " ");
		}
	}

	private double distanceAndPoint(double s, double a, double b) {
		return a * (s / (a + b));
	}
}
