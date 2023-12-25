package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class MyEntity3101TestDataLoadService {

    @Autowired
    MyEntity3101Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3101().setCustomField(4L));
        repository.save(new MyEntity3101().setCustomField(8L));
        repository.save(new MyEntity3101().setCustomField(2L));
    }

}