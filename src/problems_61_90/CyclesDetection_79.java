package problems_61_90;

import java.util.ArrayList;
import java.util.Scanner;

public class CyclesDetection_79 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		CyclesDetection_79 cd = new CyclesDetection_79();
		cd.result();

	}

	private void result() {
		int iter = scan.nextInt();

		while (iter-- > 0) {

			int numbersOfRoads = scan.nextInt(), result = 0;
			ArrayList<String> cities = new ArrayList<String>();
			String roads[][] = new String[numbersOfRoads][];

			for (int i = 0; i < numbersOfRoads; i++)
				roads[i] = scan.next().split("-");

			String nextCity = roads[0][0];
			cities.add(nextCity);

			for (int i = 0; i < numbersOfRoads; i++) {

				if (nextCity.equals(roads[i][0]))
					nextCity = roads[i][1];
				else
					nextCity = roads[i][0];

				if (cities.contains(nextCity)) {
					result = 1;
					break;
				} else {
					cities.add(nextCity);
				}
			}

			System.out.print(result + " ");
		}
	}
}
