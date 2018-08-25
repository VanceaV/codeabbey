package problems_121_150;

import java.util.Scanner;

public class ExtendedEuclideanAlgorithm_143 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ExtendedEuclideanAlgorithm_143 eea = new ExtendedEuclideanAlgorithm_143();
		eea.result();

	}

	private void result() {
		int iter = scan.nextInt();

		while (iter-- > 0) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			find(x, y);
		}
	}

	private void find(int x, int y) {

		int qcd = GCD(x, y), Sprev = 1, Scur = 0, Tprev = 0, Tcur = 1, Snext, Tnext;
		int X = max(x, y), Y = min(x, y), q, r = Integer.MAX_VALUE;

		while (true) {
			q = X / Y;
			r = X % Y;
			if (r == 0)
				break;
			Snext = Sprev - q * Scur;
			Tnext = Tprev - q * Tcur;
			Sprev = Scur;
			Tprev = Tcur;
			Scur = Snext;
			Tcur = Tnext;
			X = Y;
			Y = r;
		}

		if (x * Scur + y * Tcur == qcd)
			System.out.print(qcd + " " + Scur + " " + Tcur + " ");
		else
			System.out.print(qcd + " " + Tcur + " " + Scur + " ");

	}

	private int max(int x, int y) {
		if (x > y)
			return x;
		else
			return y;
	}

	private int min(int x, int y) {
		if (x < y)
			return x;
		else
			return y;
	}

	private int GCD(int x, int y) {

		while (x != y) {

			if (x > y)
				x -= y;
			else
				y -= x;
		}
		return x;
	}
}
