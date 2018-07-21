package problems_91_120;

import java.util.Scanner;

public class RandomSearchOptimization_106 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		result();
	}

	private static void result() {

		int iter = scan.nextInt();

		double speed[] = new double[5];

		for (int i = 0; i < speed.length; i++) {
			speed[i] = scan.nextInt();
		}

		double min = time(speed);

		scan.nextLine();

		while (iter-- > 0) {
			String[] array = scan.nextLine().split(" ");
			int index = Integer.parseInt(array[0]);
			double value = Double.parseDouble(array[1]);
			double previousValue = speed[index];
			speed[index] += value;
			if (check(speed)) {
				double temp = time(speed);

				if (temp < min)
					min = temp;
				else {
					speed[index] = previousValue;
				}
			} else {
				speed[index] = previousValue;
			}
		}

		System.out.println();

		for (double d : speed) {
			System.out.print(d + " ");
		}
		System.out.print(min);
	}

	private static double time(double speed[]) {

		double x = 0;
		double v = 0;
		double xd = 0;
		double t = 0;
		double dt = 0.2;
		double m = 5;
		double k = 0.5;
		double b = -0.5;

		double force_spring, force_friction, force_total, acceleration, speed_of_prime_mover = speed[0];

		int index;

		while (check(xd, x, v)) {
			force_spring = k * (xd - x);
			force_friction = b * v;
			force_total = force_spring + force_friction;
			acceleration = force_total / m;
			x = x + v * dt;
			v = v + acceleration * dt;
			t = t + dt;
			if (xd < 100) {
				index = (int) xd / 20;

				speed_of_prime_mover = speed[index];
				xd = xd + speed_of_prime_mover * dt;
			}
		}
		return t;
	}

	private static boolean check(double speed[]) {

		if (speed[0] > 3)
			return false;

		for (int i = 0; i < speed.length; i++) {
			if (speed[i] <= 0)
				return false;

			if (i <= speed.length - 2 && Math.abs(speed[i] - speed[i + 1]) > 3)
				return false;
		}
		return true;
	}

	private static boolean check(double xd, double x, double v) {
		if (xd >= 100 && Math.abs(xd - x) <= 0.1 && Math.abs(v) <= 0.1)
			return false;
		else
			return true;
	}
}
