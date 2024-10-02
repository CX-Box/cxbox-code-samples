package org.demo.documentation.widgets.list.colortitle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.list.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.list.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050InlinePicklist;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Multi;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMulti;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Picklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3050TestDataLoadService {
    @Autowired
    MyEntity3050Repository repository;

    @Autowired
    MyEntity3050PickRepository repositoryPick;

    @Autowired
    MyEntity3050InlineRepository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3050Multi myEntity1 = new MyEntity3050Multi().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3050Multi myEntity2 = new MyEntity3050Multi().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3050Multi> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity3050Picklist myEntityPick = new MyEntity3050Picklist().setCustomField("Test data Pick");
        MyEntity3050InlinePicklist myEntityPick2 = new MyEntity3050InlinePicklist().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick2.save(myEntityPick2);
        MyEntity3050MultiMulti myEntity3 = new MyEntity3050MultiMulti().setCustomField("Test data 3");
        MyEntity3050MultiMulti myEntity4 = new MyEntity3050MultiMulti().setCustomField("Test data 4");
        List<MyEntity3050MultiMulti> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3050 myEntity3050new = new MyEntity3050().setCustomField("Test data")
                .setCustomFieldText("Test data text")
                .setCustomFieldColorCheckbox(true)
                .setCustomFieldColorDictionary(CustomFieldColorDictionaryEnum.HIGH)
                .setCustomFieldColorDateTime(LocalDateTime.now())
                .setCustomFieldColorDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldColorDate(LocalDateTime.now())
                .setCustomFieldColorText("Test data")
                .setCustomFieldColorNumber(7L)
                .setCustomFieldColorPercent(9L)
                .setCustomFieldColorMoney(10000.0)
                .setCustomFieldColorRadio(CustomFieldColorRadioEnum.LOW)
                .setCustomFieldColorPicklistEntity(myEntityPick)
                .setCustomFieldColorInput("Test data")
                .setCustomFieldColorInlinePicklistEntity(myEntityPick2);
        repository.save(myEntity3050new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
    }
}