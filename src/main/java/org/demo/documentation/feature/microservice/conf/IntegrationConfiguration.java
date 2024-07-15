package org.demo.documentation.feature.microservice.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties("app.integrations")
public class IntegrationConfiguration {

	private String myentityCreateMicroservicesDataServerUrl;
	private String myentityExistingMicroservicesDataServerUrl;
	private String myentityGetStartedMicroservicesDataServerUrl;
}
