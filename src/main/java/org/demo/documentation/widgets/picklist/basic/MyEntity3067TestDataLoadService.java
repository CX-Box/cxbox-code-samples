package org.demo.documentation.widgets.picklist.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.basic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.basic.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picklist.basic.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3067TestDataLoadService {

    @Autowired
    MyEntity3067Repository repository;

    @Autowired
    MyEntity3067PickRepository repository2;

    @Autowired
    MyEntity3067PickInlinePickRepository repositoryPick;

    @Autowired
    MyEntity3067PickPickRepository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3067Multi myEntity1 = new MyEntity3067Multi().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3067Multi myEntity2 = new MyEntity3067Multi().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3067Multi> list2 = new ArrayList<>();
        list2.add(myEntity1);
        list2.add(myEntity2);
        MyEntity3067PickPicklist myEntityPick = new
                MyEntity3067PickPicklist().setCustomField("Test data Pick");
        MyEntity3067PickInlinePicklist myEntityPick2 = new MyEntity3067PickInlinePicklist().setCustomField("Test data Pick2");
        repositoryPick2.save(myEntityPick);
        repositoryPick.save(myEntityPick2);
        MyEntity3067MultiMulti myEntity3 = new MyEntity3067MultiMulti().setCustomField("Test data 3");
        MyEntity3067MultiMulti myEntity4 = new MyEntity3067MultiMulti().setCustomField("Test data 4");
        List<MyEntity3067MultiMulti> list = new ArrayList<>();
        list.add(myEntity3);
        list.add(myEntity4);
        MyEntity3067Pick myEntity3067new = new MyEntity3067Pick().setCustomFieldPick("Test data")
                .setCustomFieldCheckbox(true)
                .setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
                .setCustomFieldDateTime(LocalDateTime.now())
                .setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldDate(LocalDateTime.now())
                .setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
                .setCustomFieldNumber(7L)
                .setCustomFieldPercent(9L)
                .setCustomFieldMoney(10000.0)
                .setCustomFieldRadio(CustomFieldRadioEnum.LOW)
                .setCustomFieldPicklistEntity(myEntityPick)
                .setCustomFieldInput("Test data")
                .setCustomFieldInlinePicklistEntity(myEntityPick2);
        repository2.save(myEntity3067new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
        repository.save(new MyEntity3067().setCustomFieldEntity(myEntity3067new));
    }

}