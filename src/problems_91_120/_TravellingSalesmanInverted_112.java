package problems_91_120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class _TravellingSalesmanInverted_112 {

	private static Scanner scan = new Scanner(System.in);
	private int[][] graph;
	private int distance;
	private int cities;
	private int roads;
	private List<String> nameOfCities;

	public _TravellingSalesmanInverted_112() {
		cities = scan.nextInt();
		roads = scan.nextInt();
		graph = new int[cities][cities];
		nameOfCities = new ArrayList<String>();
		distance = Integer.MAX_VALUE;
		fillGraph();
	}

	public static void main(String[] args) {
		_TravellingSalesmanInverted_112 tsi = new _TravellingSalesmanInverted_112();
		// tsi.print();
		tsi.result();
	}

	private void result() {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < cities; i++) {

			distance = Integer.MIN_VALUE;
			List<Integer> visited = new ArrayList<>();
			visited.add(i);
			HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
			recursion(visited, 0, i, 0, i, hm);

			if (distance > max) {
				max = distance;
			}

		}

		System.out.println(max);
	}

	private void recursion(List<Integer> visited, int _distance, int curretNode, int level, int index,
			HashMap<Integer, List<Integer>> hm) {

		if (!checkIfVisited(curretNode, visited)) {
			if (_distance > distance) {
				distance = _distance;
				System.out.println("[index]=" + index + "---" + distance + "Level=" + level);
			}
		}

		for (int i = 0; i < cities; i++) {
			if (graph[curretNode][i] == 6 && !visited.contains(i) && checkLevelVisiting(hm, i, level+1)) {
				List<Integer> copyList = copyVisited(visited);
				copyList.add(i);
				recursion(copyList, _distance + 6, i, level + 1, index, hm);
			}
		}

	}

	private boolean checkLevelVisiting(HashMap<Integer, List<Integer>> hm, int searchNode, int level) {

		if (hm.containsKey(level)) {

			if (hm.get(level).contains(searchNode))
				return false;
			else {
				hm.get(level).add(searchNode);
				return true;
			}

		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(searchNode);
			hm.put(level, list);
			return true;
		}

	}

	private boolean checkIfVisited(int index, List<Integer> visited) {

		boolean b = false;

		for (int i = 0; i < graph.length; i++) {
			if (graph[index][i] != 0 && !visited.contains(i)) {
				b = true;
				break;
			}
		}

		return b;
	}

	private List<Integer> copyVisited(List<Integer> visited) {
		return new ArrayList<Integer>(visited);
	}

	private void fillGraph() {

		scan.nextLine();

		String _roads[] = new String[roads];

		for (int i = 0; i < roads; i++)
			_roads[i] = scan.nextLine();

		for (int i = 0; i < _roads.length; i++) {
			String sub = _roads[i].substring(0, 2);
			if (nameOfCities.contains(sub))
				continue;
			else
				nameOfCities.add(sub);
		}

		String currentCity = nameOfCities.get(0);
		int index = nameOfCities.indexOf(nameOfCities.get(0));

		for (int i = 0; i < _roads.length; i++) {
			String sub = _roads[i].substring(0, 2);
			if (currentCity.equals(sub)) {
				int _index = nameOfCities.indexOf(_roads[i].substring(3, 5));
				int distance = Integer.parseInt(_roads[i].substring(6, 7));
				graph[index][_index] = distance;
			} else {
				currentCity = sub;
				index = nameOfCities.indexOf(currentCity);
				int _index = nameOfCities.indexOf(_roads[i].substring(3, 5));
				int distance = Integer.parseInt(_roads[i].substring(6, 7));
				graph[index][_index] = distance;
			}
		}

		// for (int i = 0; i < graph.length; i++)
		// for (int j = 0; j < graph.length; j++)
		// if (graph[i][j] > 0)
		// graph[i][j] = 7 - graph[i][j];

	}

	private void print() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

}
