package problems_121_150;

import java.io.*;
import java.util.*;

public class Anagrams_127 {

	public static void main(String[] args) {
		String textFromFile = read("words.txt");
		String[] Arrays = textFromFile.split("/");

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		sc.nextLine();

		ArrayList<Character> list = new ArrayList<Character>();
		ArrayList<Character> list1 = new ArrayList<Character>();
		for (int i = 0; i < r; i++) {
			int k = 0;
			String st = sc.nextLine();
			char[] charArray = st.toCharArray();

			for (int j = 0; j < charArray.length; j++)
				list.add(charArray[j]);
			Collections.sort(list);
			// System.out.print(list);

			for (int j = 0; j < 63998; j++) {
				char[] charArray1 = Arrays[j].toCharArray();
				for (int j1 = 0; j1 < Arrays[j].length(); j1++)
					list1.add(charArray1[j1]);
				Collections.sort(list1);
				boolean check = false;
				if (list.size() == list1.size()) {
					for (int j2 = 0; j2 < list.size(); j2++) {
						if (list.get(j2) == list1.get(j2)) {
							check = true;
						} else {
							check = false;
							break;
						}
					}
				}
				if (check == true)
					k++;

				list1.clear();
			}

			System.out.print((k - 1) + " ");
			list.clear();
		}
		sc.close();
	}

	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("/");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
}