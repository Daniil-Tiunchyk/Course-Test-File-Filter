package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class OutputFileWriter {
    private final Map<DataType, BufferedWriter> writers = new HashMap<>();
    private final Options options;

    public OutputFileWriter(Options options) {
        this.options = options;
    }

    public void write(DataType type, String value) throws IOException {
        BufferedWriter writer = writers.computeIfAbsent(type, this::createWriter);
        writer.write(value);
        writer.newLine();
    }

    private BufferedWriter createWriter(DataType type) {
        try {
            String fileName = options.getFileName(type);
            return new BufferedWriter(new FileWriter(fileName, options.append));
        } catch (IOException e) {
            throw new RuntimeException("Error creating writer for type " + type, e);
        }
    }

    public void close() {
        for (BufferedWriter writer : writers.values()) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Error closing writer: " + e.getMessage());
            }
        }
    }
}
