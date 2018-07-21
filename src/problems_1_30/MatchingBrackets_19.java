package problems_1_30;

import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets_19 {
	private Scanner scan = new Scanner(System.in);
	private int iter;

	public static void main(String[] args) {

		MatchingBrackets_19 mb = new MatchingBrackets_19();
		mb.result();
	}

	private void result() {

		iter = Integer.parseInt(scan.nextLine());
		while (iter-- > 0) {
			if (result(scan.nextLine()))
				System.out.print("1 ");
			else
				System.out.println("0 ");
		}
	}

	private boolean result(String st) {

		boolean result = true;

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{' || ch == '<')
				stack.push(ch);

			if ((ch == ')' || ch == ']' || ch == '}' || ch == '>') && stack.isEmpty()) {
				result = false;
				break;

			}

			if (ch == ')' && stack.pop() != '(') {
				result = false;
				break;
			}

			if (ch == ']' && stack.pop() != '[') {
				result = false;
				break;
			}

			if (ch == '}' && stack.pop() != '{') {
				result = false;
				break;
			}

			if (ch == '>' && stack.pop() != '<') {
				result = false;
				break;
			}
		}
		if (!stack.isEmpty())
			result = false;
		return result;
	}
}
