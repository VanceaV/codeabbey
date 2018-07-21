package problems_121_150;

import java.util.Scanner;

class Text {
	int Width;
	int Height;
	int Lenght;

	Text(int a, int b, int c) {
		Width = a;
		Height = b;
		Lenght = c;
	}

	void XY() {
		int Or = 0;
		int Vr = 0;
		int x = 0;
		int y = 0;
		System.out.print(x + " " + y + " ");
		for (int i = 0; i < 100; i++) {
			if (Or == 0)
				x++;
			if (Or == 1)
				x--;
			if (Vr == 0)
				y++;
			if (Vr == 1)
				y--;
			System.out.print(x + " " + y + " ");
			if (y + 1 == Height)
				Vr = 1;
			if (y == 0)
				Vr = 0;
			if (x == 0)
				Or = 0;
			if (x + Lenght == Width)
				Or = 1;
		}
	}
}

public class FlyingTextScreensaver_134 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Text t = new Text(sc.nextInt(), sc.nextInt(), sc.nextInt());
		t.XY();
		sc.close();
	}
}
