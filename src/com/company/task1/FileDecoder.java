package com.company.task1;


import java.io.*;


public class FileDecoder {

    String decode(String inputFilePath) throws IOException {

        FileInputStream fin = new FileInputStream(inputFilePath);

        byte[] encoded = new byte[fin.available()];
        byte[] decoded = new byte[fin.available()];

        fin.read(encoded, 0, encoded.length);

        decoded[0] = encoded[0];

        for (int i = 1; i < encoded.length; i++)
            decoded[i] = (byte) (encoded[i] ^ encoded[i - 1]);
        String str = new String(decoded);
        fin.close();
        return str;
    }
}
