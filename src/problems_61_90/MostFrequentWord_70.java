package problems_61_90;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentWord_70 {

	private int seed;
	private Scanner scan = new Scanner(System.in);
	private final int A = 445;
	private final int C = 700001;
	private final int M = 2097152;
	private final String consonants = "bcdfghjklmnprstvwxz";
	private final String vowels = "aeiou";
	private final int numberOfWords = 900_000;
	private final int letters = 6;
	HashMap<String, Integer> map;

	public MostFrequentWord_70() {
		seed = scan.nextInt();
		map = new HashMap<String, Integer>();
	}

	public static void main(String[] args) {
		MostFrequentWord_70 mfw = new MostFrequentWord_70();
		Object mostFrequentWord = mfw.result();
		System.out.println(mostFrequentWord);
	}

	private Object result() {

		for (int i = 0; i < numberOfWords; i++) {
			StringBuilder sb = new StringBuilder("");
			
			for (int j = 1; j <= letters; j++) {
				seed = (A * seed + C) % M;

				if (j % 2 == 0) {
					int mod = seed % 5;
					sb.append(vowels.charAt(mod));
				} else {
					int mod = seed % 19;
					sb.append(consonants.charAt(mod));
				}
			}
			String newWord = sb.toString();
			if (map.containsKey(newWord)) {
				map.put(newWord, map.get(newWord) + 1);
			} else {
				map.put(newWord, 1);
			}
		}

		return getKeyFromValue(map, 8);
	}

	private Object getKeyFromValue(Map<String, Integer> hm, Object value) {
		for (Object o : hm.keySet()) {
			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}
}
