package problems_61_90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BezierCurves_78 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		BezierCurves_78 bc = new BezierCurves_78();
		bc.result();
	}

	private void result() {

		int iter = scan.nextInt();
		double N = scan.nextInt();
		double forRate = 1.0 / (N - 1);

		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < iter; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			points.add(new Point(x, y));
		}

		double rate = 0;

		while (N-- > 0) {

			List<Point> clonePoints = copyArray(points);

			while (clonePoints.size() != 1) {
				List<Point> _points = new ArrayList<Point>();
				for (int i = 0; i < clonePoints.size() - 1; i++) {
					double newX = xOfNewPoint(clonePoints.get(i), clonePoints.get(i + 1), rate);
					double newY = yOfNewPoint(clonePoints.get(i), clonePoints.get(i + 1), rate);
					_points.add(new Point(newX, newY));
				}
				clonePoints = _points;
			}

			rate += forRate;

			System.out.print(clonePoints.get(0) + " ");
		}
	}

	private <T> List<T> copyArray(List<T> list) {
		return new ArrayList<T>(list);

	}

	private double xOfNewPoint(Point a, Point b, double rate) {
		return (1 - rate) * a.getX() + rate * b.getX();

	}

	private double yOfNewPoint(Point a, Point b, double rate) {

		return (1 - rate) * a.getY() + rate * b.getY();

	}

}

class Point {

	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return Math.round(x) + " " + Math.round(y);
	}
}
