package org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5010TestDataLoadService {

    @Autowired
    MyEntity5010Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity5010().setCustomField(CustomFieldEnum.LOW));
    }

}