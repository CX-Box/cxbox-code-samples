package org.demo.microservicestoringdata.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.demo.microservicestoringdata.repository.entity.MyEntity3900_;
import org.demo.microservicestoringdata.repository.entity.MyEntity3900;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.microservicestoringdata.mapper.MyEntity3900Mapper;
import org.demo.microservicestoringdata.repository.MyEntity3900Repository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/microservice/v1/myentity3900")
public class ExistingMicroserviceStoringDataController {

    private final MyEntity3900Mapper mapper;

    private final MyEntity3900Repository data3900Repository;

    private final InternalAuthorizationService authzService;


    @GetMapping("/{id}")
    public ResponseEntity<MyExample3900DTO> getOne(@PathVariable final Long id) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        return ResponseEntity.ok().body(data3900Repository.findById(id).map(mapper::toDto).orElse(null));
    }

    @GetMapping
    public ResponseEntity<Page<MyExample3900DTO>> getAll(@RequestParam("number") String numberPage,
                                                         @RequestParam("size") String sizePage,
                                                         HttpServletRequest request
    ) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        String sortValue = null;
        Optional<Map.Entry<String, String[]>> sort = request.getParameterMap().entrySet().stream().filter(f -> f.getKey().contains("sortCustomField")).findFirst();
        if (sort.isPresent()) {
            sortValue = String.join("", sort.get().getValue());

        }

        Pageable entityPageable = getEntityPageable(numberPage, sizePage, sortValue);


        Optional<Map.Entry<String, String[]>> filter = request.getParameterMap().entrySet().stream().filter(f -> f.getKey().contains("filterCustomField")).findFirst();
        Specification<MyEntity3900> specification = (root, query, cb) -> cb.and();
        if (filter.isPresent()) {
            String filterValue = String.join("", filter.get().getValue());
            specification = (root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get(MyEntity3900_.customField.getName()), "%" + filterValue + "%");
        }

        return ResponseEntity.ok().body(data3900Repository.findAll(specification, entityPageable).map(mapper::toDto));
    }

    public Pageable getEntityPageable(String numberPage, String sizePage, String sortCustomField) {
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
