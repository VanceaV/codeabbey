package problems_91_120;

import java.math.BigDecimal;
import java.util.Scanner;

public class StarvingPriorityQueue_93 {

	private static Scanner scan = new Scanner(System.in);
	private Visitor[] binaryHeap;
	private BigDecimal totalDiscomfort = BigDecimal.valueOf(0);
	private int X0;

	private final int A = 445;
	private final int C = 700001;
	private final int M = 2097152;

	public static void main(String[] args) {
		StarvingPriorityQueue_93 spq = new StarvingPriorityQueue_93();
		spq.result();

	}

	private void result() {
		int iter = scan.nextInt();
		X0 = scan.nextInt();
		int t = 0;

		while (iter-- > 0) {
			if (t == 0 || t % 2 != 0) {
				int starvationDegree = starvationDegree(nextRandom());
				Visitor visitor = new Visitor(starvationDegree, t);
				insertionOfNewElement(visitor);
				t++;
			} else {
				Visitor visitor = deletionOfNewElement();
				totalDiscomfort = totalDiscomfort.add(BigDecimal.valueOf(visitor.personalDiscomfort(t)));
				int starvationDegree = starvationDegree(nextRandom());
				visitor = new Visitor(starvationDegree, t);
				insertionOfNewElement(visitor);
				t++;
			}
		}

		t++;

		while (binaryHeap != null) {

			Visitor visitor = deletionOfNewElement();
			totalDiscomfort = totalDiscomfort.add(BigDecimal.valueOf(visitor.personalDiscomfort(t)));

			t += 2;
		}
		System.out.println(totalDiscomfort);
	}

	private void insertionOfNewElement(Visitor next) {

		if (binaryHeap == null) {
			binaryHeap = new Visitor[1];
			binaryHeap[0] = next;
		} else {
			int currentEnd = binaryHeap.length;
			Visitor[] tempBinaryHeap = new Visitor[currentEnd + 1];
			for (int i = 0; i < binaryHeap.length; i++)
				tempBinaryHeap[i] = binaryHeap[i];
			tempBinaryHeap[currentEnd] = next;
			binaryHeap = tempBinaryHeap;

			int index = currentEnd;
			int parent = 0;

			while (true) {
				parent = (int) Math.floor((index - 1) / 2.0);

				if (binaryHeap[parent].getCounterDegree() > binaryHeap[index].getCounterDegree()) {
					Visitor temp = binaryHeap[parent];
					binaryHeap[parent] = binaryHeap[index];
					binaryHeap[index] = temp;
					index = parent;
				} else
					break;

				if (parent == 0)
					break;

			}
		}
	}

	private Visitor deletionOfNewElement() {

		Visitor visitor = null;

		if (binaryHeap != null && binaryHeap.length != 1) {

			visitor = binaryHeap[0];

			Visitor[] tempBinaryHeap = new Visitor[binaryHeap.length - 1];
			tempBinaryHeap[0] = binaryHeap[binaryHeap.length - 1];

			for (int i = 1; i < binaryHeap.length - 1; i++)
				tempBinaryHeap[i] = binaryHeap[i];
			binaryHeap = tempBinaryHeap;

			int cur = 0, p = cur;

			while (true) {

				if (2 * cur + 1 < binaryHeap.length
						&& binaryHeap[p].getCounterDegree() > binaryHeap[2 * cur + 1].getCounterDegree())
					p = 2 * cur + 1;
				if (cur * 2 + 2 < binaryHeap.length
						&& binaryHeap[p].getCounterDegree() > binaryHeap[2 * cur + 2].getCounterDegree())
					p = 2 * cur + 2;

				if (cur == p)
					break;
				else {
					Visitor temp = binaryHeap[cur];
					binaryHeap[cur] = binaryHeap[p];
					binaryHeap[p] = temp;
					cur = p;
				}
			}
		} else {
			visitor = binaryHeap[0];
			binaryHeap = null;
		}
		return visitor;
	}

	private int starvationDegree(int rnd) {
		return (rnd % 999) + 1;
	}

	private int nextRandom() {
		X0 = (A * X0 + C) % M;
		return X0;
	}
}

class Visitor {

	private int degree;
	private int t;
	private int counterDegree;

	public Visitor(int degree, int t) {
		this.degree = degree;
		this.t = t;
		counterDegree = 2000 - degree;
	}

	public int personalDiscomfort(int feedingTime) {
		return degree * (feedingTime - t);
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getCounterDegree() {
		return counterDegree;
	}

	public void setCounterDegree(int counterDegree) {
		this.counterDegree = counterDegree;
	}
}
