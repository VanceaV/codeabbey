package problems_1_30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleInArray_23 {

	private Scanner scan = new Scanner(System.in);
	private static final int mod = 10000007;
	private static final int mult = 113;
	private List<Integer> array;
	private int _array[];

	public static void main(String[] args) {
		BubbleInArray_23 ba = new BubbleInArray_23();
		ba.result();

	}

	private void result() {
		
		array = new ArrayList<Integer>();

		int temp, _temp;
		while (true) {
			temp = Integer.parseInt(scan.next());
			if (temp != -1)
				array.add(temp);
			else
				break;
		}
		_array = new int[array.size()];

		for (int i = 0; i < array.size(); i++)
			_array[i] = array.get(i);

		temp = 0;

		for (int i = 1; i < array.size(); i++)
			if (_array[i - 1] > _array[i]) {
				temp++;
				_temp = _array[i - 1];
				_array[i - 1] = _array[i];
				_array[i] = _temp;
			}
		System.out.println(temp + " " + check(_array));
	}

	private long check(int _array[]) {
		long result = 0;
		for (int i = 0; i < _array.length; i++)
			result = ((result + _array[i]) * mult) % mod;

		return result;
	}
}
