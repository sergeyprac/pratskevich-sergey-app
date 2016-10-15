package com.company.task1;

import java.io.*;

public class XorFileEncoder implements FileEncoder {

    @Override
    public void encode(String inputFilePath, String outputFilePath) throws IOException {
        File input = new File(inputFilePath);
        FileInputStream in = new FileInputStream(input);
        FileOutputStream os = new FileOutputStream(outputFilePath);
        BufferedInputStream fin = new BufferedInputStream(in);
        BufferedOutputStream fos = new BufferedOutputStream(os);
        byte prevByte, nextByte;

        if(input.length() > 0) {
            prevByte = (byte)fin.read();
            fos.write(prevByte);
            while ((nextByte = (byte) fin.read()) != -1) {
                fos.write(nextByte ^ prevByte);
                prevByte = (byte) (nextByte ^ prevByte);
            }
        }
        fin.close();
        fos.close();
    }
}
