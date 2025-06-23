package org.demo.documentation.other.forceactive2.forproject;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4903TestDataLoadService {

    @Autowired
    MyEntity4903Repository repository;

    @Autowired
    MyEntity4903PickRepository repositoryPick;

    @Autowired
    MyEntity4903PickOCPRepository repositoryOCP;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.deleteAll();
        repositoryOCP.deleteAll();
        repositoryPick.deleteAll();

        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP1"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP2"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP3"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP4"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP5"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP6"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP7"));

        repositoryPick.save(new MyEntity4903Pick().setCustomField("FCPP1"));
        repositoryPick.save(new MyEntity4903Pick().setCustomField("FCPP2"));
        repositoryPick.save(new MyEntity4903Pick().setCustomField("FCPP3"));

        repository.save(new MyEntity4903().setCustomField("test data"));
    }

}