package problems_151_170;

import java.util.*;

public class LuhnAlgorithm_156 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			int arr[] = corrector(sc.nextLine());
			for (int j : arr) {
				System.out.print(j);
			}
			System.out.print(" ");
		}
	}

	static int[] input(String str) {
		int[] result = new int[16];
		for (int i = 0; i < str.length(); i++) {
			result[i] = Character.digit(str.charAt(i), 10);
		}
		return result;
	}

	static boolean check(int[] arr) {
		boolean result = false;
		int summ = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int a = arr[i];
			if (i % 2 == 0) {
				a = a * 2;
				if (a > 9) {
					a = a - 9;
				}
			}
			summ = summ + a;
		}
		if (summ % 10 == 0) {
			result = true;
		}
		return result;
	}

	static int[] corrector(String str) {
		int[] tmp = input(str);
		int index = -1;
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == -1) {
				index = i;
				break;
			}
		}
		if (index == -1) {

			tmp = swop(tmp);
		} else {
			tmp = brut(tmp, index);
		}
		return tmp;
	}

	static int[] brut(int[] arr, int index) {

		for (int i = 0; i < 10; i++) {
			arr[index] = i;
			if (check(arr)) {
				break;
			}

		}
		return arr;
	}

	static int[] swop(int[] arr) {
		if (check(arr)) {
			return arr;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			int[] tmpArr = arr.clone();
			int tmp = tmpArr[i];
			tmpArr[i] = tmpArr[i + 1];
			tmpArr[i + 1] = tmp;
			if (check(tmpArr)) {
				return tmpArr;
			}
		}
		return null;
	}
}