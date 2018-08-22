package problems_171_200;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation_181 {

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ReversePolishNotation_181 rpn = new ReversePolishNotation_181();
		rpn.result();

	}

	private void result() {
		double d = calcul(scan.nextLine());

		System.out.println((int)d);
	}

	private double calcul(String st) {

		Stack<Double> stack = new Stack<Double>();
		String array[] = st.split(" ");

		for (int i = 0; i < array.length; i++)
			operation(array[i], stack);
		return stack.pop();
	}

	private void operation(String st, Stack<Double> stack) {

		switch (st) {

		case "add": {
			double operand_2 = stack.pop();
			double operand_1 = stack.pop();
			double result = operand_1 + operand_2;
			stack.push(result);
			break;
		}
		case "sub": {
			double operand_2 = stack.pop();
			double operand_1 = stack.pop();
			double result = operand_1 - operand_2;
			stack.push(result);
			break;
		}

		case "mul": {
			double operand_2 = stack.pop();
			double operand_1 = stack.pop();
			double result = operand_1 * operand_2;
			stack.push(result);
			break;
		}

		case "div": {
			double operand_2 = stack.pop();
			double operand_1 = stack.pop();
			double result = operand_1 / operand_2;
			stack.push(result);
			break;
		}

		case "mod": {
			double operand_2 = stack.pop();
			double operand_1 = stack.pop();
			double result = operand_1 % operand_2;
			stack.push(result);
			break;
		}

		case "sqrt": {
			double operand_1 = stack.pop();
			double result = Math.sqrt(operand_1);
			stack.push(result);
			break;
		}

		default: {
			double d = Double.parseDouble(st);
			stack.push(d);
		}

		}
	}
}
