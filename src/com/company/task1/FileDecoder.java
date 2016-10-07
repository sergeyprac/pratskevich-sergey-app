package com.company.task1;

import java.io.IOException;

public interface FileDecoder{
    String decode(String inputFilePath) throws IOException;
}