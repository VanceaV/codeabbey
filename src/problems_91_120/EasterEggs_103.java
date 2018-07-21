package problems_91_120;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasterEggs_103 {

	private static Scanner scan = new Scanner(System.in);

	private int[] initPosition;

	private int data[][];

	private int size;

	public EasterEggs_103(int size) {
		this.size = size;
		initPosition = new int[size];
		data = new int[size][];
		readInit();
		readData();
	}

	public static void main(String[] args) {
		EasterEggs_103 ee = new EasterEggs_103(20);
		ee.checkSubsets();

	}

	private void checkSubsets() {

		for (int i = 0; i < (1 << size); i++) {

			int[] toCheckSubset = toCopyInit(initPosition);
			List<Integer> list = new ArrayList<Integer>();

			for (int j = 0; j < size; j++)
				if ((i & (1 << j)) > 0) {
					toggle(j, toCheckSubset);
					list.add(j);
				}

			if (CheckInitPosition(toCheckSubset)) {
				for (int k : list)
					System.out.print(k + " ");
				break;
			}
		}
	}

	private void toggle(int toVisit, int[] initPosition) {

		for (int i = 0; i < data[toVisit].length; i++) {

			if (initPosition[data[toVisit][i]] == 1) {
				initPosition[data[toVisit][i]] = 0;
			} else {
				initPosition[data[toVisit][i]] = 1;
			}

		}
	}

	private int[] toCopyInit(int[] initPosition) {
		int copyInit[] = new int[initPosition.length];
		for (int i = 0; i < copyInit.length; i++)
			copyInit[i] = initPosition[i];

		return copyInit;

	}

	private boolean CheckInitPosition(int[] initPosition) {
		int sum = 0;

		for (int i = 0; i < initPosition.length; i++)
			sum += initPosition[i];

		if (sum == 0)
			return true;
		else
			return false;

	}

	private void readInit() {

		for (int i = 0; i < initPosition.length; i++) {
			initPosition[i] = scan.nextInt();
		}
		scan.nextLine();
	}

	private void readData() {
		for (int i = 0; i < data.length; i++) {

			String array[] = scan.nextLine().split(" ");
			int[] line = new int[array.length - 1];
			for (int j = 1; j < array.length; j++)
				line[j - 1] = Integer.parseInt(array[j]);
			data[i] = line;
		}
	}
}
