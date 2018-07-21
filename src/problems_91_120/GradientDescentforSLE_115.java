package problems_91_120;

import java.util.*;

public class GradientDescentforSLE_115 {
	Scanner sc;
	int NumberOfCases;
	ArrayList<ArrayList<Integer>> data;
	ArrayList<Integer> CS;

	public GradientDescentforSLE_115() {
		sc = new Scanner(System.in);
		NumberOfCases = sc.nextInt();
		data = new ArrayList<ArrayList<Integer>>();
		CS = new ArrayList<Integer>();
	}

	void Try() {

		for (int i = 0; i < NumberOfCases; i++) {
			int t = sc.nextInt();
			double[][] Array = new double[t + 1][t];
			double[] X = new double[t];

			for (int s = 0; s < t + 1; s++) {
				for (int ss = 0; ss < t; ss++) {
					Array[s][ss] = (double) sc.nextInt();
				}
			}
			double STEP = 0.01;
			double DX;
			int ITER = 0;
			double Y;
			double[] G = new double[t];
			double[] XNEW = new double[t];
			double YNEW;

			while (true) {

				Y = TargetFunction(Array, X);
				if (Y < 0.0001)
					break;
				DX = STEP / 10.0;
				G = CalculateGradient(Array, X, DX);
				for (int c = 0; c < t; c++)
					XNEW[c] = X[c];
				for (int c = 0; c < t; c++)
					XNEW[c] -= G[c] * STEP;
				YNEW = TargetFunction(Array, XNEW);
				if (YNEW < Y) {
					for (int c = 0; c < t; c++)
						X[c] = XNEW[c];
					STEP = MIN(0.1, STEP * 1.25);
				} else
					STEP = STEP / 1.25;

				ITER++;
			}
			System.out.print(ITER + " ");
		}
	}

	double TargetFunction(double[][] Array, double[] X) {

		double F = 0;
		double[] f = new double[X.length];

		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X.length; j++) {
				f[i] += Array[i][j] * X[j];
			}
			f[i] -= Array[X.length][i];
		}

		for (int i = 0; i < X.length; i++)
			F += Math.pow(f[i], 2);
		return F;
	}

	double[] CalculateGradient(double[][] Array, double[] X, double DX) {
		double[] G = new double[X.length];
		double[] Y = new double[X.length];
		double y = TargetFunction(Array, X);

		for (int i = 0; i < X.length; i++) {
			double[] x = new double[X.length];
			for (int j = 0; j < X.length; j++)
				x[j] = X[j];
			x[i] += DX;
			Y[i] = TargetFunction(Array, x);
			G[i] = (Y[i] - y) / DX;
		}
		return G;
	}

	double MIN(double a, double b) {
		if (a > b)
			return b;
		else
			return a;
	}

	public static void main(String[] args) {
		GradientDescentforSLE_115 GDsle = new GradientDescentforSLE_115();
		GDsle.Try();
	}
}