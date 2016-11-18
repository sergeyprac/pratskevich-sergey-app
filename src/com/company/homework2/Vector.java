package com.company.homework2;

import java.io.Serializable;

public class Vector extends Matrix implements Serializable {
    public Vector(double[] arr) throws WrongSizeExeption {
        super(1, arr.length, arr);
    }

    public int getSize() {
        return super.getCountRow();
    }

    public double getElement(int num) {
        return super.getElement(1, num);
    }

    public void add(Vector x) {
        super.add(x);
    }

    public void transpose() {
        super.transpose();
    }

    public void multiply(Vector x) {
        Matrix y = x.copy();
        y.transpose();
        super.multiply(y);
    }

    public void print() {
        super.print();
    }
}