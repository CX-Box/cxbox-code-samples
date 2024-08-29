package org.demo.documentation.other.savewithparent.example2;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.savewithparent.example2.child.MyEntity3130;
import org.demo.documentation.other.savewithparent.example2.child.MyEntity3130Repository;
import org.demo.documentation.other.savewithparent.example2.parent.MyEntity3131;
import org.demo.documentation.other.savewithparent.example2.parent.MyEntity3131Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3131TestDataLoadService {

    @Autowired
    MyEntity3131Repository repositoryParent;

    @Autowired
    MyEntity3130Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3131 myEntity3131 =  new MyEntity3131().setCustomField("Test Data");
        repositoryParent.save(myEntity3131);
        repository.save(new MyEntity3130().setCustomField("Test Data").setCustomFieldEntity(myEntity3131));
    }

}