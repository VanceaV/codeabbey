package problems_61_90;

import java.util.Scanner;

public class RotationIn2DSpace_85 {

	private static Scanner scan = new Scanner(System.in);

	private String[] stars;
	private int[] x, xNew;
	private int[] y, yNew;
	private int angle;
	private int iter;

	public RotationIn2DSpace_85() {
		iter = scan.nextInt();
		angle = scan.nextInt();
		scan.nextLine();
		stars = new String[iter];

		x = new int[iter];
		y = new int[iter];

		xNew = new int[iter];
		yNew = new int[iter];

		for (int i = 0; i < iter; i++) {
			String[] st = scan.nextLine().split(" ");
			stars[i] = st[0];
			x[i] = Integer.parseInt(st[1]);
			y[i] = Integer.parseInt(st[2]);
		}
	}

	public static void main(String[] args) {
		RotationIn2DSpace_85 ri2ds = new RotationIn2DSpace_85();
		ri2ds.findXnewAndYnew();
		ri2ds.sortByYandX();
		ri2ds.result();

	}

	private void result() {
		for (int i = 0; i < stars.length; i++) {
			System.out.print(stars[i] + " ");
		}
	}

	private void sortByYandX() {
		for (int i = 0; i < iter - 1; i++)
			for (int j = 0; j < iter - i - 1; j++) {
				if (yNew[j] > yNew[j + 1]) {

					int tempY = yNew[j];
					int tempX = xNew[j];

					yNew[j] = yNew[j + 1];
					yNew[j + 1] = tempY;

					xNew[j] = xNew[j + 1];
					xNew[j + 1] = tempX;

					String st = stars[j];
					stars[j] = stars[j + 1];
					stars[j + 1] = st;
				}
			}

	}

	private void findXnewAndYnew() {
		for (int i = 0; i < iter; i++) {
			xNew[i] = xNew(x[i], y[i], angle);
			yNew[i] = yNew(x[i], y[i], angle);
		}
	}

	private int xNew(int x, int y, double angle) {
		return (int) Math.round(x * Math.cos(Math.toRadians(angle)) - y * Math.sin(Math.toRadians(angle)));
	}

	private int yNew(int x, int y, double angle) {
		return (int) Math.round(x * Math.sin(Math.toRadians(angle)) + y * Math.cos(Math.toRadians(angle)));
	}
}
