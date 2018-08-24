package problems_121_150;

import java.io.*;
import java.util.*;

public class FourPicsOneWord_131 {

	private Scanner scan = new Scanner(System.in);

	private int count[];
	private int lengths[];

	String[][] lists;

	private int iter;

	public FourPicsOneWord_131() {
		iter = scan.nextInt();
		count = new int[iter];
		lengths = new int[iter];
		lists = new String[iter][];
		getData();
	}

	private void result() throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File("words.txt")))) {
			for (String line; (line = br.readLine()) != null;) {
				int length = line.length();
				for (int i = 0; i < iter; i++) {
					if (length == lengths[i]) {
						if (check(line, length, lists[i])) {
							count[i]++;
						}

					}
				}
			}
		}

		for (int i : count)
			System.out.print(i + " ");
	}

	private void getData() {
		scan.nextLine();

		for (int i = 0; i < iter; i++) {

			String Array[] = scan.nextLine().split(" ");
			lengths[i] = Integer.parseInt(Array[0]);
			String temp[] = new String[Array.length - 1];

			for (int j = 1; j < Array.length; j++) {
				temp[j - 1] = Array[j];
			}
			lists[i] = temp;
		}
	}

	private boolean check(String st, int worldLength, String[] list) {

		String[] temp = copyStringArray(list);

		for (int i = 0; i < st.length(); i++) {
			String t = st.substring(i, i + 1);

			boolean b = false;
			for (int j = 0; j < list.length; j++) {
				if (t.equals(temp[j])) {
					temp[j] = "";
					b = true;
					break;
				}
			}
			if (!b)
				return false;
		}

		return true;

	}

	private String[] copyStringArray(String[] array) {
		return Arrays.copyOf(array, array.length);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FourPicsOneWord_131 fpow = new FourPicsOneWord_131();
		fpow.result();
	}
}
