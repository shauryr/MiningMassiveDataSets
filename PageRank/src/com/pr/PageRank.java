package com.pr;

public class PageRank {
	static int vertexCount = 3;
	static double numVertex = 3.0;
	static double beta = 0.7;

	public static void main(String[] arg) {


		double input[][] = { { 0.0, 0.0, 0.0 }, { 0.5, 0.0, 0.0 },
				{ 0.5, 1.0, 1.0 }, };

		Matrix M = new Matrix(input);
		Matrix alphaMat = new Matrix(vertexCount, vertexCount);
		M = MatrixMultiplyByConstant(beta, M);
		alphaMat = MatrixMultiplyByConstant(1.0 - beta, alphaMat);
		Matrix A = MatrixAddition(M, alphaMat);
		double pageRank[][] = { { 1.0 }, { 1.0 }, { 1.0 } };

		Matrix pr = new Matrix(pageRank);
		for (int i = 0; i < 100000; i++) {
			pr = MatrixMultiplication(pr, A);
		}

		double result[][] = pr.getData();

		for (int i = 0; i < pr.getNrows(); i++) {
			for (int j = 0; j < pr.getNcols(); j++) {
				System.out.println(result[i][j]);
			}
		}
	}

	public static Matrix MatrixMultiplyByConstant(double beta, Matrix M) {
		double matrix[][] = M.getData();
		for (int i = 0; i < M.getNrows(); i++) {
			for (int j = 0; j < M.getNrows(); j++) {
				matrix[i][j] = beta * matrix[i][j];
			}
		}
		return new Matrix(matrix);
	}

	public static Matrix MatrixAddition(Matrix m1, Matrix m2) {
		double matrix[][] = new double[m1.getNcols()][m1.getNrows()];
		double mat1[][] = m1.getData();
		double mat2[][] = m2.getData();
		for (int i = 0; i < m1.getNrows(); i++) {
			for (int j = 0; j < m2.getNrows(); j++) {
				matrix[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return new Matrix(matrix);
	}

	public static Matrix MatrixMultiplication(Matrix pageRank, Matrix m) {
		double initialPR[][] = pageRank.getData();
		double matrix[][] = m.getData();
		double result[][] = new double[vertexCount][1];
		double sum = 0.0;
		// int count = 0;
		for (int i = 0; i < vertexCount; i++) { // aRow
			sum = 0.0;
			for (int j = 0; j < vertexCount; j++) { // bColumn

				for (int k = 0; k < 1; k++) { // aColumn

					sum += initialPR[j][k] * matrix[i][j];
				}
			}
			result[i][0] = sum;
			// count++;
		}
		return new Matrix(result);
	}
}
