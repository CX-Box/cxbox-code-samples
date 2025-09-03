package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldRadioEnum;

@Service
public class MyEntity5028TestDataLoadService {

    @Autowired
    MyEntity5028Repository repository;

    @Autowired
    MyEntity5028PickRepository repositoryPick;
    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity5028Multi myEntity1 = new MyEntity5028Multi().setCustomField(
                "Saturn's  ");
        MyEntity5028Multi myEntity2 = new MyEntity5028Multi().setCustomField(
                "Despite ");
        List<MyEntity5028Multi> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity5028Pick myEntityPick = new MyEntity5028Pick().setCustomField("Test data Pick");
        MyEntity5028Pick myEntityPick2 = new MyEntity5028Pick().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick.save(myEntityPick2);
        MyEntity5028Multi myEntity3 = new MyEntity5028Multi().setCustomField("Test data 3");
        MyEntity5028Multi myEntity4 = new MyEntity5028Multi().setCustomField("Test data 4");
        List<MyEntity5028Multi> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity5028 myEntity5028new = new MyEntity5028().setCustomField("Test data")
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
        repository.save(myEntity5028new.setCustomFieldMultivalueList(list2)
                .setCustomFieldMultivalueHoverList(list));
    }
}
