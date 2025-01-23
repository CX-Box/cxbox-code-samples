package org.demo.documentation.widgets.picklist.color;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.color.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picklist.color.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.picklist.color.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3060TestDataLoadService {

    @Autowired
    MyEntity3060Repository repository;

    @Autowired
    MyEntity3061Repository repository2;

    @Autowired
    MyEntity3061PickRepository repositoryPick;

    @Autowired
    MyEntity3061PickPickRepository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3060().setCustomField("test data"));
        MyEntity3061Multi myEntity1 = new MyEntity3061Multi().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core");
        MyEntity3061Multi myEntity2 = new MyEntity3061Multi().setCustomField("Saturn's mass is not in the gas phase");
        List<MyEntity3061Multi> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity3061PickPick myEntityPick = new
                MyEntity3061PickPick().setCustomField("Test data Pick");
        MyEntity3061Pick myEntityPick2 = new MyEntity3061Pick().setCustomField("Test data Pick2");
        repositoryPick2.save(myEntityPick);
        repositoryPick.save(myEntityPick2);
        MyEntity3061MultiMulti myEntity3 = new MyEntity3061MultiMulti().setCustomField("Test data 3");
        MyEntity3061MultiMulti myEntity4 = new MyEntity3061MultiMulti().setCustomField("Test data 4");
        List<MyEntity3061MultiMulti> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3061 myEntity3061new = new MyEntity3061().setCustomField("Test data")
                .setCustomFieldColorCheckbox(true)
                .setCustomFieldColorDictionary(CustomFieldColorDictionaryEnum.HIGH)
                .setCustomFieldColorDateTime(LocalDateTime.now())
                .setCustomFieldColorDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldColorDate(LocalDateTime.now())
                .setCustomFieldColorText("Unlike a digital typeface")
                .setCustomFieldColorNumber(7L)
                .setCustomFieldColorPercent(9L)
                .setCustomFieldColorMoney(10000.0)
                .setCustomFieldColorRadio(CustomFieldColorRadioEnum.LOW)
                .setCustomFieldColorPicklistEntity(myEntityPick)
                .setCustomFieldColorInput("Test data")
                .setCustomFieldColorInputConst("Test data")
                .setCustomFieldColorTextConst("Test data")
                .setCustomFieldColorInlinePicklistEntity(myEntityPick2);
        repository2.save(myEntity3061new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
    }

}