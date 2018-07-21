package problems_151_170;

import java.util.*;

public class DepthFirstSearch_155 {

	private Scanner scan = new Scanner(System.in);
	private Stack<Integer> Stack;
	private Stack<Integer> Track;
	private int vert, edge;
	private int[][] graf;
	private ArrayList<Integer> seen;
	private ArrayList<Integer> IdF_seen;

	DepthFirstSearch_155() {

		Stack = new Stack<Integer>();
		Track = new Stack<Integer>();

		vert = scan.nextInt();
		edge = scan.nextInt();
		graf = new int[vert][vert];
		seen = new ArrayList<Integer>();
		IdF_seen = new ArrayList<Integer>();
	}

	private void get_data() {
		int f, s;
		for (int i = 0; i < edge; i++) {
			f = scan.nextInt();
			s = scan.nextInt();
			graf[f][s] = 1;
			graf[s][f] = 1;
		}
	}

	private void De_Fi_Se() {
		Stack.push(0);
		Track.push(-1);
		int current;
		while (!Stack.isEmpty()) {
			current = Stack.pop();
			if (seen.contains(current)) {
				Track.pop();
				continue;
			} else {
				seen.add(current);
				IdF_seen.add(Track.pop());

				for (int i = vert - 1; i >= 0; i--)
					if (graf[current][i] == 1) {
						Stack.push(i);
						Track.push(current);
					}
			}
		}

		int[] index = new int[seen.size()];
		int[] value = new int[seen.size()];

		for (int i = 0; i < seen.size(); i++) {
			index[i] = IdF_seen.get(i);
			value[i] = seen.get(i);
		}
		int t = 0;
		int t1 = 0;

		for (int i = seen.size() - 1; i > 0; i--) {
			for (int j = 0; j < seen.size() - 1; j++) {

				if (value[j] > value[j + 1]) {
					t = index[j];
					index[j] = index[j + 1];
					index[j + 1] = t;
					t1 = value[j];
					value[j] = value[j + 1];
					value[j + 1] = t1;
				}
			}
		}
		for (int i = 0; i < IdF_seen.size(); i++)
			System.out.print(index[i] + " ");
	}

	public static void main(String[] args) {
		DepthFirstSearch_155 DFS = new DepthFirstSearch_155();
		DFS.get_data();
		DFS.De_Fi_Se();
	}
}