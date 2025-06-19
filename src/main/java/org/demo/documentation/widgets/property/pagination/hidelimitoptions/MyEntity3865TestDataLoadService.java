package org.demo.documentation.widgets.property.pagination.hidelimitoptions;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.list.MyEntity3865;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.list.MyEntity3865Repository;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865MultiRepository;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup.MyEntity3865Pick;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup.MyEntity3865PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3865TestDataLoadService {

    @Autowired
    MyEntity3865Repository repository;

    @Autowired
    MyEntity3865MultiRepository repositoryMulti;

    @Autowired
    MyEntity3865PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryMulti.deleteAll();
        repositoryPick.deleteAll();

        repository.save(new MyEntity3865().setCustomField("test data"));
        repository.save(new MyEntity3865().setCustomField("test data7"));
        repository.save(new MyEntity3865().setCustomField("test data3"));
        repository.save(new MyEntity3865().setCustomField("test data4"));
        repository.save(new MyEntity3865().setCustomField("test data5"));
        repository.save(new MyEntity3865().setCustomField("test data6"));
        repository.save(new MyEntity3865().setCustomField("test data7"));
        repository.save(new MyEntity3865().setCustomField("test data8"));
        repository.save(new MyEntity3865().setCustomField("test data9"));
        repository.save(new MyEntity3865().setCustomField("test data10"));

        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data7"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data3"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data4"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data5"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data6"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data7"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data8"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data9"));
        repositoryMulti.save(new MyEntity3865Multi().setCustomField("test data10"));

        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data7"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data3"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data4"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data5"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data6"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data7"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data8"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data9"));
        repositoryPick.save(new MyEntity3865Pick().setCustomField("test data10"));

    }

}