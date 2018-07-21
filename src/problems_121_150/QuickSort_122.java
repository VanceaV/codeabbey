package problems_121_150;

import java.util.Scanner;

public class QuickSort_122 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int array[] = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		quiksort(array, 0, size - 1);
		sc.close();
	}

	static void quiksort(int array[], int left, int right) {
		System.out.print(left + "-" + right + " ");
		int pivot = partition(array, left, right);
		if ((pivot - left) > 1)
			quiksort(array, left, pivot - 1);
		if ((right - pivot) > 1)
			quiksort(array, pivot + 1, right);

	}

	static int partition(int array[], int left, int right) {
		int lt = left;
		int rt = right;
		boolean dir = false;
		int pivot = array[left];
		while (lt < rt) {
			if (dir == false) {
				if (array[rt] > pivot)
					rt = rt - 1;
				else {
					array[lt] = array[rt];
					lt = lt + 1;
					dir = true;
				}
			} else {
				if (array[lt] < pivot)
					lt = lt + 1;
				else {
					array[rt] = array[lt];
					rt = rt - 1;
					dir = false;
				}
			}
		}
		array[lt] = pivot;
		return lt;
	}
}