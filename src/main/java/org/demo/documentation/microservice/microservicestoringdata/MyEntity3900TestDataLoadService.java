package org.demo.documentation.microservice.microservicestoringdata;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.microservice.microservicestoringdata.repository.MyEntity3900Repository;
import org.demo.documentation.microservice.microservicestoringdata.repository.MyEntity4001Repository;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity3900;
import org.demo.documentation.microservice.microservicestoringdata.repository.MyEntity3910Repository;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity3910;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity4001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@Service
public class MyEntity3900TestDataLoadService {

    @Autowired
    MyEntity3900Repository repository;

    @Autowired
    MyEntity3910Repository repository3910;

    @Autowired
    MyEntity4001Repository repository4001;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3900().setCustomField("Test data").setCustomFieldNew("Test data"));
        repository.save(new MyEntity3900().setCustomField("Test data2").setCustomFieldNew("Test data2"));
        repository.save(new MyEntity3900().setCustomField("Test data3").setCustomFieldNew("Test data3"));
        repository.save(new MyEntity3900().setCustomField("Test data4").setCustomFieldNew("Test data4"));
        repository.save(new MyEntity3900().setCustomField("Test data5").setCustomFieldNew("Test data5"));
        repository.save(new MyEntity3900().setCustomField("Test data6").setCustomFieldNew("Test data6"));
        repository.save(new MyEntity3900().setCustomField("Test data7").setCustomFieldNew("Test data7"));
        repository.save(new MyEntity3900().setCustomField("Test data8").setCustomFieldNew("Test data8"));
        repository.save(new MyEntity3900().setCustomField("Test data9").setCustomFieldNew("Test data9"));
        repository.save(new MyEntity3900().setCustomField("Test data10").setCustomFieldNew("Test data10"));
        repository3910.deleteAll();
        repository3910.save(new MyEntity3910().setCustomField("Test data").setCustomFieldNew("Test data").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data2").setCustomFieldNew("Test data2").setCustomFieldDateTime(LocalDateTime.now().minusDays(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data3").setCustomFieldNew("Test data3").setCustomFieldDateTime(LocalDateTime.now().minusDays(45)));
        repository3910.save(new MyEntity3910().setCustomField("Test data4").setCustomFieldNew("Test data4").setCustomFieldDateTime(LocalDateTime.now().minusYears(1)));
        repository3910.save(new MyEntity3910().setCustomField("Test data5").setCustomFieldNew("Test data5").setCustomFieldDateTime(LocalDateTime.now().minusYears(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data6").setCustomFieldNew("Test data6").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(35)));
        repository3910.save(new MyEntity3910().setCustomField("Test data7").setCustomFieldNew("Test data7").setCustomFieldDateTime(LocalDateTime.now().minusMonths(6)));
        repository3910.save(new MyEntity3910().setCustomField("Test data8").setCustomFieldNew("Test data8").setCustomFieldDateTime(LocalDateTime.now().minusWeeks(2)));
        repository3910.save(new MyEntity3910().setCustomField("Test data9").setCustomFieldNew("Test data9").setCustomFieldDateTime(LocalDateTime.now().minusMonths(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data10").setCustomFieldNew("Test data10").setCustomFieldDateTime(LocalDateTime.now().minusWeeks(7)));
        repository4001.deleteAll();
        repository4001.save(new MyEntity4001().setCustomField("Test data").setCustomFieldNew("Test data").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(3)));

    }

}