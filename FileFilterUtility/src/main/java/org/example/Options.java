package org.example;

import java.io.File;
import java.util.List;

public class Options {
    String outputPath = ".";
    String prefix = "";
    boolean append = false;
    boolean shortStatistics = false;
    boolean fullStatistics = false;
    List<String> files;

    public String getFileName(DataType type) {
        String fileName = prefix + type.toString().toLowerCase() + "s.txt";
        return outputPath + File.separator + fileName;
    }
}
