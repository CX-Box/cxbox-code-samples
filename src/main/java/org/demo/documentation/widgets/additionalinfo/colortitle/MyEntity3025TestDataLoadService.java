package org.demo.documentation.widgets.additionalinfo.colortitle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3025TestDataLoadService {
    @Autowired
    MyEntity3025Repository repository;

    @Autowired
    MyEntity3029Repository repositoryPick;

    @Autowired
    MyEntity3030Repository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3034 myEntity1 = new MyEntity3034().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3034 myEntity2 = new MyEntity3034().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3034> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);

        MyEntity3029 myEntityPick = new
                MyEntity3029().setCustomField("Test data Pick");
        MyEntity3030 myEntityPick2 = new MyEntity3030().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick2.save(myEntityPick2);
        MyEntity3035 myEntity3 = new MyEntity3035().setCustomField("Test data 3");
        MyEntity3035 myEntity4 = new MyEntity3035().setCustomField("Test data 4");
        List<MyEntity3035> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3025 myEntity3025new = new MyEntity3025().setCustomField("Test data")
                .setCustomFieldColorCheckbox(true)
                .setCustomFieldColorDictionary(CustomFieldColorDictionaryEnum.HIGH)
                .setCustomFieldColorDateTime(LocalDateTime.now())
                .setCustomFieldColorDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldColorDate(LocalDateTime.now())
                .setCustomFieldColorText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
                .setCustomFieldColorNumber(7L)
                .setCustomFieldColorPercent(9L)
                .setCustomFieldColorMoney(10000.0)
                .setCustomFieldColorRadio(CustomFieldColorRadioEnum.LOW)
                .setCustomFieldColorPicklistEntity(myEntityPick)
                .setCustomFieldColorInlinePicklistEntity(myEntityPick2);
        repository.save(myEntity3025new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
    }
}