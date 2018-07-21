package problems_31_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MatchingWords_55 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		MatchingWords_55 mw = new MatchingWords_55();
		mw.result();
	}

	private void result() {

		String toCheck = scan.next();
		List<String> pool = new ArrayList<String>();
		List<String> matchingW = new ArrayList<String>();

		while (!toCheck.equals("end")) {
			if (isMathing(pool, toCheck))
				if (!matchingW.contains(toCheck))
					matchingW.add(toCheck);
			toCheck = scan.next();
		}
		Collections.sort(matchingW);
		for (String s : matchingW)
			System.out.print(s + " ");
	}

	private boolean isMathing(List<String> pool, String toCheck) {

		if (pool.contains(toCheck))
			return true;
		else
			pool.add(toCheck);

		return false;
	}
}
