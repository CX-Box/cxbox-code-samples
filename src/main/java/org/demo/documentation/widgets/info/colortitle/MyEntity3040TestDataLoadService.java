package org.demo.documentation.widgets.info.colortitle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040InlinePicklist;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Picklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3040TestDataLoadService {
    @Autowired
    MyEntity3040Repository repository;

    @Autowired
    MyEntity3040PickRepository repositoryPick;

    @Autowired
    MyEntity3040InlinePickRepository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3040Multi myEntity1 = new MyEntity3040Multi().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3040Multi myEntity2 = new MyEntity3040Multi().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3040Multi> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity3040Picklist myEntityPick = new MyEntity3040Picklist().setCustomField("Test data Pick");
        MyEntity3040InlinePicklist myEntityPick2 = new MyEntity3040InlinePicklist().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick2.save(myEntityPick2);
        MyEntity3040MultiMulti myEntity3 = new MyEntity3040MultiMulti().setCustomField("Test data 3");
        MyEntity3040MultiMulti myEntity4 = new MyEntity3040MultiMulti().setCustomField("Test data 4");
        List<MyEntity3040MultiMulti> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3040 myEntity3040new = new MyEntity3040().setCustomField("Test data")
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
        repository.save(myEntity3040new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
    }
}