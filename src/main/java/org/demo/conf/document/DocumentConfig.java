package org.demo.conf.document;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "document")
public class DocumentConfig {

	private Boolean forceActiveEnabled;

}