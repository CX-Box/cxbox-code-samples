package org.demo.documentation.feature.microservice.microservicestoringdata.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.controller.param.QueryParameters;
import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.common.FilterParameters;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample3910DTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.mapper.MyEntity3910Mapper;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.MyEntity3910Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/microservices/v1/myentity3910")
public class CreateMicroserviceStoringDataController {

	private final MyEntity3910Mapper mapper;

	private final MyEntity3910Repository data3910Repository;

	private final InternalAuthorizationService authzService;


	@GetMapping("/{id}")
	public ResponseEntity<MyExample3910DTO> getOne(@PathVariable final Long id) {
		authzService.loginAs(authzService.createAuthentication(VANILLA));
		return ResponseEntity.ok().body(data3910Repository.findById(id).map(mapper::toDto).orElse(null));
	}

	@GetMapping
	public ResponseEntity<Page<MyExample3910DTO>> getAll(
			@Parameter(in = ParameterIn.QUERY,
					description = "Sets a maximum limit on the number of items or records that can be returned", example = "1")
			@RequestParam("_page") String numberPage,
			@Parameter(in = ParameterIn.QUERY,
					description = "Refers to the number of items or records displayed on a single page of a user interface", example = "5")
			@RequestParam("_limit") String sizePage,
			final FilterParameters<MyExample3910DTO> parameters, QueryParameters queryParameter) {
		authzService.loginAs(authzService.createAuthentication(VANILLA));
		Pageable pageable = getEntityPageable(numberPage, sizePage);
		final var specification = data3910Repository.getSpecification(parameters, MyExample3910DTO.class);
		final var entityPageable = data3910Repository.getEntityPageable(pageable, MyExample3910DTO.class);
		return ResponseEntity.ok().body(data3910Repository.findAll(specification, entityPageable).map(mapper::toDto));
	}

	private Pageable getEntityPageable(String numberPage, String sizePage) {
		Sort.Order entityOrderList = new Sort.Order(Sort.Direction.DESC, "id");
		return PageRequest.of(Integer.parseInt(numberPage) - 1, Integer.parseInt(sizePage), Sort.by(entityOrderList));
	}
}
