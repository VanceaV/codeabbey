package problems_31_60;

import java.util.Scanner;

public class RotateString_31 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		RotateString_31 rs = new RotateString_31();
		rs.result();

	}

	private void result() {
		iter = new Integer(scan.nextLine());
		String read;
		for (int i = 0; i < iter; i++) {
			read = scan.nextLine();
			if (read.substring(0, 1).equals("-"))
				System.out.print(rotateString(new Integer(read.substring(0, 2)), read.substring(3)) + " ");
			else
				System.out.print(rotateString(new Integer(read.substring(0, 1)), read.substring(2)) + " ");
		}
	}

	private String rotateString(int pos, String toRatate) {
		int _pos = Math.abs(pos);
		byte[] bytes = toRatate.getBytes();
		byte temp;
		if (pos > 0) {
			while (_pos-- > 0) {
				temp = bytes[0];
				int count = 1;
				while (count < bytes.length) {
					bytes[count - 1] = bytes[count];
					count++;
				}

				bytes[bytes.length - 1] = temp;
			}

		} else {

			while (_pos-- > 0) {
				temp = bytes[bytes.length - 1];
				int count = bytes.length - 1;
				while (count > 0) {
					bytes[count] = bytes[count - 1];
					count--;
				}
				bytes[0] = temp;
			}

		}

		return new String(bytes);
	}

}