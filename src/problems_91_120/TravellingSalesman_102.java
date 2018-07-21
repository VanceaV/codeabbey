package problems_91_120;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravellingSalesman_102 {

	private static Scanner scan = new Scanner(System.in);

	private int[][] graph;
	private int N;
	private int min;
	List<Integer> bestRoot;

	public TravellingSalesman_102(int size) {
		N = size;
		min = Integer.MAX_VALUE;
		graph = new int[N][N];
		fillGraph();
	}

	public static void main(String[] args) {
		TravellingSalesman_102 ts = new TravellingSalesman_102(20);
		ts.result();
	}

	private void result() {
		List<Integer> visited = new ArrayList<>();
		visited.add(0);
		recursion(visited, 0, 0);

		for (int i : bestRoot)
			System.out.print(i + " ");
	}

	private void recursion(List<Integer> visited, int distance, int curretNode) {

		if (visited.size() == N && distance < min) {
			min = distance;
			bestRoot = visited;
		}

		for (int i = 0; i < N; i++) {
			if (graph[curretNode][i] != 0 && !visited.contains(i) && distance + graph[curretNode][i] < min) {
				List<Integer> copyList = copyVisited(visited);
				copyList.add(i);
				recursion(copyList, distance + graph[curretNode][i], i);
			}
		}
	}

	private List<Integer> copyVisited(List<Integer> visited) {
		return new ArrayList<Integer>(visited);
	}

	private void fillGraph() {
		for (int i = 0; i < N; i++) {
			String[] array = scan.nextLine().split(" ");
			int indexI = Integer.parseInt(array[0]);
			for (int j = 1; j < array.length; j++) {
				String[] secondArray = array[j].split(":");
				int indexJ = Integer.parseInt(secondArray[0]);
				int distance = Integer.parseInt(secondArray[1]);
				graph[indexI][indexJ] = distance;
				graph[indexJ][indexI] = distance;
			}

		}
	}
}
