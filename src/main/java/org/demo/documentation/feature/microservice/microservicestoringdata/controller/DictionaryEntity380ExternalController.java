package org.demo.documentation.feature.microservice.microservicestoringdata.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.mapper.MyEntity380ExternalMapper;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.MyEntity380ExternalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/microservices/v1/dictionary")
public class DictionaryEntity380ExternalController {

	private final MyEntity380ExternalMapper mapper;

	private final MyEntity380ExternalRepository dataRepository;

	private final InternalAuthorizationService authzService;

	@GetMapping("/all")
	public ResponseEntity<List<MyExample380ExternalDTO>> getAll(
			@RequestParam(value = "type") String type) {
		authzService.loginAs(authzService.createAuthentication(VANILLA));
		return ResponseEntity.ok().body(dataRepository.findAllByType(type).stream().map(mapper::toDto).toList());
	}

	@GetMapping("/one")
	public ResponseEntity<Optional<MyExample380ExternalDTO>> getOne(
			@RequestParam(value = "type") String type,
			@RequestParam(value = "key") String key) {
		authzService.loginAs(authzService.createAuthentication(VANILLA));
		return ResponseEntity.ok().body(dataRepository.findAllByTypeAndKey(type, key).map(mapper::toDto));
	}

}