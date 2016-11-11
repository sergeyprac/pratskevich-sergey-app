package com.company.homework2;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        double []arr1 = {1, 2, 3, 4, 5, 6};
        double []arr2 = {5, 6, 7, 3.14};
        Vector vec1 = new Vector(arr1.length, arr1);
        Vector vec2 = new Vector(arr2.length, arr2);
        Matrix matrix1 = new Matrix(2, 3, arr1);
        Matrix matrix2 = new Matrix(2, 2, arr2);
        vec1.Print();
        System.out.println("Сложение");
        vec1.Add(vec1);
        vec1.Print();
        vec1.Add(vec2);
        System.out.println("Умножение");
        vec1.Multiply(vec1);
        vec1.Print();
        FileOutputStream fos = new FileOutputStream("exeption.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(vec1);
        FileInputStream fis = new FileInputStream("exeption.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Vector vec = (Vector)oin.readObject();
        vec.Print();
        oos.flush();
        oos.close();
        oin.close();
        matrix1.Print();
        System.out.println("Транспонирование");
        matrix1.Transpose();
        matrix1.Print();
        matrix2.Multiply(matrix1);
        matrix1.Multiply(matrix2);
        matrix1.Print();
    }
}
