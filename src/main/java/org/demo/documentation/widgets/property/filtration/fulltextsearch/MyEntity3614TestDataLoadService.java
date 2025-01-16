package org.demo.documentation.widgets.property.filtration.fulltextsearch;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625Repository;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist.MyEntity3614Pick;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist.MyEntity3614PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3614TestDataLoadService {

    @Autowired
    MyEntity3614Repository repository;
    @Autowired
    MyEntity3625Repository repository3625;
    @Autowired
    MyEntity3614PickRepository repository3614Pick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3614().setCustomField("test data").setAddress("Moscow, Polevoy 1st, lane, 72").setFullName("Ivanov Ivan"));
        repository.save(new MyEntity3614().setCustomField("test data2").setAddress("Moscow, Polevoy 1st, lane, 72").setFullName("Michael V. Neal"));
        repository.save(new MyEntity3614().setAddress("Moscow, Dmitrov, st. Soviet, 18").setFullName("Michael V. Neal"));
        repository.save(new MyEntity3614().setCustomField("test data3").setFullName("Jared K. Moser"));
        repository.save(new MyEntity3614().setCustomField("test data").setAddress("Moscow, Dmitrov, st. Soviet, 14"));

        repository3625.save(new MyEntity3625().setCustomField("test data"));
        repository3625.save(new MyEntity3625().setCustomField("test data2"));
        repository3625.save(new MyEntity3625().setCustomField("test data3"));
        repository3625.save(new MyEntity3625().setCustomField("test data"));

        repository3614Pick.save(new MyEntity3614Pick().setCustomField("test data"));
        repository3614Pick.save(new MyEntity3614Pick().setCustomField("test data2"));
        repository3614Pick.save(new MyEntity3614Pick().setCustomField("test data3"));
        repository3614Pick.save(new MyEntity3614Pick().setCustomField("test data"));

    }

}