package org.demo;

import org.cxbox.core.config.properties.WidgetFieldsIdResolverProperties;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ConfigurationPropertiesScan("org.demo.conf")
@EnableConfigurationProperties({IntegrationConfiguration.class, WidgetFieldsIdResolverProperties.class})
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
