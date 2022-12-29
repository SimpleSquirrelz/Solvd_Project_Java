package com.solvd.taxi.tasks.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
            String input = FileUtils.readFileToString(new File("src/main/resources/file/input.txt"), StandardCharsets.UTF_8)
                    .replaceAll("[0-9\\]+'\"()\\[!?.,;-]", "")
                    .replaceAll("\n", " ")
                    .toLowerCase();
            FileUtils.write(new File("src/main/resources/file/output.txt"),
            Arrays.stream(input.split(" ")).distinct()
                    .map(word -> (String.format("%4s", StringUtils.countMatches(input, word)).replace(' ', '0') + " duplicates of: " + word))
                    .sorted().collect(Collectors.joining("\n")), Charset.defaultCharset());
    }
}
