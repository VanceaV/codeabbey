package problems_91_120;

import java.util.Scanner;

public class BinaryHeap_92 {

	private static Scanner scan = new Scanner(System.in);
	private int[] binaryHeap;

	public static void main(String[] args) {
		BinaryHeap_92 bh = new BinaryHeap_92();
		bh.result();

	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			int next = scan.nextInt();
			if (next > 0) {
				binaryHeap = insertionOfNewElement(next, binaryHeap);
			}

			else {
				binaryHeap = delitionOfNewElement(binaryHeap);
			}
		}
		System.out.println();
		print(binaryHeap);
	}

	private void print(int[] binaryHeap) {

		for (int i = 0; i < binaryHeap.length; i++)
			System.out.print(binaryHeap[i] + " ");

	}

	private int[] insertionOfNewElement(int next, int[] binaryHeap) {

		if (binaryHeap == null) {
			binaryHeap = new int[1];
			binaryHeap[0] = next;
		} else {
			int currentEnd = binaryHeap.length;
			int[] tempBinaryHeap = new int[currentEnd + 1];
			for (int i = 0; i < binaryHeap.length; i++)
				tempBinaryHeap[i] = binaryHeap[i];
			tempBinaryHeap[currentEnd] = next;
			binaryHeap = tempBinaryHeap;

			int index = currentEnd;
			int parent = 0;

			while (true) {
				parent = (int) Math.floor((index - 1) / 2.0);

				if (binaryHeap[parent] > binaryHeap[index]) {
					int temp = binaryHeap[parent];
					binaryHeap[parent] = binaryHeap[index];
					binaryHeap[index] = temp;
					index = parent;
				} else
					break;

				if (parent == 0)
					break;

			}
		}
		return binaryHeap;
	}

	private int[] delitionOfNewElement(int[] binaryHeap) {

		if (binaryHeap.length != 0) {

			int[] tempBinaryHeap = new int[binaryHeap.length - 1];
			tempBinaryHeap[0] = binaryHeap[binaryHeap.length - 1];

			for (int i = 1; i < binaryHeap.length - 1; i++)
				tempBinaryHeap[i] = binaryHeap[i];
			binaryHeap = tempBinaryHeap;

			int cur = 0, p = cur;

			while (true) {

				if (2 * cur + 1 < binaryHeap.length && binaryHeap[p] > binaryHeap[2 * cur + 1])
					p = 2 * cur + 1;
				if (cur * 2 + 2 < binaryHeap.length && binaryHeap[p] > binaryHeap[2 * cur + 2])
					p = 2 * cur + 2;

				if (cur == p)
					break;
				else {
					int temp = binaryHeap[cur];
					binaryHeap[cur] = binaryHeap[p];
					binaryHeap[p] = temp;
					cur = p;
				}
			}
		}
		return binaryHeap;
	}
}
