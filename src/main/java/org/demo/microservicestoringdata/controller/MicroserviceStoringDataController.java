package org.demo.microservicestoringdata.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.microservicestoringdata.mapper.MyEntity3900Mapper;
import org.demo.microservicestoringdata.repository.MyEntity3900Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;



@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/v1/myentity3900")
public class MicroserviceStoringDataController {

	private final MyEntity3900Mapper mapper;

	private final MyEntity3900Repository data3900Repository;

	private final InternalAuthorizationService authzService;


	@GetMapping("/{id}")
	public ResponseEntity<MyExample3900DTO> getOne(@PathVariable final Long id) {
		authzService.loginAs(authzService.createAuthentication(VANILLA));
		return ResponseEntity.ok().body(data3900Repository.findById(id).map(mapper::toDto).orElse(null));
	}

}
