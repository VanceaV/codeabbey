package problems_61_90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransitiveClosureOnCandyStates_65 {

	private static Scanner scan = new Scanner(System.in);

	private int v[][];
	private List<String> states;

	public TransitiveClosureOnCandyStates_65() {

		buildTheGraph();
		floyd_warshall();

	}

	private void buildTheGraph() {

		int iter = scan.nextInt();
		scan.nextLine();

		states = new ArrayList<String>();
		List<String> statesFirst = new ArrayList<String>();
		List<String> statesSecond = new ArrayList<String>();

		for (int i = 0; i < iter; i++) {
			String[] st = scan.nextLine().replaceAll("\\s", "").split("-");
			statesFirst.add(st[0]);
			statesSecond.add(st[1]);
		}

		for (int i = 0; i < iter; i++) {
			if (!states.contains(statesFirst.get(i)))
				states.add(statesFirst.get(i));
			if (!states.contains(statesSecond.get(i)))
				states.add(statesSecond.get(i));
		}

		v = new int[states.size()][states.size()];

		for (int i = 0; i < states.size(); i++) {
			for (int j = 0; j < states.size(); j++) {
				if (i == j)
					v[i][j] = 0;
				else
					v[i][j] = 10000;
			}
		}

		for (int i = 0; i < iter; i++) {
			int ii = states.indexOf(statesFirst.get(i));
			int jj = states.indexOf(statesSecond.get(i));
			v[ii][jj] = 1;
			v[jj][ii] = 1;
		}

	}

	private void floyd_warshall() {

		for (int k = 0; k < v.length; k++)
			for (int i = 0; i < v.length; i++)
				for (int j = 0; j < v.length; j++) {
					if (v[i][j] > v[i][k] + v[k][j]) {
						v[i][j] = v[i][k] + v[k][j];
					}
				}
	}

	private void result() {

		int iter = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < iter; i++) {
			String[] st = scan.nextLine().replaceAll("\\s", "").split("-");
			int ii = states.indexOf(st[0]);
			int jj = states.indexOf(st[1]);

			System.out.print(v[ii][jj] + " ");
		}

	}

	public static void main(String[] args) {

		TransitiveClosureOnCandyStates_65 tcoc = new TransitiveClosureOnCandyStates_65();
		tcoc.result();

	}
}
