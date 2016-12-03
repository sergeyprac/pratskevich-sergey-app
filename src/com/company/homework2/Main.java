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
            System.out.println("wrong size");
        }
        vec1.print();
        System.out.println("+");
        try {
            vec1.add(vec1).print();
        } catch (WrongSizeExeption e) {

        }
        try {
            vec1.add(vec2);
        } catch (WrongSizeExeption e) {
            System.out.println("wrong size");
        }
        System.out.println("*");
        try {
            vec1.multiply(vec1).print();
        } catch (WrongSizeExeption e) {
            System.out.println("wrong size");
        }
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
        System.out.println();
        matrix1.print();
        System.out.println("Транспонирование");
        matrix1.transpose().print();
        try {
            matrix2.multiply(matrix1).print();
        } catch (WrongSizeExeption e) {
            System.out.println("wrong size");
        }
        try {
            matrix1.multiply(matrix2).print();
        } catch (WrongSizeExeption e) {
            System.out.println("wrong size");
        }
    }
}
