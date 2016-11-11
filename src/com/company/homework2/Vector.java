package com.company.homework2;

import java.io.Serializable;

public class Vector extends Matrix implements Serializable{
    public Vector(int n, double []arr) { super(1, n, arr); }
    public int GetSize(){
        return super.GetCountRow();
    }
    public double GetElement(int num){
        return super.GetElement(1, num);
    }
    public void Add(Vector x) { super.Add(x); }
    public void Transpose() { super.Transpose(); }
    public void Multiply(Vector x) {
        Matrix y = x.Copy();
        y.Transpose();
        super.Multiply(y);
    }
    public void Print() { super.Print();}
}