package problems_61_90;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSequence_67 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		FibonacciSequence_67 fs = new FibonacciSequence_67();
		fs.result();

	}

	private void result() {
		int iter = scan.nextInt();
		scan.nextLine();
		while (iter-- > 0) {
			System.out.print(index(scan.nextLine()) + " ");
		}
	}

	private int index(String number) {
		
		if(number.equals("0"))
			return 0;
		if(number.equals("1"))
			return 1;
		
		BigInteger start = new BigInteger("0");
		BigInteger next = new BigInteger("1"), _next = new BigInteger("1");
		BigInteger toFind = new BigInteger(number);
		int k = 1;
		while (_next.compareTo(toFind) != 0) {
			_next = next.add(start);
			start = next;
			next = _next;
			k++;

		}
		return k;
	}

}
