package problems_1_30;

import java.util.Scanner;

public class Triangles_9 {

	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {
		Triangles_9 t = new Triangles_9();
		t.result();

	}

	private boolean checkTriangle(int a, int b, int c) {

		if (a + b < c)
			return false;
		else if (a + c < b)
			return false;
		else if (b + c < a)
			return false;

		return true;

	}

	void result() {

		iter = Integer.parseInt(scan.next());
		while (iter-- > 0)
			if (checkTriangle(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()),
					Integer.parseInt(scan.next())))
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");

	}

}
