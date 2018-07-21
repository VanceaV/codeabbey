package problems_31_60;


import java.util.Scanner;

public class JosephusProblem_32 {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(josephus(new Integer(scan.next()), new Integer(scan.next())));
	}

	static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		else
			return (josephus(n - 1, k) + k - 1) % n + 1;
	}

}
