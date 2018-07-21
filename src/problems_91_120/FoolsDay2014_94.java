package problems_91_120;

import java.util.Scanner;

public class FoolsDay2014_94 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = scan.nextInt();
		scan.nextLine();

		while (iter-- > 0) {
			System.out.print(calculate(scan.nextLine()) + " ");
		}
	}

	private static int calculate(String st) {

		int sum = 0;
		String[] array = st.split(" ");

		for (int i = 0; i < array.length; i++)
			sum += Integer.parseInt(array[i]) * Integer.parseInt(array[i]);
		return sum;
	}
}
