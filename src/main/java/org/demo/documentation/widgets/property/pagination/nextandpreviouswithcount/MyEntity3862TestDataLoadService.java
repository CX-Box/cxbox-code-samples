package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862AssocRepository;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist.MyEntity3862Pick;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist.MyEntity3862PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3862TestDataLoadService {

    @Autowired
    MyEntity3862Repository repository;

    @Autowired
    MyEntity3862PickRepository repositoryPick;

    @Autowired
    MyEntity3862AssocRepository  repositoryAssoc;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3862().setCustomField("test data"));
        repository.save(new MyEntity3862().setCustomField("test data2"));
        repository.save(new MyEntity3862().setCustomField("test data3"));
        repository.save(new MyEntity3862().setCustomField("test data4"));
        repository.save(new MyEntity3862().setCustomField("test data5"));
        repository.save(new MyEntity3862().setCustomField("test data6"));
        repository.save(new MyEntity3862().setCustomField("test data7"));
        repository.save(new MyEntity3862().setCustomField("test data8"));
        repository.save(new MyEntity3862().setCustomField("test data9"));
        repository.save(new MyEntity3862().setCustomField("test data10"));

        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data2"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data3"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data4"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data5"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data6"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data7"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data8"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data9"));
        repositoryPick.save(new MyEntity3862Pick().setCustomField("test data10"));

        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data2"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data3"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data4"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data5"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data6"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data7"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data8"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data9"));
        repositoryAssoc.save(new MyEntity3862Assoc().setCustomField("test data10"));


    }

}