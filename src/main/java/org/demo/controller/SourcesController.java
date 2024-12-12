package org.demo.controller;

import jakarta.servlet.ServletOutputStream;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static org.demo.controller.SourcesGithubService.*;

@Slf4j
@RestController
@RequestMapping(SourcesController.CONTROLLER_PATH)
@RequiredArgsConstructor
public class SourcesController {

    public static final String CONTROLLER_PATH = "/api/v1/";
    public static final String SOURCES_PATH = "sources";
    public static final String GIHUBCODE_PATH = "githubcode";
    public static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
    public static final String TEMP_FOLDER = "myFolder";
    public static final String SOURCES_ORIGINAL_PATH_PREFIX = CONTROLLER_PATH + SOURCES_PATH;
    public static final String GIHUBCOD_ORIGINAL_PATH_PREFIX = CONTROLLER_PATH + GIHUBCODE_PATH;

    private final SourcesGithubService service;

    @GetMapping("/" + SOURCES_PATH + "/**")
    public ResponseEntity<String> proxyToSrcStorage(HttpServletRequest request) {
        var sourceCode = service.getSourceCode(request);
        var body = service.cleanUpCode(sourceCode);
        return new ResponseEntity<>(body, sourceCode.getHeaders(), HttpStatus.OK);
    }

    //GIHUBCODE_PATH/NAME_BRANCH
    @GetMapping("/" + GIHUBCODE_PATH + "/**")
    public void cleanGitHubCodeArchive(HttpServletRequest request, HttpServletResponse response)  {
        try {
            Path tmpdirOutPath = Paths.get(TEMP_DIRECTORY + OUT_ZIP_NAME);
            String fName = TEMP_FOLDER + java.util.UUID.randomUUID();

            service.cleanGitHubCodeArchive(request, fName);

            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=" + OUT_ZIP_NAME);
            response.setStatus(200);

            byte[] zipBytes = java.nio.file.Files.readAllBytes(tmpdirOutPath);
            ServletOutputStream op = response.getOutputStream();
            op.write(zipBytes);
            op.flush();

            cleanUpFile(tmpdirOutPath);
            cleanUpFile(Paths.get(TEMP_DIRECTORY + IN_ZIP_NAME));
            FileUtils.deleteDirectory(new File(TEMP_DIRECTORY + fName));

        } catch (IOException ioe) {
            response.setStatus(500);
            log.error("Ops!", ioe);
        }
    }

    public void cleanUpFile(Path path) throws IOException {
        Files.delete(path);
    }
}
