package problems_61_90;

import java.util.Scanner;

public class ClockHands_74 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ClockHands_74 ch = new ClockHands_74();
		ch.result();

	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();
		while (iter-- > 0) {
			String[] st = scan.next().split(":");
			double[] xy = hourCoordinates(Double.parseDouble(st[0]), Double.parseDouble(st[1]));
			System.out.print(xy[0] + " " + xy[1] + " ");
			xy = minuteCoordinates(Double.parseDouble(st[1]));
			System.out.print(xy[0] + " " + xy[1] + " ");
		}
	}

	private double[] hourCoordinates(double hours, double minutes) {
		double hoursToRadian = (hours % 12 + minutes / 60.0) / 12.0 * 2 * Math.PI;
		hoursToRadian = -hoursToRadian + Math.PI / 2;
		double x = Math.cos(hoursToRadian) * 6 + 10;
		double y = Math.sin(hoursToRadian) * 6 + 10;
		double xy[] = new double[2];
		xy[0] = x;
		xy[1] = y;
		return xy;
	}

	private double[] minuteCoordinates(double minutes) {
		double minutesToRadian = (minutes / 60.0) * 2 * Math.PI;
		minutesToRadian = -minutesToRadian + Math.PI / 2;
		double x = Math.cos(minutesToRadian) * 9 + 10;
		double y = Math.sin(minutesToRadian) * 9 + 10;
		double xy[] = new double[2];
		xy[0] = x;
		xy[1] = y;
		return xy;
	}
}
