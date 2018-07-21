package problems_61_90;

import java.util.Scanner;

public class GraphGenerator_83 {

	private static Scanner scan = new Scanner(System.in);

	private int[][] graph;
	private int X0;
	private int N;

	private final int A = 445;
	private final int C = 700001;
	private final int M = 2097152;

	public GraphGenerator_83() {
		N = scan.nextInt();
		graph = new int[N + 1][N + 1];
		X0 = scan.nextInt();
	}

	public static void main(String[] args) {
		GraphGenerator_83 gg = new GraphGenerator_83();
		gg.result();
	}

	private void result() {
		fillGraph();

		for (int i = 1; i < N + 1; i++) {
			int count = 0;
			for (int j = 1; j < N + 1; j++) {
				count += graph[i][j];
			}
			System.out.print(count + " ");
		}
	}

	private void fillGraph() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 2; j++) {

				int V = nextRandom(nextRandom());
				int D = nextRandom(nextRandom());
				if (i == V || graph[i][V] != 0)
					continue;
				graph[i][V] = D;
				graph[V][i] = D;

			}
		}
	}

	private int nextRandom() {
		X0 = (A * X0 + C) % M;
		return X0;
	}

	private int nextRandom(int X) {
		return X % N + 1;
	}
}
