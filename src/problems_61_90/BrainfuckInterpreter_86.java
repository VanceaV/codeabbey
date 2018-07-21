package problems_61_90;

import java.util.Scanner;

public class BrainfuckInterpreter_86 {

	private Scanner sc = new Scanner(System.in);
	private final int LENGTH = 65535;
	private int[] mem = new int[LENGTH];
	private int dataPointer;

	public void result() {
		String program = sc.nextLine();
		interpret(program);
	}

	public void interpret(String code) {
		int l = 0;
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == '>') {
				dataPointer = (dataPointer == LENGTH - 1) ? 0 : dataPointer + 1;
			} else if (code.charAt(i) == '<') {
				dataPointer = (dataPointer == 0) ? LENGTH - 1 : dataPointer - 1;
			} else if (code.charAt(i) == '+') {
				mem[dataPointer]++;
			} else if (code.charAt(i) == '-') {
				mem[dataPointer]--;
			} else if (code.charAt(i) == '.') {
				System.out.print((char) mem[dataPointer]);
			} else if (code.charAt(i) == ',') {
				mem[dataPointer] = sc.next().charAt(0);
			} else if (code.charAt(i) == ':') {
				System.out.print(mem[dataPointer] + " ");
			} else if (code.charAt(i) == ';') {
				mem[dataPointer] = sc.nextInt();
			}

			else if (code.charAt(i) == '[') {
				if (mem[dataPointer] == 0) {
					i++;
					while (l > 0 || code.charAt(i) != ']') {
						if (code.charAt(i) == '[')
							l++;
						if (code.charAt(i) == ']')
							l--;
						i++;
					}
				}
			} else if (code.charAt(i) == ']') {
				if (mem[dataPointer] != 0) {
					i--;
					while (l > 0 || code.charAt(i) != '[') {
						if (code.charAt(i) == ']')
							l++;
						if (code.charAt(i) == '[')
							l--;
						i--;
					}
					i--;
				}
			}
		}
	}

	public static void main(String[] args) {
		BrainfuckInterpreter_86 bi = new BrainfuckInterpreter_86();
		bi.result();

	}

}
