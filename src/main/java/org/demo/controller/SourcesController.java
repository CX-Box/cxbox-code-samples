package org.demo.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SourcesController.CONTROLLER_PATH)
@RequiredArgsConstructor
public class SourcesController {

	public static final String CONTROLLER_PATH = "/api/v1/";

	public static final String SOURCES_PATH = "sources";

	public static final String SOURCES_ORIGINAL_PATH_PREFIX = CONTROLLER_PATH + SOURCES_PATH;

	private final SourcesGithubService service;

	@GetMapping("/" + SOURCES_PATH + "/**")
	public ResponseEntity<String> proxyToSrcStorage(HttpServletRequest request) {
		var sourceCode = service.getSourceCode(request);
		var body = service.cleanUpCode(sourceCode);
		return new ResponseEntity<>(body, sourceCode.getHeaders(), HttpStatus.OK);
	}



}
