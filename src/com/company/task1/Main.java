package com.company.task1;

import java.io.IOException;

public class Main {

    static final String INPUT_FILE_PATH = "resources/input.txt";
    static final String OUTPUT_FILE_PATH = "resources/output.txt";

    public static void main(String[] args) throws IOException {

        XorFileEncoder encoder = new XorFileEncoder();
        encoder.encode(INPUT_FILE_PATH, OUTPUT_FILE_PATH);


        XorFileDecoder decoder = new XorFileDecoder();
        String result = decoder.decode(OUTPUT_FILE_PATH);

        System.out.println(result);
    }
}
