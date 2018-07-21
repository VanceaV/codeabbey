package problems_91_120;

import java.util.Scanner;

public class SimpleLinearRegression_95 {

	private int[] x, y;
	private double xM, yM, alpha, betta;

	private static Scanner scan = new Scanner(System.in);

	public SimpleLinearRegression_95() {
		readData();
		xM = xMed();
		yM = yMed();
		betta = findBetta();
		alpha = findAlpha();
	}

	public static void main(String[] args) {
		SimpleLinearRegression_95 slr = new SimpleLinearRegression_95();
		slr.result();

	}

	private void result() {
		System.out.println(betta + " " + alpha);
	}

	private double findAlpha() {
		return yM - betta * xM;
	}

	private double findBetta() {

		double first = 0, second = 0;
		for (int i = 0; i < x.length; i++) {
			first += (x[i] - xM) * (y[i] - yM);
			second += (x[i] - xM) * (x[i] - xM);
		}

		betta = first / second;
		return betta;

	}

	private void readData() {

		int startYear = scan.nextInt();
		int finishYear = scan.nextInt();
		scan.nextLine();

		int iter = finishYear - startYear + 1;
		x = new int[iter];
		y = new int[iter];

		int i = 0;

		while (iter-- > 0) {
			String st[] = scan.nextLine().split(" ");

			x[i] = Integer.parseInt(st[1]);
			y[i] = Integer.parseInt(st[2]);
			i++;

		}
	}

	double xMed() {
		int sum = 0;
		for (int i = 0; i < x.length; i++)
			sum += x[i];
		return sum / (double) x.length;
	}

	double yMed() {
		int sum = 0;
		for (int i = 0; i < y.length; i++)
			sum += y[i];
		return sum / (double) y.length;
	}

}
