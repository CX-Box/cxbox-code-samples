package org.demo.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nimbusds.oauth2.sdk.Response;
import lombok.RequiredArgsConstructor;
import net.lingala.zip4j.ZipFile;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.cxbox.core.util.ResponseBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.demo.controller.SourcesGithubService.*;

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

    @GetMapping("/" + GIHUBCODE_PATH)
    public void cleanGitHubCodeArchive(HttpServletRequest request,HttpServletResponse response) {
        try {
            String fName = TEMP_FOLDER + java.util.UUID.randomUUID();
            service.cleanGitHubCodeArchive(request,fName);
            Path tmpdirPath = Paths.get(TEMP_DIRECTORY + OUT_ZIP_NAME);
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=" + OUT_ZIP_NAME);
            response.setStatus(200);

            byte[] zipBytes = java.nio.file.Files.readAllBytes(tmpdirPath);
            ServletOutputStream op = response.getOutputStream();
            op.write(zipBytes);
            op.flush();

            new File(TEMP_DIRECTORY + OUT_ZIP_NAME).delete();
            new File(TEMP_DIRECTORY + IN_ZIP_NAME).delete();
            FileUtils.deleteDirectory(new File(TEMP_DIRECTORY + fName));
        } catch (IOException ioe) {
            response.setStatus(500);
            ioe.printStackTrace();
        }
    }

}
