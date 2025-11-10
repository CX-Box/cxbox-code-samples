package org.demo.documentation.other.ingosexample;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6001TestDataLoadService {

    @Autowired
    MyEntity6001Repository repository;

    @Autowired
    ApplicationRepository repositoryApp;
    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity6001().setCustomField("test data"));
        repositoryApp.save(new ApplicationEntity().setName("Name1"));
        repositoryApp.save(new ApplicationEntity().setName("Name2"));
    }

}