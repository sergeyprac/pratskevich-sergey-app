package com.company.homework2;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double[] arr1 = {1, 2, 3, 4, 5, 6};
        double[] arr2 = {5, 6, 7, 3.14};
        Vector vec1 = null;
        Vector vec2 = null;
        Matrix matrix1 = null;
        Matrix matrix2 = null;
        try {
            vec1 = new Vector(arr1);
            vec2 = new Vector(arr2);
            matrix1 = new Matrix(2, 3, arr1);
            matrix2 = new Matrix(2, 2, arr2);
        } catch (WrongSizeExeption e) {
            System.out.println("Несоответствие размеров матриц");
        }
        vec1.print();
        System.out.println("Сложение");
        vec1.add(vec1);
        vec1.print();
        vec1.add(vec2);
        System.out.println("Умножение");
        vec1.multiply(vec1);
        vec1.print();
        FileOutputStream fos = new FileOutputStream("exeption.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(vec1);
        FileInputStream fis = new FileInputStream("exeption.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Vector vec = (Vector) oin.readObject();
        vec.print();
        oos.flush();
        oos.close();
        oin.close();
        matrix1.print();
        System.out.println("Транспонирование");
        matrix1.transpose();
        matrix1.print();
        matrix2.multiply(matrix1);
        matrix2.print();
        matrix1.multiply(matrix2);
        matrix1.print();
    }
}
