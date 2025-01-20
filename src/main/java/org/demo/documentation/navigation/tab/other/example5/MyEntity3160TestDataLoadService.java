package org.demo.documentation.navigation.tab.other.example5;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.navigation.tab.other.example5.child2.MyEntity3162;
import org.demo.documentation.navigation.tab.other.example5.child2.MyEntity3162Repository;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163Repository;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3160TestDataLoadService {

    @Autowired
    MyEntity3160Repository repository;
    @Autowired
    MyEntity3161Repository repositoryParent;
    @Autowired
    MyEntity3162Repository repositoryChild2;
    @Autowired
    MyEntity3163Repository repositoryChild;
    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryChild.deleteAll();
        repositoryChild2.deleteAll();
        repositoryParent.deleteAll();

        MyEntity3161 myEntity3161 = new MyEntity3161().setCustomField("test data1");
        repositoryParent.save(myEntity3161);
        MyEntity3161 myEntity3161_2 = new MyEntity3161().setCustomField("test data2");
        repositoryParent.save(myEntity3161_2);
        MyEntity3161 myEntity3161_3 = new MyEntity3161().setCustomField("test data3");
        repositoryParent.save(myEntity3161_3);
        MyEntity3161 myEntity3161_4 = new MyEntity3161().setCustomField("test data4");
        repositoryParent.save(myEntity3161_4);
        MyEntity3161 myEntity3161_5 = new MyEntity3161().setCustomField("test data5");
        repositoryParent.save(myEntity3161_5);
        MyEntity3161 myEntity3161_6 = new MyEntity3161().setCustomField("test data6");
        repositoryParent.save(myEntity3161_6);
        MyEntity3161 myEntity3161_7 = new MyEntity3161().setCustomField("test data7");
        repositoryParent.save(myEntity3161_7);

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child").setCustomFieldEntity(myEntity3161));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child").setCustomFieldEntity(myEntity3161));
        repository.save(new MyEntity3160().setCustomField("test data child").setCustomFieldEntity(myEntity3161));

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child 2").setCustomFieldEntity(myEntity3161_2));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child 2").setCustomFieldEntity(myEntity3161_2));
        repository.save(new MyEntity3160().setCustomField("test data child 2").setCustomFieldEntity(myEntity3161_2));

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child 3").setCustomFieldEntity(myEntity3161_3));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child 3").setCustomFieldEntity(myEntity3161_3));
        repository.save(new MyEntity3160().setCustomField("test data child 3").setCustomFieldEntity(myEntity3161_3));

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child 4").setCustomFieldEntity(myEntity3161_4));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child 4").setCustomFieldEntity(myEntity3161_4));
        repository.save(new MyEntity3160().setCustomField("test data child 4").setCustomFieldEntity(myEntity3161_4));

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child 5").setCustomFieldEntity(myEntity3161_5));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child 5").setCustomFieldEntity(myEntity3161_5));
        repository.save(new MyEntity3160().setCustomField("test data child 5").setCustomFieldEntity(myEntity3161_5));

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child 6").setCustomFieldEntity(myEntity3161_6));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child 6").setCustomFieldEntity(myEntity3161_6));
        repository.save(new MyEntity3160().setCustomField("test data child 6").setCustomFieldEntity(myEntity3161_6));

        repositoryChild2.save(new MyEntity3162().setCustomField("test data child 7").setCustomFieldEntity(myEntity3161_7));
        repositoryChild.save(new MyEntity3163().setCustomField("test data child 7").setCustomFieldEntity(myEntity3161_7));
        repository.save(new MyEntity3160().setCustomField("test data child 7").setCustomFieldEntity(myEntity3161_7));
    }

}