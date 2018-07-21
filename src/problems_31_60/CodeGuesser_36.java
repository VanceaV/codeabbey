package problems_31_60;

import java.util.Scanner;

public class CodeGuesser_36 {

	private int[][] initialdata;
	private int iter;
	private Scanner sc = new Scanner(System.in);

	CodeGuesser_36() {

		iter = sc.nextInt();
		initialdata = new int[iter][2];
		for (int i = 0; i < iter; i++) {
			for (int j = 0; j < 2; j++)
				initialdata[i][j] = sc.nextInt();
		}
	}

	public static void main(String[] args) {
		CodeGuesser_36 cg = new CodeGuesser_36();
		System.out.println(cg.result());
	}

	private int result() {
		int result = 0;
		for (int i = 0; i < 10000; i++) {
			boolean flag = true;
			for (int j = 0; j < iter; j++) {
				int count = 0;
				if (initialdata[j][0] % 10 == i % 10)
					count++;
				if ((initialdata[j][0] / 10) % 10 == (i / 10) % 10)
					count++;
				if ((initialdata[j][0] / 100) % 10 == (i / 100) % 10)
					count++;
				if (initialdata[j][0] / 1000 == i / 1000)
					count++;
				if (count != initialdata[j][1]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result = i;
				break;
			}
		}
		return result;
	}
}