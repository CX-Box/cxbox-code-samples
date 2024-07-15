package org.demo.documentation.fields.inlinepicklist.basic;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity133TestDataLoadService {

    @Autowired
    MyEntity133Repository repository;

    @Autowired
    MyEntity132Repository repository132;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository132.deleteAll();
		MyEntity132Pick myEntity2 = new MyEntity132Pick().setCustomField("Abs data");
		repository132.save(myEntity2);
		repository.save(new MyEntity133().setCustomFieldEntity(myEntity2));

		int i = 0;
        while (i < 50) {
            MyEntity132Pick myEntity1 = new MyEntity132Pick().setCustomField(i+ " Test data new information");
            repository132.save(myEntity1);
            i++;
        }
    }

}