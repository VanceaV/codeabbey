package problems_91_120;

import java.util.Scanner;

public class GroundZero_113 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GroundZero_113 gz = new GroundZero_113();
		gz.result();

	}

	public void result() {
		int iter = scan.nextInt();
		scan.nextLine();

		while (iter-- > 0) {

			double data[][] = oneCase(scan.nextLine());
			sort(data);
			find_X0_Y0_T0(data);
		}
	}

	private void sort(double data[][]) {
		double temp[];

		boolean isSwap = true;

		while (isSwap) {
			isSwap = false;

			for (int i = 0; i < data.length - 1; i++) {
				if (data[i][2] > data[i + 1][2]) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					isSwap = true;

				}
			}
		}
	}

	private void find_X0_Y0_T0(double data[][]) {

		double Tda = data[1][2] - data[0][2];
		double Tdb = data[2][2] - data[0][2];

		int x = 0, y = 0;
		double min = 1;

		for (int i = 1; i < 10000; i++) {
			for (int j = 1; j < 10000; j++) {

				double distance0 = distance(i, j, data[0][0], data[0][1]);

				double k1 = (distance(i, j, data[1][0], data[1][1]) - distance0) / Tda;
				double k2 = (distance(i, j, data[2][0], data[2][1]) - distance0) / Tdb;

				double k3 = Math.abs(k2 - k1);

				if (k3 < min) {
					min = k3;
					x = i;
					y = j;
				}
			}
		}

		String time = Findtime(data, x, y);

		System.out.print(x + " " + y + " " + time + " ");
	}

	private String Findtime(double[][] data, int x, int y) {
		double t = data[0][2];
		double time;
		double Tda = data[1][2] - data[0][2];
		double k1 = Math.sqrt(Math.pow((data[0][0] - x), 2) + Math.pow((data[0][1] - y), 2));
		double k2 = Math.sqrt(Math.pow((data[1][0] - x), 2) + Math.pow((data[1][1] - y), 2));
		time = t - (k1 * Tda / (k2 - k1));
		String st = String.format("%.1f", time);
		return st;

	}

	private double distance(double X0, double Y0, double Xp, double Yp) {

		double Xa = (X0 - Xp) * (X0 - Xp);
		double Ya = (Y0 - Yp) * (Y0 - Yp);
		double XYd = (double) Math.sqrt(Xa + Ya);

		return XYd;
	}

	private double[][] oneCase(String st) {

		String[] array = st.split(";");
		int dimension = Integer.parseInt(array[0]);

		for (int i = 1; i < array.length; i++)
			array[i] = array[i].trim();

		double[][] data = new double[dimension][3];

		for (int i = 1; i < array.length; i++) {
			String _array[] = array[i].split(" ");
			for (int j = 0; j < 3; j++) {
				data[i - 1][j] = Double.parseDouble(_array[j]);
			}
		}
		return data;
	}
}
