package com.pr;

public class Matrix {
	private int nrows;
	private int ncols;
	private double[][] data;

	public Matrix(double[][] dat) {
		this.data = dat;
		this.nrows = dat.length;
		this.ncols = dat[0].length;
	}

	public Matrix(int nrow, int ncol) {
		this.nrows = nrow;
		this.ncols = ncol;
		data = new double[nrow][ncol];
		
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				data[i][j] = 1.0 / 3.0;
			}
		}
		
		
	}

	public int getNrows() {
		return nrows;
	}

	public void setNrows(int nrows) {
		this.nrows = nrows;
	}

	public int getNcols() {
		return ncols;
	}

	public void setNcols(int ncols) {
		this.ncols = ncols;
	}

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}
}