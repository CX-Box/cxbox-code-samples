package org.demo.documentation.feature.microservice.microservicestoringdata.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.transaction.Transactional;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.mapper.MyEntity3900Mapper;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.MyEntity3900Repository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3900;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3900_;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/microservices/v1/myentity3900")
public class ExistingMicroserviceStoringDataController {

    private final MyEntity3900Mapper mapper;

    private final MyEntity3900Repository data3900Repository;

    private final InternalAuthorizationService authzService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        data3900Repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<MyExample3900DTO> update(@RequestBody final MyExample3900DTO request) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        if (request.getId() == null) {
            throw new IllegalArgumentException("Id mustn't be null for update process");
        }
        return ResponseEntity.ok().body(mapper.toDto(mapper.updateEntityByDto(
                data3900Repository.findById(Long.valueOf(request.getId())).orElseThrow(),
                request
        )));
    }

    @PostMapping
    public ResponseEntity<MyExample3900DTO> create(@RequestBody final MyExample3900DTO request) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        if (request.getId() != null) {
            throw new IllegalArgumentException("Id must be null for creation process");
        }
        mapper.newEntityByDto(null, request);
        return ResponseEntity.ok().body(mapper.toDto(data3900Repository.save(mapper.newEntityByDto(null, request))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyExample3900DTO> getOne(@PathVariable final Long id) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        return ResponseEntity.ok().body(data3900Repository.findById(id).map(mapper::toDto).orElse(null));
    }


    @GetMapping
    public ResponseEntity<Page<MyExample3900DTO>> getAll(
            @Parameter(in = ParameterIn.QUERY,
                    description = "Sets a maximum limit on the number of items or records that can be returned", example = "1")
            @RequestParam("number") String numberPage,
            @Parameter(in = ParameterIn.QUERY,
                    description = "Refers to the number of items or records displayed on a single page of a user interface", example = "5")
            @RequestParam("size") String sizePage,
            @Parameter(in = ParameterIn.QUERY,
                    description = "Criteria for filtering the data by field CustomField", example = "Test data1")
            @RequestParam(value = "filterCustomField", required = false) String filterCustomField,
            @Parameter(in = ParameterIn.QUERY,
                    description = "Sorting criteria in the format: property(asc|desc)", example = "desc")
            @RequestParam(value = "sortCustomField", required = false) String sortCustomField
    ) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));

        Pageable entityPageable = getEntityPageable(numberPage, sizePage, sortCustomField);


        Specification<MyEntity3900> specification = (root, query, cb) -> cb.and();
        if (filterCustomField != null) {
            specification = (root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get(MyEntity3900_.customField.getName()), "%" + filterCustomField + "%");
        }

        return ResponseEntity.ok().body(data3900Repository.findAll(specification, entityPageable).map(mapper::toDto));
    }

    private Pageable getEntityPageable(String numberPage, String sizePage, String sortCustomField) {
        Sort.Order entityOrderList;
        if (sortCustomField == null) {
            entityOrderList = new Sort.Order(Sort.Direction.DESC, "id");
        } else {
            entityOrderList = new Sort.Order(
                    sortCustomField.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC,
                    MyEntity3900_.customField.getName());
        }
        return PageRequest.of(Integer.parseInt(numberPage) - 1, Integer.parseInt(sizePage), Sort.by(entityOrderList));
    }


}
