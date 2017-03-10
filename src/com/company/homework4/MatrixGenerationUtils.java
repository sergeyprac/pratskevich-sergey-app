package com.company.homework4;

import java.util.Random;

public class MatrixGenerationUtils {

    /****************************************************
     * USE THIS METHOD FOR RANDOM GENERATION OF VALUE!
     ****************************************************/
    private static double randomValue(Random random) {
        double sum = 0;
        int iterations = 20;
        double MAX_VALUE = Double.MAX_VALUE / iterations;
        for (int i = 0; i < iterations; i++) {
            sum += random.nextDouble() % MAX_VALUE;
        }
        return sum;
    }

    public static double[][] generateMatrix(int rows, int cols) {
        Random random = new Random();

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = randomValue(random);

        return matrix;
    }

    /**
     * Generate matrix in multiple threads
     *
     * @param rows         matrix rows number
     * @param cols         matrix cols number
     * @param threadsCount number of threads to use during generation
     * @return generated matrix
     */
    public static double[][] generateMatrixParallelRows(int rows, int cols, int threadsCount) {
        double[][] m = new double[rows][cols];
        int lenght = rows * cols / threadsCount, x = 0, y = 0, times;
        generateRows secondTrhead = null, firstTrhead = new generateRows(m, rows, x, y, rows * cols - lenght * (threadsCount - 1), 0);

        if (cols > rows * cols - lenght * (threadsCount - 1)) {
            x += rows * cols - lenght * (threadsCount - 1);
        } else {
            times = (int) Math.ceil((double) (rows * cols - lenght * (threadsCount - 1) - cols) / cols);
            y += times;
            x += rows * cols - lenght * (threadsCount - 1) - cols * (times - 1) - cols;
        }
        for (int i = 1; i < threadsCount; i++) {
            secondTrhead = new generateRows(m, rows, x, y, rows * cols - lenght * (threadsCount - 1), i);
            if (cols - x > lenght) {
                x += lenght;
            } else {
                times = (int) Math.ceil((double) (lenght - cols + x) / cols);
                y += times;
                x = lenght - cols * (times - 1) - cols + x;
            }
        }
        try {
            if (threadsCount > 1) {
                secondTrhead.t.join();
            }
            firstTrhead.t.join();
        } catch (InterruptedException e) {

        }
        return m;
    }

    public static class generateRows implements Runnable {
        Thread t;
        int rows, x, y, lenght, currLenght = 0;
        double[][] m;
        Random random = new Random();

        generateRows(double m[][], int rows, int x, int y, int lenght, int threadNumber) {
            t = new Thread(this, "Thread №" + threadNumber);
            this.lenght = lenght;
            this.rows = rows;
            this.x = x;
            this.y = y;
            this.m = m;
            t.start();
        }

        public void run() {
            for (int i = y; i < rows; i++) {
                for (int j = x; j < m[i].length; j++) {
                    m[i][j] = randomValue(random);
                    currLenght++;
                    if (currLenght == lenght)
                        return;
                }
            }
        }
    }

}