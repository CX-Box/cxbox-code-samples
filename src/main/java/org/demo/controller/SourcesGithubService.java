package org.demo.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.demo.services.GitHubApi;
import org.demo.services.FilesService;
import org.jetbrains.annotations.Nullable;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static org.demo.controller.SourcesController.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class SourcesGithubService {

    final SourcesConfig sourcesConfig;

    final RestTemplate proxyRestTemplate;

    private final FilesService filesService;


    private final GitHubApi zitHubApi;
    public static final String IN_ZIP_NAME = "in_sample.zip";
    public static final String OUT_ZIP_NAME = "out_sample.zip";

    @SneakyThrows
    public ResponseEntity<String> getSourceCode(HttpServletRequest request) {
        String requestUrl = request.getRequestURI()
                .replaceFirst(SOURCES_ORIGINAL_PATH_PREFIX, sourcesConfig.getTargetPathPrefix());
        URI uri = new URI(sourcesConfig.getScheme(), null, sourcesConfig.getTargetDomain(), -1, null, null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .path(requestUrl)
                .query(request.getQueryString())
                .build(true)
                .toUri();
        try {
            return proxyRestTemplate.getForEntity(uri, String.class);
        } catch (HttpStatusCodeException e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }

    }

    @SneakyThrows
    public void cleanGitHubCodeArchive(String fName) {

        //get the archive from gitHub
        ResponseEntity<Resource> response = zitHubApi.callZipball();
        //unzipped the archive from gitHub and clean code
        Resource zipFileContent = response.getBody();

        Long currentDate;
        currentDate = new Date().getTime();
        filesService.saveFile(zipFileContent, TEMP_DIRECTORY + IN_ZIP_NAME);
        System.out.println("End saveFile" + (currentDate - new Date().getTime()));

        currentDate = new Date().getTime();
        filesService.unzip(TEMP_DIRECTORY + IN_ZIP_NAME, TEMP_DIRECTORY + fName + OUT_ZIP_NAME);
        System.out.println("End unzip" + (currentDate - new Date().getTime()));

        currentDate = new Date().getTime();
        walkFileTree(fName);
        System.out.println("End walkFileTree" + (currentDate - new Date().getTime()));
        //System.out.println("Start toUnzippedAndClean" + java.time.LocalDateTime.now());
        // HashMap<String, byte[]> map = toUnzippedAndClean(zipFileContent, stringJava1 -> cleanUpString(stringJava1));
        // System.out.println("End toUnzippedAndClean" + java.time.LocalDateTime.now());
        currentDate = new Date().getTime();
        List<FileHeader> fileHeaders = new ZipFile(TEMP_DIRECTORY + IN_ZIP_NAME).getFileHeaders();
        String rootFolder = fileHeaders.get(0).getFileName();

        filesService.zip(TEMP_DIRECTORY + fName + "/" + rootFolder, TEMP_DIRECTORY);
        System.out.println("End zip" + (currentDate - new Date().getTime()));

    }

    private void walkFileTree(String folderName) throws IOException {
        Path tmpdirPath = Paths.get(TEMP_DIRECTORY + folderName);
        java.nio.file.Files.walkFileTree(
                tmpdirPath,
                new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                        if (path.toString().contains("documentation")) {
                            String content = FileUtils.readFileToString(new File(path.toString()));
                            String cleanFile = cleanUpString(content);
                            Files.writeString(path, cleanFile);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    private HashMap<String, byte[]> toUnzippedAndClean(Resource zipFileContent, Function<String, String> process) throws IOException {
        HashMap<String, byte[]> map = new HashMap<>();
        if (zipFileContent != null) {
            try (ZipInputStream zipInputStream = new ZipInputStream(zipFileContent.getInputStream())) {
                ZipEntry zipEntry = null;
                byte[] buff = new byte[4096];
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                        while (zipInputStream.available() > 0) {
                            int byteLength = 0;
                            while ((byteLength = zipInputStream.read(buff)) > 0) {
                                byteArrayOutputStream.write(buff, 0, byteLength);
                            }
                        }
                        if (zipEntry.getName().contains("documentation") && !zipEntry.isDirectory()) {

                            String stringJava = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                            String cleanText = process.apply(stringJava);
                            map.put(zipEntry.getName(), cleanText.getBytes(StandardCharsets.UTF_8));
                        }
                    }
                }
            }
        }
        return map;
    }


    public void extractWithZipInputStream(File zipFile) throws IOException {
        net.lingala.zip4j.model.LocalFileHeader localFileHeader;
        int readLen;
        byte[] readBuffer = new byte[4096];

        InputStream inputStream = new FileInputStream(zipFile);
        try (net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream = new net.lingala.zip4j.io.inputstream.ZipInputStream(inputStream)) {
            while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
                File extractedFile = new File(localFileHeader.getFileName());
                try (OutputStream outputStream = new FileOutputStream(extractedFile)) {
                    while ((readLen = zipInputStream.read(readBuffer)) != -1) {
                        outputStream.write(readBuffer, 0, readLen);
                    }
                }
            }
        }
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
                            .map(SourcesGithubService::removeNumbersPrecededByLetters)
                            .collect(Collectors.toList());
                }
            }
        } catch (Exception e) {
            new Exception(e.getMessage());
        }
        return resultLines.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }


    @Nullable
    public String cleanUpCode(ResponseEntity<String> sourceCode) {
        return Optional.ofNullable(sourceCode.getBody())
                .map(src -> {
                            List<String> filteredLines = src.lines()
                                    .filter(line -> !line.trim().startsWith("import "))
                                    .filter(line -> !line.trim().startsWith("package "))
                                    .map(SourcesGithubService::removeNumbersPrecededByLetters)
                                    .collect(Collectors.toList());
                            List<String> resultLines = filterFirstEmptyLines(filteredLines);
                            return resultLines.stream()
                                    .collect(Collectors.joining(System.lineSeparator()));
                        }
                ).orElse(null);
    }


    @NonNull
    private static List<String> filterFirstEmptyLines(@NonNull List<String> filteredLines) {
        List<String> resultLines = new ArrayList<>();
        for (String line : filteredLines) {
            if (line.trim().isEmpty() && resultLines.isEmpty()) {
                continue;
            }
            resultLines.add(line);
        }
        return resultLines;
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
