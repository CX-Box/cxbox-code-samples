package org.demo.documentation.microservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.demo.documentation.microservice.conf.IntegrationConfiguration;
import org.demo.documentation.microservice.utils.IntegrationURLBuilder;
import org.demo.documentation.microservice.utils.RestResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyEntity3800Client {

	public static final String API_V_1_LOV = "";

	private final IntegrationConfiguration integrationConfig;

	private final RestTemplate restTemplate;

	private final IntegrationURLBuilder integrationURLBuilder;

	public ResponseEntity<RestResponsePage<MyEntity3800OutServiceDTO>> getAll(final BusinessComponent bc) {
		return restTemplate.exchange(
				integrationURLBuilder.getURLWithQueryParams(bc, integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV).build()
						.normalize().encode().toUriString(),
				GET, null, new ParameterizedTypeReference<>() {
				}
		);
	}

	public ResponseEntity<MyEntity3800OutServiceDTO> getOne(final Long id) {
		return restTemplate.exchange(
				fromUriString(integrationConfig.getMyentityDataServerUrl() + API_V_1_LOV + "/{id}").build().expand(id).normalize().encode()
						.toUriString(),
				GET, null, MyEntity3800OutServiceDTO.class
		);
	}


}
