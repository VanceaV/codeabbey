package problems_121_150;

import java.util.Scanner;

public class BilliardBall_133 {

	private static Scanner scan = new Scanner(System.in);
	private final double dt = 0.0001;

	public static void main(String[] args) {
		BilliardBall_133 bb = new BilliardBall_133();
		bb.result();

	}

	private void result() {

		double W = scan.nextDouble();
		double H = scan.nextDouble();
		double X = scan.nextDouble();
		double Y = scan.nextDouble();
		double R = scan.nextDouble();
		double Vx = scan.nextDouble();
		double Vy = scan.nextDouble();
		double A = scan.nextDouble();

		int[] XY = findXY(W, H, X, Y, R, Vx, Vy, A);

		System.out.println(XY[0] + " " + XY[1]);

	}

	private int[] findXY(double W, double H, double X, double Y, double R, double Vx, double Vy, double A) {

		int[] XY = new int[2];

		double V = Math.sqrt(Math.pow(Vx, 2) + Math.pow(Vy, 2));
		double Vprime = V;
		double k;

		while (V > 0.0) {

			X += Vx * dt;
			if (X < R) {
				X += 2 * (R - X);
				Vx *= -1;
			}
			if (X >= W - R) {
				X += 2 * (W - R - X);
				Vx *= -1;
			}

			Y += Vy * dt;
			if (Y < R) {
				Y += 2 * (R - Y);
				Vy *= -1;
			}
			if (Y >= H - R) {
				Y += 2 * (H - R - Y);
				Vy *= -1;
			}

			V -= A * dt;
			k = V / Vprime;
			Vx *= k;
			Vy *= k;
			Vprime = V;
		}

		XY[0] = (int) Math.round(X);
		XY[1] = (int) Math.round(Y);

		return XY;
	}
}
