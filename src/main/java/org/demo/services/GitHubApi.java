package org.demo.services;

import lombok.RequiredArgsConstructor;
import org.demo.controller.SourcesConfig;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class GitHubApi {

	private final SourcesConfig sourcesConfig;

	private final RestTemplate proxyRestTemplate;

	public ResponseEntity<Resource> callZipball(String branch) throws URISyntaxException {
		String requestUrl = sourcesConfig.getGihubApi() + sourcesConfig.getTargetPathPrefix() + "/zipball" + "/" + branch;
		URI uri = new URI(sourcesConfig.getScheme(), null, requestUrl, -1, null, null, null);
		uri = UriComponentsBuilder.fromUri(uri)
				.build(true)
				.toUri();
		return proxyRestTemplate.exchange(uri, HttpMethod.GET, new HttpEntity(null), Resource.class);
	}
}
