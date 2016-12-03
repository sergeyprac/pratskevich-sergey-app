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

    public Matrix add(Vector x) throws WrongSizeExeption {
        return super.add(x);
    }

    public Matrix transpose() {
        return super.transpose();
    }

    public Matrix multiply(Vector x) throws WrongSizeExeption {
        Matrix y = x.copy();
        y.transpose();
        return super.multiply(y);
    }

    public void print() {
        super.print();
    }
}