package problems_61_90;

import java.util.Scanner;

public class HexagonalGrid_73 {

	private static Scanner scan = new Scanner(System.in);
	private static final double t = Math.sqrt(1 - (0.5 * 0.5));;

	public static void main(String[] args) {
		HexagonalGrid_73 hg = new HexagonalGrid_73();
		hg.result();
	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();
		while (iter-- > 0) {
			String st = scan.nextLine();
			double x = 0, y = 0;
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) == 'A')
					x++;
				if (st.charAt(i) == 'B') {
					x += 0.5;
					y += t;
				}
				if (st.charAt(i) == 'C') {
					x -= 0.5;
					y += t;
				}
				if (st.charAt(i) == 'D')
					x--;
				if (st.charAt(i) == 'E') {
					x -= 0.5;
					y -= t;
				}
				if (st.charAt(i) == 'F') {
					x += 0.5;
					y -= t;
				}
			}

			System.out.print(distance(x, y) + " ");
		}
	}

	private double distance(double X, double Y) {
		return Math.sqrt(X * X + Y * Y);
	}
}
