package com.rampatra.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Various ways to read a file in Java.
 *
 * @author rampatra
 * @since 2019-06-03
 */
public class ReadFile {

    private static Stream<String> readFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)); // use Files.readAllLines() to return a List<String> instead of Stream<String>
    }

    private static String readFile(Path filePath) throws IOException {
        Stream<String> lines = Files.lines(filePath);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }

    private static List<String> readLargeFile(Path filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            List<String> result = new ArrayList<>();
            for (; ; ) {
                String line = reader.readLine();
                if (line == null)
                    break;
                result.add(line);
            }
            return result;
        }
    }

    private static String readFileOldWay(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder builder = new StringBuilder();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                builder.append(currentLine);
                builder.append("\n");
                currentLine = reader.readLine();
            }
            // reader.close(); not required as try-with-resources is used

            return builder.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        readFile("src/main/java/com/rampatra/misc/reverseandadd.txt").forEach(System.out::println);
        System.out.println("==================");
        System.out.println(readFile(Paths.get("src/main/java/com/rampatra/misc/reverseandadd.txt")));
        System.out.println("==================");
        System.out.println(readLargeFile(Paths.get("src/main/java/com/rampatra/misc/reverseandadd.txt")));
        System.out.println("==================");
        System.out.println(readFileOldWay("src/main/java/com/rampatra/misc/reverseandadd.txt"));
    }
}
