package problems_91_120;

import java.util.Scanner;

public class AzimuthAtTreasureIsland_98 {

	private static Scanner scan = new Scanner(System.in);
	private double X, Y;

	public static void main(String[] args) {
		AzimuthAtTreasureIsland_98 ati = new AzimuthAtTreasureIsland_98();
		ati.result();
	}

	private void result() {
		scan.nextLine();

		String st = "";

		while (true) {
			st = scan.nextLine();
			if (st.equals("Dig here!"))
				break;
			String array[] = st.split(" ");
			double distance = Integer.parseInt(array[1]);
			double angle = Integer.parseInt(array[5]);
			X += distance * Math.sin(Math.toRadians(angle));
			Y += distance * Math.cos(Math.toRadians(angle));
		}

		System.out.println(Math.round(X) + " " + Math.round(Y));
	}
}
