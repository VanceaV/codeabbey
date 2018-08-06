package problems_151_170;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch_154 {

	private Queue<Integer> q;
	private Scanner scan = new Scanner(System.in);
	private int[][] graph;
	Map<Integer, Integer> seen;

	private int N, M;

	public BreadthFirstSearch_154() {
		q = new LinkedList<>();
		N = scan.nextInt();
		M = scan.nextInt();
		graph = new int[N][N];
		seen = new HashMap<Integer, Integer>();
		buildGraph();

	}

	private void buildGraph() {

		int n1, n2;
		for (int i = 0; i < M; i++) {
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}
	}

	private void BFS() {

		int current = 0;
		q.add(current);

		while (!q.isEmpty()) {
			current = q.remove();
			for (int i = 0; i < N; i++) {
				if (graph[current][i] == 1 && !isSeen(current, i)) {
					q.add(i);
				}
			}
		}
	}

	private void result() {
		for (int i = 0; i < N; i++) {

			System.out.print(seen.get(i) + " ");
		}

	}

	private boolean isSeen(int current, int node) {
		if (!seen.containsKey(node)) {
			if (node == 0) {
				seen.put(node, -1);
				return false;
			} else {
				seen.put(node, current);
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		BreadthFirstSearch_154 bfs = new BreadthFirstSearch_154();
		bfs.BFS();
		bfs.result();
	}
}
