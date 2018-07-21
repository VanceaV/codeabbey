package problems_1_30;

import java.util.Scanner;

public class SortWithIndexes_29 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int iter = new Integer(scan.next());
		MyNumber numbers[] = new MyNumber[iter];

		for (int i = 0; i < iter; i++)
			numbers[i] = new MyNumber(new Integer(scan.next()), i + 1);
		MyNumber.bubbleSort(numbers);

		for (MyNumber n : numbers)
			System.out.print(n + " ");
	}

}

class MyNumber implements Comparable<MyNumber> {

	private int number;
	private int index;

	public MyNumber(int number, int index) {
		this.number = number;
		this.index = index;
	}

	@Override
	public int compareTo(MyNumber o) {

		if (number == o.number)
			return 0;
		else if (number > o.number)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {

		return String.valueOf(index);
	}

	public static MyNumber[] bubbleSort(MyNumber numbers[]) {

		boolean isSwap = true;
		MyNumber temp;

		while (isSwap) {
			isSwap = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i].compareTo(numbers[i + 1]) > 0) {
					isSwap = true;
					temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
				}
			}
		}

		return numbers;
	}
}
