package org.demo.documentation.fields.multifield.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity360TestDataLoadService {

    @Autowired
    MyEntity360Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.deleteAll();
        repository.save(new MyEntity360()
                .setCustomField("Test data")
                .setInformationField("Information data")
                .setCustomFieldMulti("Data multi")
                .setCustomFieldAdditionalMulti("Additional data multi")
                .setCustomFieldAdditional("Data hint")
        );
        repository.save(new MyEntity360()
                .setCustomField("Test data 2")
                .setInformationField("Information data 2")
                .setCustomFieldMulti("Data multi 2")
                .setCustomFieldAdditionalMulti("Additional data multi 2")
                .setCustomFieldAdditional("Data hint 2")
        );
    }

}