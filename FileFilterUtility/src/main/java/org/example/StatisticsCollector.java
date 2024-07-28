package org.example;

import java.util.*;

public class StatisticsCollector {
    private final Map<DataType, List<String>> data = new HashMap<>();
    private final Options options;

    public StatisticsCollector(Options options) {
        this.options = options;
    }

    public void collect(DataType type, String value) {
        data.computeIfAbsent(type, k -> new ArrayList<>()).add(value);
    }

    public void print() {
        for (Map.Entry<DataType, List<String>> entry : data.entrySet()) {
            DataType type = entry.getKey();
            List<String> values = entry.getValue();

            if (type == DataType.INTEGER) {
                printIntegerStatistics(values);
            } else if (type == DataType.FLOAT) {
                printFloatStatistics(values);
            } else {
                printStringStatistics(values);
            }
        }
    }

    private void printIntegerStatistics(List<String> values) {
        List<Integer> ints = new ArrayList<>();
        for (String value : values) {
            ints.add(Integer.parseInt(value));
        }

        int min = Collections.min(ints);
        int max = Collections.max(ints);
        int sum = ints.stream().mapToInt(Integer::intValue).sum();
        double avg = ints.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println(options.prefix + "integers.txt statistics: elements = " + ints.size());
        if (options.fullStatistics) {
            System.out.println("min = " + min + ", max = " + max + ", sum = " + sum + ", average = " + avg);
        }
    }

    private void printFloatStatistics(List<String> values) {
        List<Double> floats = new ArrayList<>();
        for (String value : values) {
            floats.add(Double.parseDouble(value));
        }

        double min = Collections.min(floats);
        double max = Collections.max(floats);
        double sum = floats.stream().mapToDouble(Double::doubleValue).sum();
        double avg = floats.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println(options.prefix + "floats.txt statistics: elements = " + floats.size());
        if (options.fullStatistics) {
            System.out.println("min = " + min + ", max = " + max + ", sum = " + sum + ", average = " + avg);
        }
    }

    private void printStringStatistics(List<String> values) {
        int minLength = values.stream().mapToInt(String::length).min().orElse(0);
        int maxLength = values.stream().mapToInt(String::length).max().orElse(0);

        System.out.println(options.prefix + "strings.txt statistics: elements = " + values.size());
        if (options.fullStatistics) {
            System.out.println("shortest length = " + minLength + ", longest length = " + maxLength);
        }
    }
}
