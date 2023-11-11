package org.demo.controller;

import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (path.toString().contains("documentation")) {
            String content = FileUtils.readFileToString(new File(path.toString()));
            String cleanFile = cleanUpString(content);
            Files.writeString(path, cleanFile);
        }
        return FileVisitResult.CONTINUE;
    }

    @Nullable
    public String cleanUpString(String stringJava) {
        List<String> resultLines = new ArrayList<>();
        try {
            try (BufferedReader result = new BufferedReader(new StringReader(stringJava))) {
                while ((result.readLine()) != null) {
                    resultLines = stringJava.lines()
                            .filter(l -> !l.trim().startsWith("import "))
                            .filter(l -> !l.trim().startsWith("package "))
                            .map(MyFileVisitor::removeNumbersPrecededByLetters)
                            .collect(Collectors.toList());
                }
            }
        } catch (Exception e) {
            new Exception(e.getMessage());
        }
        return resultLines.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @NonNull
    private static String removeNumbersPrecededByLetters(@NonNull String line) {
        char[] chars = line.toCharArray();
        LinkedList<Character> characterList = new LinkedList<>();
        for (char origChar : chars) {
            if (Character.isDigit(origChar) && Character.isLetter(characterList.getLast())) {
                continue;
            }
            characterList.add(origChar);
        }
        char[] array = ArrayUtils.toPrimitive(characterList.toArray(new Character[0]));
        return new String(array);
    }

}