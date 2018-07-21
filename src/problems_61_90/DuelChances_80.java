package problems_61_90;

import java.util.Scanner;

public class DuelChances_80 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		result();
	}

	private static void result() {
		int iter = scan.nextInt();

		while (iter-- > 0) {
			int alan = scan.nextInt();
			int bob = scan.nextInt();
			long alanChances = chanceForAlan(alan, bob);
			System.out.print(alanChances + " ");
		}
	}

	private static long chanceForAlan(double alan, double bob) {

		double nextRound = 1;
		boolean alanShoot = true;
		boolean firstAlanShoot = true;
		double alanMiss = (100 - alan) / 100;
		double bobMiss = (100 - bob) / 100;

		double _alan = alan, _bob = 0;

		while ((Math.round(_alan) + Math.round(_bob)) < 100) {

			if (firstAlanShoot) {

				firstAlanShoot = false;
				nextRound *= alanMiss;
				alanShoot = false;
				continue;

			}
			if (alanShoot) {
				_alan += (alan * nextRound);
				nextRound *= alanMiss;
				alanShoot = !alanShoot;
			} else {
				_bob += (bob * nextRound);
				nextRound *= bobMiss;
				alanShoot = !alanShoot;
			}

		}
		return Math.round(_alan);
	}
}
