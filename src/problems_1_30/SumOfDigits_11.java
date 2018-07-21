package problems_1_30;

import java.util.Scanner;

public class SumOfDigits_11 {
	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {
		SumOfDigits_11 sd = new SumOfDigits_11();
		sd.result();
	}

	private void result() {
		iter = Integer.parseInt(scan.next());
		int abc, sum;

		while (iter-- > 0) {
			abc = Integer.parseInt(scan.next()) * Integer.parseInt(scan.next()) + Integer.parseInt(scan.next());
			sum = 0;
			while (abc / 10.0 > 0) {
				sum += abc % 10;
				abc /= 10;
				if(abc==10){
					sum++;
					break;
				}
			}

			System.out.print(sum + " ");

		}

	}

}
