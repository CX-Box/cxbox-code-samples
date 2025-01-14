package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3062TestDataLoadService {

    @Autowired
    MyEntity3062MultiRepository repositoryMulti;

    @Autowired
    MyEntity3062Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryMulti.save(new MyEntity3062Multi().setCustomField("test data multi"));
        repositoryMulti.save(new MyEntity3062Multi().setCustomField("test data multi2"));
        repositoryMulti.save(new MyEntity3062Multi().setCustomField("test data multi3"));
        repositoryMulti.save(new MyEntity3062Multi().setCustomField("test data multi4"));
        repositoryMulti.save(new MyEntity3062Multi().setCustomField("test data multi5"));
        repository.save(new MyEntity3062().setCustomFieldText("test data"));
    }

}