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


import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;


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
    public static final String DOCUMENTATION_PATH = "/src/main/java/org/demo";

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
    public void cleanGitHubCodeArchive(HttpServletRequest request, String fName) {
        String requestBranch = request.getRequestURI().replace(GIHUBCOD_ORIGINAL_PATH_PREFIX, "");
        String branch = "";
        if (!"".equals(requestBranch)) {
            branch = requestBranch;
        }

        //get the archive from gitHub
        ResponseEntity<Resource> response = zitHubApi.callZipball(branch);
        //unzipped the archive from gitHub and clean code
        Resource zipFileContent = response.getBody();

        filesService.saveFile(zipFileContent, TEMP_DIRECTORY + IN_ZIP_NAME);

        filesService.unzip(TEMP_DIRECTORY + IN_ZIP_NAME, TEMP_DIRECTORY + fName);

        walkFileTree(fName);

        List<FileHeader> fileHeaders = new ZipFile(TEMP_DIRECTORY + IN_ZIP_NAME).getFileHeaders();
        String rootFolder = fileHeaders.get(0).getFileName();
        filesService.zip(TEMP_DIRECTORY + fName + "/" + rootFolder + DOCUMENTATION_PATH, TEMP_DIRECTORY + OUT_ZIP_NAME);

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

    @NonNull
    public String cleanUpString(String stringJava) throws IOException {
        List<String> resultLines = new ArrayList<>();
        try (BufferedReader result = new BufferedReader(new StringReader(stringJava))) {
            while ((result.readLine()) != null) {
                resultLines = stringJava.lines()
                        .filter(l -> !l.trim().startsWith("import "))
                        .filter(l -> !l.trim().startsWith("package "))
                        .map(SourcesGithubService::removeNumbersPrecededByLetters)
                        .collect(Collectors.toList());
            }
        }
        return resultLines.stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }


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
