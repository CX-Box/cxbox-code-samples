package org.demo.documentation.microservice.microservicestoringdata.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.microservice.microservicestoringdata.core.querylang.common.FilterParameters;
import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample3910DTO;
import org.demo.documentation.microservice.microservicestoringdata.mapper.MyEntity3910Mapper;
import org.demo.documentation.microservice.microservicestoringdata.repository.MyEntity3910Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public ResponseEntity<Page<MyExample3910DTO>> getAll(final Pageable pageable,
                                                         final FilterParameters<MyExample3910DTO> parameters) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        final var specification = data3910Repository.getSpecification(parameters, MyExample3910DTO.class);
        final var entityPageable = data3910Repository.getEntityPageable(pageable, MyExample3910DTO.class);
        return ResponseEntity.ok().body(data3910Repository.findAll(specification, entityPageable).map(mapper::toDto));
    }

}
