package com.company.task1;

import com.company.task1.FileDecoder;
import com.company.task1.FileEncoder;

import java.io.IOException;

public class Main {

    static final String INPUT_FILE_PATH = "resources/input.txt";
    static final String OUTPUT_FILE_PATH = "resources/output.txt";

    public static void main(String[] args) throws IOException {

        FileEncoder encoder = new FileEncoder();
        encoder.endcode(INPUT_FILE_PATH, OUTPUT_FILE_PATH);


        FileDecoder decoder = new FileDecoder();
        String result = decoder.decode(OUTPUT_FILE_PATH);

        System.out.println(result);
    }
}
