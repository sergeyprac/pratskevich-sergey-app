package com.company.homework2;

import java.io.Serializable;

public class Matrix implements Serializable {
    public Matrix(int countRow, int countColumn, double []arr){
        try {
            if(arr.length != countRow * countColumn)throw new WrongSizeExeption();
            else{
                m = countRow;
                n = countColumn;
                matrix = new double[m][n];
                int numElm = 0;
                for(int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = arr[numElm];
                        numElm++;
                    }
                }
            }
        } catch (WrongSizeExeption e) {
            System.out.println("Неверно указан размер");
        }
    }
    public Matrix Copy()
    {
        double []arr = new double[m * n];
        int numElm = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[numElm] = matrix[i][j];
                numElm++;
            }
        }
        return new Matrix(m, n, arr);
    }
    public int GetCountRow(){
        return m;
    }
    public int GetCountColumn(){
        return n;
    }
    public double GetElement(int row, int column) { return matrix[row][column]; }
    public void Add(Matrix x){
        try {
            if (m != x.GetCountRow() || n != x.GetCountColumn()) throw new WrongSizeExeption();
            else{
                for(int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] += x.GetElement(i, j);
                    }
                }
            }
        }catch (WrongSizeExeption e){
            System.out.println("Несоответствие размеров матриц");
        }
    }
    public void Multiply(Matrix x){
        try {
            if (n != x.GetCountRow()) throw new WrongSizeExeption();
            else{
                double [][]arr = new double[m][x.GetCountColumn()];
                for(int i = 0;i<m;i++) {
                    for(int j = 0;j<x.GetCountColumn();j++) {
                        arr[i][j] = 0;
                        for (int k = 0; k < n; k++) {
                            arr[i][j] += matrix[i][k] * x.GetElement(k, j);
                        }
                    }
                }
                n = x.GetCountColumn();
                matrix = arr;
            }
        }catch (WrongSizeExeption e){
            System.out.println("Несоответствие размеров матриц");
        }
    }
    public void Transpose()
    {
        double [][]arr = new double[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = matrix[j][i];
            }
        }
        int x = n;
        n = m;
        m = x;
        matrix = arr;
    }
    public void Print(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
    private int m, n;
    private double [][]matrix;
}