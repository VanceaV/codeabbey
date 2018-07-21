package problems_91_120;

import java.util.Scanner;

public class UphillShooting_99 {

	private static Scanner scan = new Scanner(System.in);
	private final double gravitation = 9.81;
	private int[] slope;

	public static void main(String[] args) {
		UphillShooting_99 us = new UphillShooting_99();
		us.result(0.001);

	}

	private void result(double dt) {
		for (int i = 0; i < 3; i++) {
			fillSlope();
			for (int j = 0; j < 3; j++) {
				distance(dt);
			}
		}
	}

	private void distance(double dt) {
		double V = scan.nextInt();
		double angle = scan.nextInt();
		double Vy = V * Math.sin(Math.toRadians(angle));
		double Vx = V * Math.cos(Math.toRadians(angle));
		double _Vy = 0, _Vx = 0, _dt = 0;
		while (!checkSloop(_Vy, _Vx)) {
			_dt += dt;
			_Vx = Vx * _dt;
			_Vy = (Vy * _dt) - (gravitation * _dt * _dt) / 2;
		}

		System.out.print((int) Math.floor(_Vx) + " ");
	}

	private boolean checkSloop(double Vy, double Vx) {

		boolean b = false;

		int i = (int) Vx / 4;

		if (slope[i] != 0 && slope[i] * 4 >= Vy)
			b = true;
		return b;

	}

	private void fillSlope() {
		slope = new int[40];
		for (int i = 0; i < 40; i++)
			slope[i] = scan.nextInt();

	}
}
