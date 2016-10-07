package com.company.task1;

import java.io.*;

public interface FileEncoder{
    void encode (String inputFilePath, String outputFilePath) throws IOException;
}
