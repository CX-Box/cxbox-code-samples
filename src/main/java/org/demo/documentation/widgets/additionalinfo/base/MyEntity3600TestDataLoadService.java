package org.demo.documentation.widgets.additionalinfo.base;

import org.cxbox.api.service.session.InternalAuthorizationService;

import org.demo.documentation.multivalue.basic.MyEntityMultivalue177;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionalinfo.base.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3600TestDataLoadService {

    @Autowired
    MyEntity3600Repository repository;

    @Autowired
    MyEntity3600PickRepository repositoryPick;

    @Autowired
    MyEntity3600Pick2Repository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3600Multi myEntity1 = new MyEntity3600Multi().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3600Multi myEntity2 = new MyEntity3600Multi().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3600Multi> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity3600Pick myEntityPick = new MyEntity3600Pick().setCustomField("Test data Pick");
        MyEntity3600Pick myEntityPickNew = new MyEntity3600Pick().setCustomField("Test data Pick New");
        MyEntity3600Pick2 myEntityPick2 = new MyEntity3600Pick2().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick2.save(myEntityPick2);
        MyEntity3600Multi2 myEntity3 = new MyEntity3600Multi2().setCustomField("Test data 3");
        MyEntity3600Multi2 myEntity4 = new MyEntity3600Multi2().setCustomField("Test data 4");
        List<MyEntity3600Multi2> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3600 myEntity3600new = new MyEntity3600().setCustomField("Test data")
                .setCustomFieldCheckbox(true)
                .setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
                .setCustomFieldDateTime(LocalDateTime.now())
                .setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldDate(LocalDateTime.now())
                .setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
                .setCustomFieldNum(7L)
                .setCustomFieldPercent(9L)
                .setCustomFieldHint("Test data Hint")
                .setCustomFieldMoney(10000.0)
                .setCustomFieldRadio(CustomFieldRadioEnum.LOW)
                .setCustomFieldPickListEntity(myEntityPick2)
                .setCustomFieldInlinePickListEntity(myEntityPick);
        repository.save(myEntity3600new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
    }

}