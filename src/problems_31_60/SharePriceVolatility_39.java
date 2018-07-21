package problems_31_60;

import java.util.Scanner;

public class SharePriceVolatility_39 {

	private static Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		SharePriceVolatility_39 spv = new SharePriceVolatility_39();
		spv.result();

	}

	private void result() {

		iter = new Integer(scan.nextLine());
		String temp;
		String[] array;
		double[] getarray;
		double standardDeviation, mean;
		while (iter-- > 0) {
			temp = scan.nextLine();
			array = temp.split(" ");
			temp = array[0];
			getarray = getarray(array);
			standardDeviation = stadradDeviation(getarray);
			mean = mean(getarray);
			mean = mean / 100;
			if (standardDeviation / mean >= 4)
				System.out.print(temp + " ");

		}
	}

	private double[] getarray(String[] array) {
		double[] intArray = new double[array.length - 1];
		for (int i = 0; i < intArray.length; i++)
			intArray[i] = new Integer(array[i + 1]);

		return intArray;
	}

	private double stadradDeviation(double[] data) {

		double M = mean(data), D = 0;

		for (double m : data)
			D += (M - m) * (M - m);
		D = D / data.length;

		return Math.sqrt(D);
	}

	private double mean(double[] data) {
		double M = 0;

		for (double m : data)
			M += m;
		M = M / data.length;

		return M;

	}
}
