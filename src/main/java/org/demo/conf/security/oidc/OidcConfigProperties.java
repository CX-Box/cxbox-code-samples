package org.demo.conf.security.oidc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Setter
@Getter
@ConfigurationProperties(prefix = "app")
public class OidcConfigProperties {

	private Map<String, Object> oidc;

}
