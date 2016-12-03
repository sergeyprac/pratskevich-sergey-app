package com.company.homework2;

import java.io.Serializable;

public class Matrix implements Serializable {
    public Matrix(int m, int n, double[] arr) throws WrongSizeExeption {
        if (arr.length != m * n) throw new WrongSizeExeption();
        countRow = m;
        countColumn = n;
        matrix = new double[countRow][countColumn];
        int numElm = 0;
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                matrix[i][j] = arr[numElm];
                numElm++;
            }
        }
    }

    public Matrix copy() throws WrongSizeExeption {
        double[] arr = new double[countRow * countColumn];
        int numElm = 0;
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                arr[numElm] = matrix[i][j];
                numElm++;
            }
        }
        return new Matrix(countRow, countColumn, arr);
    }

    public int getCountRow() {
        return countRow;
    }

    public int getCountColumn() {
        return countColumn;
    }

    public double getElement(int row, int column) {
        return matrix[row][column];
    }

    public Matrix add(Matrix x) throws WrongSizeExeption {
        if (countRow != x.getCountRow() || countColumn != x.getCountColumn()) throw new WrongSizeExeption();
        double[] arr = new double[countColumn * countRow];
        int k = 0;
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                arr[k] = matrix[i][j] + x.getElement(i, j);
                k++;
            }
        }
        return new Matrix(countRow, countColumn, arr);
    }

    public Matrix multiply(Matrix x) throws WrongSizeExeption {
        //try {
        int s = 0;
        if (countColumn != x.getCountRow()) throw new WrongSizeExeption();
        double[] arr = new double[countRow * x.getCountColumn()];
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < x.getCountColumn(); j++) {
                arr[s] = 0;
                for (int k = 0; k < countColumn; k++) {
                    arr[s] += matrix[i][k] * x.getElement(k, j);
                }
                s++;
            }
        }
        return new Matrix(countRow, x.getCountColumn(), arr);
    }

    public Matrix transpose() {
        double[][] arr = new double[countColumn][countRow];
        for (int i = 0; i < countColumn; i++) {
            for (int j = 0; j < countRow; j++) {
                arr[i][j] = matrix[j][i];
            }
        }
        int x = countColumn;
        countColumn = countRow;
        countRow = x;
        matrix = arr;
        return this;
    }

    public void print() {
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    private int countRow, countColumn;
    private double[][] matrix;
}