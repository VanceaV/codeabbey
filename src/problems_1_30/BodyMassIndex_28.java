package problems_1_30;

import java.util.Scanner;

public class BodyMassIndex_28 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		BodyMassIndex_28 bi = new BodyMassIndex_28();
		bi.result();
	}

	private void result() {
		iter = new Integer(scan.nextLine());
		int weight;
		double height;
		while (iter-- > 0) {

			weight = new Integer(scan.next());
			height = new Double(scan.nextDouble());

			System.out.print(grade(bmi(weight, height)) + " ");
		}
	}

	private String grade(double bmi) {

		if (bmi < 18.5)
			return "under";
		else if (18.5 <= bmi && bmi < 25.0)
			return "normal";
		else if (25.0 <= bmi && bmi < 30.0)
			return "over";
		else
			return "obese";
	}

	private double bmi(double weight, double height) {
		return weight / (height * height);
	}
}
