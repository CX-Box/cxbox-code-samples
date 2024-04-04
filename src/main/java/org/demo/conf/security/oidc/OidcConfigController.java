package org.demo.conf.security.oidc;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class OidcConfigController {

	private final OidcConfigProperties oidcConfigProperties;

	@GetMapping("/auth/oidc.json")
	public ResponseEntity<Map<String, Object>> get() {
		return ResponseEntity.ok(oidcConfigProperties.getOidc());
	}

}
