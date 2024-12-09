package org.demo.documentation.feature.microservice.microservicestoringdata.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.mapper.MyEntity380Mapper;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.MyEntity380Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;
@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/microservices/v1/myentity380")
public class DictionaryEntity380ExternalController {

    private final MyEntity380Mapper mapper;

    private final MyEntity380Repository dataRepository;

    private final InternalAuthorizationService authzService;

    @GetMapping
    public ResponseEntity<MyExample380ExternalDTO> getTypeAndKey(
            @RequestParam("type") String type,
            @RequestParam("key") String key
    ) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        return ResponseEntity.ok().body(dataRepository.findAllByTypeAndKey(type, key).map(mapper::toDto).orElse(null));
    }
    @GetMapping
    public ResponseEntity<List<MyExample380ExternalDTO>> getType(
            @RequestParam("type") String type
    ) {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        return ResponseEntity.ok().body(dataRepository.findAllByTypeAndKey(type, type).map(mapper::toDto).stream().toList()jr);
    }

}