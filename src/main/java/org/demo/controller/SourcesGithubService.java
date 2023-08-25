package org.demo.controller;

import static org.demo.controller.SourcesController.SOURCES_ORIGINAL_PATH_PREFIX;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class SourcesGithubService {

	final SourcesConfig sourcesConfig;

	final RestTemplate proxyRestTemplate;

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
