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

    public Matrix copy() {
        double[] arr = new double[countRow * countColumn];
        int numElm = 0;
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                arr[numElm] = matrix[i][j];
                numElm++;
            }
        }
        try {
            return new Matrix(countRow, countColumn, arr);
        } catch (WrongSizeExeption e) {
            System.out.println("Несоответствие размеров матриц");
            return null;
        }
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

    public void add(Matrix x) {
        try {
            if (countRow != x.getCountRow() || countColumn != x.getCountColumn()) throw new WrongSizeExeption();
            for (int i = 0; i < countRow; i++) {
                for (int j = 0; j < countColumn; j++) {
                    matrix[i][j] += x.getElement(i, j);
                }
            }
        } catch (WrongSizeExeption e) {
            System.out.println("Несоответствие размеров матриц");
        }
    }

    public void multiply(Matrix x) {
        try {
            if (countColumn != x.getCountRow()) throw new WrongSizeExeption();
            double[][] arr = new double[countRow][x.getCountColumn()];
            for (int i = 0; i < countRow; i++) {
                for (int j = 0; j < x.getCountColumn(); j++) {
                    arr[i][j] = 0;
                    for (int k = 0; k < countColumn; k++) {
                        arr[i][j] += matrix[i][k] * x.getElement(k, j);
                    }
                }
            }
            countColumn = x.getCountColumn();
            matrix = arr;
        } catch (WrongSizeExeption e) {
            System.out.println("Несоответствие размеров матриц");
        }
    }

    public void transpose() {
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