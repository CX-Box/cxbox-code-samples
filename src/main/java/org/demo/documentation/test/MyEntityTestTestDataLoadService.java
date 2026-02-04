package org.demo.documentation.test;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityTestTestDataLoadService {

    @Autowired
    EditLegalEntityRepository repository;

    @Autowired
    EditManagingAuthorityRepository repositoryChild;


    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryChild.deleteAll();
        EditLegalEntity parent =  new EditLegalEntity();
        parent.setNew(Boolean.TRUE);
        repository.save(parent);

    }

}