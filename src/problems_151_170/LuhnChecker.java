package problems_151_170;

import java.util.Scanner;

/**
 *
 * @author paulthim
 */
public class LuhnChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            String creditNumberString = in.next();
            char[] creditArray = creditNumberString.toCharArray();
            for (int j = creditArray.length; j > 0; j--) {
                int c = Character.getNumericValue(creditArray[j-1]);
                if (j%2 == 0) {
                    sum += c;
                } else {
                    if (c>=5) {
                        sum = sum + (c*2-9);
                    } else {
                        sum = sum + (c*2);
                    }
                }
            }
            System.out.println("Sum: " + sum);
        }
        in.close();
    }
}