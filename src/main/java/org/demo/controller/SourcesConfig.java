package org.demo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sources")
public class SourcesConfig {

	private String targetDomain = "raw.githubusercontent.com";

	private String scheme = "https";

	private String targetPathPrefix = "/CX-Box/cxbox-code-samples";

	private String gihubApi = "api.github.com/repos";


}