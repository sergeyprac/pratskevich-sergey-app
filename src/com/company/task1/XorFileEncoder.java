package com.company.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XorFileEncoder implements FileEncoder {
    @Override
    public void encode(String inputFilePath, String outputFilePath) throws IOException {
        FileInputStream fin = new FileInputStream(inputFilePath);
        FileOutputStream fos = new FileOutputStream(outputFilePath);

        byte[] encoded = new byte[fin.available()];
        byte[] bytes;

        fin.read(encoded, 0, encoded.length);
        bytes = encoded.clone();

        for(int i = 1; i < bytes.length; i++)
            encoded[i] = (byte)(bytes[i] ^ encoded[i - 1]);

        fos.write(encoded, 0, encoded.length);
        fin.close();
        fos.close();
    }
}
