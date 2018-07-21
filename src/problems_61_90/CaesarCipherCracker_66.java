package problems_61_90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CaesarCipherCracker_66 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int l = scan.nextInt();
		char[] alfa = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		double[] EnFreq = { 8.1, 1.5, 2.8, 4.3, 13.0, 2.2, 2.0, 6.1, 7.0, 0.15, 0.77, 7.0, 2.4, 6.8, 7.5, 1.9, 0.095,
				6.0, 6.3, 9.1, 2.8, 0.98, 2.4, 0.15, 2.0, 0.074 };
		double[] EncrFreq = new double[26];
		double[] DifFreq = new double[26];
		ArrayList<Double> List = new ArrayList<Double>();
		ArrayList<Double> List1 = new ArrayList<Double>();

		scan.nextLine();
		for (int i = 0; i < l; i++) {
			String st = scan.nextLine();
			char[] ch = st.toCharArray();
			double lenght = 0;
			for (int ll = 0; ll < st.length(); ll++) {
				if (ch[ll] != ' ') {
					lenght++;
				}
			}
			for (int j = 0; j < 26; j++) {
				double k = 0;
				for (char g : ch) {
					if (alfa[j] == g)
						k++;
				}
				EncrFreq[j] = k * (100.0 / lenght);
			}
			for (int j = 0; j < 26; j++) {
				checkDif(EnFreq, EncrFreq, DifFreq);
				List.add(max(DifFreq));
				rotation(EncrFreq);
			}
			for (int j = 0; j < 26; j++) {
				List1.add(List.get(j));
			}
			Collections.sort(List1);
			int k = 0;
			for (int j = 0; j < 26; j++) {
				if (List1.get(0) == List.get(j)) {
					k = j;
				}
			}
			CaesarCipherCracker(alfa, 26 - k, ch);
			List.clear();
			List1.clear();
		}
	}

	static double max(double[] d) {
		double sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += Math.pow(d[i], 2);
		}
		return sum;
	}

	static void rotation(double[] d) {
		double rot = d[25];
		double[] temp = new double[26];
		for (int i = 0; i < 26; i++) {
			temp[i] = d[i];
		}
		for (int i = 0; i < 26; i++) {
			if (i == 0) {
				d[0] = rot;
				continue;
			}
			d[i] = temp[i - 1];
		}
	}

	static void checkDif(double[] EnFreq, double[] EncrFreq, double[] DifFreq) {
		for (int j = 0; j < 26; j++) {
			DifFreq[j] = EncrFreq[j] - EnFreq[j];
		}
	}

	static void CaesarCipherCracker(char[] alfa, int pass, char[] ch) {
		int three = 0;
		for (int j = 0; j < ch.length; j++) {
			int k = 0;
			if (ch[j] != ' ') {
				for (char count : alfa) {
					++k;
					if (ch[j] == count) {
						break;
					}
				}
				if (k == pass) {
					System.out.print(alfa[25]);
					continue;
				}
				if (k > pass) {
					System.out.print(alfa[k - pass - 1]);
				}
				if (k < pass) {
					System.out.print(alfa[26 - (pass - k) - 1]);
				}
			}
			if (ch[j] == ' ') {
				System.out.print(" ");
				three++;
			}
			if (three == 3) {
				System.out.print(pass + " ");
				break;
			}
		}
	}
}
