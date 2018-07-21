package problems_91_120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CrossingTheRoad_100 {

	private static Scanner scan = new Scanner(System.in);

	private char[][] roads;
	private final int speed = 5;
	private final int distance = 18;

	private List<Integer> list = new ArrayList<Integer>();

	public CrossingTheRoad_100(int numbersOfRoads, int roadLength) {
		roads = new char[numbersOfRoads][roadLength];
	}

	public static void main(String[] args) {
		CrossingTheRoad_100 cr = new CrossingTheRoad_100(11, 40);
		cr.result();
	}

	private boolean check(HashMap<Integer, List<Integer>> hm, int road, int moves) {
		if (hm.containsKey(road)) {
			if (hm.get(road).contains(moves)) {
				return false;
			} else {
				hm.get(road).add(moves);
				return true;
			}
		} else {
			List<Integer> l = new ArrayList<Integer>();
			l.add(moves);
			hm.put(road, l);
			return true;
		}
	}

	private void recursive(char[][] roads, int road, int moves, HashMap<Integer, List<Integer>> hm) {
		if (road == roads.length - 1) {
			list.add(moves);
		} else {
			if (carAccident(roads[road + 1]) == 1 && check(hm, road + 1, moves + 1)) {
				char[][] copyR = copyRoads(roads);
				move(copyR);
				recursive(copyR, road + 1, moves + 1, hm);
			}
			if (road - 1 >= 0 && carAccident(roads[road - 1]) == 1 && check(hm, road - 1, moves + 1)) {
				char[][] copyR = copyRoads(roads);
				move(copyR);
				recursive(copyR, road - 1, moves + 1, hm);
			}
			if (carAccident(roads[road]) == 1 && check(hm, road, moves + 1)) {
				char[][] copyR = copyRoads(roads);
				move(copyR);
				recursive(copyR, road, moves + 1, hm);
			}
		}
	}

	private void result() {
		int iter = scan.nextInt();
		while (iter-- > 0) {
			HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
			fillEmty();
			fillRoads();
			recursive(roads, 0, 0, hm);

			Collections.sort(list);
			if (list.size() == 0) {
				System.out.print(-1 + " ");
			} else {
				System.out.print(list.get(0) + 1 + " ");
			}
			list.clear();
		}
	}

	private void move(char[][] roads) {
		for (int i = 0; i < roads.length; i++) {
			int iter = 0;
			while (iter < roads[i].length) {
				if (roads[i][iter] != '+' && iter < distance + i) {
					roads[i][iter] = '-';
					iter++;
					continue;
				} else {
					roads[i][iter] = '$';
					if ((iter + (distance - speed)) < roads[i].length) {
						roads[i][iter + (distance - speed)] = '+';
					}
					if ((iter - (speed + i)) >= 0) {
						roads[i][iter - (speed + i)] = '+';
					}
					if ((iter + (speed + i)) < roads[i].length) {
						roads[i][iter + (speed + i)] = '-';
					}
					iter += distance + i;
				}
			}
		}
	}

	private void fillEmty() {

		for (int i = 0; i < roads.length; i++) {
			for (int j = 0; j < roads[0].length; j++) {
				roads[i][j] = '-';
			}
		}
	}

	private void fillRoads() {

		for (int i = 0; i < roads.length; i++) {
			int pos = scan.nextInt();
			roads[i][pos] = '$';
			if ((pos - (speed + i)) >= 0)
				roads[i][pos - (speed + i)] = '+';
			for (int j = 1; j < 10; j++) {
				if ((pos + (distance + i) * j) < roads[i].length) {
					roads[i][pos + (distance + i) * j] = '$';
					roads[i][pos + (distance + i) * j - (speed + i)] = '+';

				} else if ((pos + (distance + i) * j) - (speed + i) < roads[i].length) {
					roads[i][(pos + (distance + i) * j) - (speed + i)] = '+';
				}
			}
		}
	}

	private int carAccident(char[] road) {
		int index = -1;
		for (int i = 0; i < road.length; i++) {
			if (road[i] == '$' || road[0] == '+') {
				index = 0;
				break;
			}
			if (road[i] == '+' && i != 0) {
				index = 1;
				break;
			}
		}
		return index;
	}

	private char[][] copyRoads(char[][] roads) {
		char[][] copyRoads = new char[roads.length][roads[0].length];

		for (int i = 0; i < roads.length; i++) {
			for (int j = 0; j < roads[i].length; j++) {
				copyRoads[i][j] = roads[i][j];
			}
		}
		return copyRoads;
	}
}
