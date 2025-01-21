package org.demo.documentation.widgets.property.filtration.filtergroup;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623Repository;
import org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist.MyEntity3630;
import org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist.MyEntity3630PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3616TestDataLoadService {

    @Autowired
    MyEntity3616Repository repository;

    @Autowired
    MyEntity3623Repository repository3623;

    @Autowired
    MyEntity3630PickRepository repository3630;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository3623.deleteAll();
        repository.save(new MyEntity3616().setCustomField("test data").setCustomFieldNew("test data new"));
        repository.save(new MyEntity3616().setCustomField("test data 2").setCustomFieldNew("test data new 2"));
        repository.save(new MyEntity3616().setCustomField("test data 3").setCustomFieldNew("test data new 3"));
        repository.save(new MyEntity3616().setCustomField("test data 4").setCustomFieldNew("test data new 4"));
        repository.save(new MyEntity3616().setCustomField("test data 5").setCustomFieldNew("test data new 5"));
        repository.save(new MyEntity3616().setCustomField("test data 6").setCustomFieldNew("test data new 6"));
        repository.save(new MyEntity3616().setCustomField("test data 7").setCustomFieldNew("test data new 7"));

        repository3623.save(new MyEntity3623().setCustomField("test data"));
        repository3623.save(new MyEntity3623().setCustomField("test data 2"));
        repository3623.save(new MyEntity3623().setCustomField("test data 4"));
        repository3623.save(new MyEntity3623().setCustomField("test data 4"));
        repository3623.save(new MyEntity3623().setCustomField("test data 5"));
        repository3623.save(new MyEntity3623().setCustomField("test data 6"));
        repository3623.save(new MyEntity3623().setCustomField("test data 3"));

        repository3630.save(new MyEntity3630().setCustomField("test data"));
        repository3630.save(new MyEntity3630().setCustomField("test data2"));
        repository3630.save(new MyEntity3630().setCustomField("test data"));
    }

}