package problems_61_90;

import java.util.Scanner;

public class DijkstraInTheNetwork_84 {

	private static Scanner scan = new Scanner(System.in);

	private int[][] graph;
	private int X0;
	private int N;
	private int sourse;

	private final int A = 445;
	private final int C = 700001;
	private final int M = 2097152;

	public DijkstraInTheNetwork_84() {
		N = scan.nextInt();
		graph = new int[N + 1][N + 1];
		X0 = scan.nextInt();
		sourse = scan.nextInt();
		fillGraph();
	}

	public static void main(String[] args) {
		DijkstraInTheNetwork_84 dit = new DijkstraInTheNetwork_84();
		int[] distances = dit.Dijkstra();
		for (int i = 1; i < distances.length; i++) {
			System.out.print(distances[i] + " ");
		}
	}

	private int[] Dijkstra() {

		int[] distance = new int[N + 1];
		int[] visited = new int[N + 1];
		int[] undefined = new int[N + 1];

		for (int i = 1; i < N + 1; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[sourse] = 0;
		undefined[sourse] = 1;

		while (existsUndefined(undefined)) {

			for (int i = 1; i < N + 1; i++) {
				if (visited[i] == 0 && graph[sourse][i] != 0) {
					int temp = distance[sourse] + graph[sourse][i];
					if (temp < distance[i])
						distance[i] = temp;
					undefined[i] = 1;
				}
			}

			visited[sourse] = 1;
			undefined[sourse] = 0;

			if (existsUndefined(undefined)) {
				sourse = minDistance(distance, undefined);
			}

		}

		return distance;
	}

	private boolean existsUndefined(int[] undefined) {

		int sum = 0;
		for (int i = 1; i < N + 1; i++)
			sum += undefined[i];
		if (sum == 0)
			return false;
		else
			return true;
	}

	private int minDistance(int[] distance, int[] undefined) {
		int minvertex = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i < N + 1; i++) {
			if (undefined[i] == 1) {
				if (minvertex > distance[i]) {
					minvertex = distance[i];
					index = i;
				}
			}
		}
		return index;
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
