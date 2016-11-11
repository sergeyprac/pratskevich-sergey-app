package com.company.task1;

import java.io.*;

public class XorFileDecoder implements FileDecoder {
    @Override
    public  String decode(String inputFilePath) throws IOException {

        File input = new File(inputFilePath);
        FileInputStream in = new FileInputStream(input);
        BufferedInputStream fin = new BufferedInputStream(in);
        String str = null;
        byte prevByte, nextByte;

        if(input.length() > 0) {
            byte[] decoded = new byte[(int) input.length()];
            decoded[0] = (byte) fin.read();
            prevByte = decoded[0];
            nextByte = (byte) fin.read();
            for (int i = 1; i < decoded.length; i++) {
                decoded[i] = (byte) (nextByte ^ prevByte);
                prevByte = nextByte;
                nextByte = (byte) fin.read();
            }
            str = new String(decoded);
        }
        fin.close();
        return str;
    }
}
