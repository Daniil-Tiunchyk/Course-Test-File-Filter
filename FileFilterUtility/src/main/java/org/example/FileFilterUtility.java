package org.example;

import java.io.*;
import java.util.*;

public class FileFilterUtility {

    public static void main(String[] args) {
        try {
            Options options = parseOptions(args);
            processFiles(options);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Options parseOptions(String[] args) {
        Options options = new Options();
        List<String> files = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o" -> options.outputPath = args[++i];
                case "-p" -> options.prefix = args[++i];
                case "-a" -> options.append = true;
                case "-s" -> options.shortStatistics = true;
                case "-f" -> options.fullStatistics = true;
                default -> files.add(args[i]);
            }
        }

        options.files = files;
        return options;
    }

    private static void processFiles(Options options) throws IOException {
        OutputFileWriter writer = new OutputFileWriter(options);
        StatisticsCollector stats = new StatisticsCollector(options);

        for (String file : options.files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    DataType type = DataType.determineType(line);
                    writer.write(type, line);
                    stats.collect(type, line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file " + file + ": " + e.getMessage());
            }
        }

        writer.close();
        stats.print();
    }
}
