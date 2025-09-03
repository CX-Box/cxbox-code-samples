package org.demo.documentation.widgets.emptywidget.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.*;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldRadioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity5031TestDataLoadService {

    @Autowired
    MyEntity5031Repository repository;

    @Autowired
    MyEntity5035RepositoryPick repositoryPick;

    @Autowired
    MyEntity5035Repository repository5035;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository5035.deleteAll();

        repository.save(new MyEntity5031().setCustomField("test data").setCustomFieldText("test data text"));
        repository5035.save(new MyEntity5035().setCustomField("test data"));
        MyEntity5035Muti myEntity1 = new MyEntity5035Muti().setCustomField(
                "Saturn's  ");
        MyEntity5035Muti myEntity2 = new MyEntity5035Muti().setCustomField(
                "Despite ");
        List<MyEntity5035Muti> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity5035Pick myEntityPick = new MyEntity5035Pick().setCustomField("Test data Pick");
        MyEntity5035Pick myEntityPick2 = new MyEntity5035Pick().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick.save(myEntityPick2);
        MyEntity5035Muti myEntity3 = new MyEntity5035Muti().setCustomField("Test data 3");
        MyEntity5035Muti myEntity4 = new MyEntity5035Muti().setCustomField("Test data 4");
        List<MyEntity5035Muti> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity5035 myEntity5035new = new MyEntity5035().setCustomField("Test data")
                .setCustomFieldCheckbox(true)
                .setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
                .setCustomFieldDateTime(LocalDateTime.now())
                .setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldDate(LocalDateTime.now())
                .setCustomFieldText("Unlike a digital typeface")
                .setCustomFieldNumber(7L)
                .setCustomFieldPercent(9L)
                .setCustomFieldHint("Test data Hint")
                .setCustomFieldMoney(10000.0)
                .setCustomFieldRadio(CustomFieldRadioEnum.LOW)
                .setCustomFieldPickListEntity(myEntityPick)
                .setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
                .setCustomFieldInlineEntity(myEntityPick2);
        repository5035.save(myEntity5035new.setCustomFieldMultivalueList(list2)
                .setCustomFieldMultivalueHoverList(list));
    }
}
