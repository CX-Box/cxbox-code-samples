package org.demo.documentation.widgets.property.excel.filtration;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3138TestDataLoadService {

    @Autowired
    MyEntity3138Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3138().setCustomFieldInput("test data 2").setCustomFieldNumber(2L).setCustomFieldDateTime(LocalDateTime.now()).setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included."));
        repository.save(new MyEntity3138().setCustomFieldInput("test data 3").setCustomFieldNumber(3L).setCustomFieldDateTime(LocalDateTime.now()).setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included."));
        repository.save(new MyEntity3138().setCustomFieldInput("test data").setCustomFieldNumber(3L).setCustomFieldDateTime(LocalDateTime.now()).setCustomFieldText("The rest of the characters would be provided in quantities appropriate for the distribution of letters in that language."));
        repository.save(new MyEntity3138().setCustomFieldInput("test data").setCustomFieldNumber(2L).setCustomFieldDateTime(LocalDateTime.now()).setCustomFieldText("The rest of the characters would be provided in quantities appropriate for the distribution of letters in that language."));
        repository.save(new MyEntity3138().setCustomFieldInput("test data").setCustomFieldNumber(0L).setCustomFieldDateTime(LocalDateTime.now()));
        repository.save(new MyEntity3138().setCustomFieldInput("test data").setCustomFieldNumber(0L).setCustomFieldDateTime(LocalDateTime.now()).setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included."));
    }

}