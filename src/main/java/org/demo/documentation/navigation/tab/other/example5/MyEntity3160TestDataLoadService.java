package org.demo.documentation.navigation.tab.other.example5;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3160TestDataLoadService {

    @Autowired
    MyEntity3160Repository repository;
    @Autowired
    MyEntity3161Repository repositoryParent;
    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repositoryParent.deleteAll();
        MyEntity3161 myEntity3161 = new MyEntity3161().setCustomField("test data");
        repositoryParent.save(myEntity3161);
        repositoryParent.save(new MyEntity3161().setCustomField("test data2"));
        repositoryParent.save(new MyEntity3161().setCustomField("test data3"));
        repository.deleteAll();
        repository.save(new MyEntity3160().setCustomField("test data child").setCustomFieldEntity(myEntity3161));
    }

}