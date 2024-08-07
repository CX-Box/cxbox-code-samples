package org.demo.documentation.feature.microservice.microservicestoringdata.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {

	@Bean
	@Primary
	public RestTemplate restTemplate(final RestTemplateBuilder builder) {
		return builder
				.build();
	}

}
