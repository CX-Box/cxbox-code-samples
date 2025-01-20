package org.demo.documentation.widgets.formpopup.colortitle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.formpopup.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.formpopup.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3027TestDataLoadService {


    @Autowired
    MyEntity3027Repository repository;

    @Autowired
    MyEntity3044Repository repository3044;

    @Autowired
    MyEntity3043MultivalueRepository repository3043;

    @Autowired
    MyEntity3043MultivalueRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3041 myEntity1 = new MyEntity3041().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3041 myEntity2 = new MyEntity3041().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3041> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity3044 myEntityPick = new MyEntity3044().setCustomField("Test data Pick");
        MyEntity3043 myEntityPick2 = new
                MyEntity3043().setCustomField("Test data Pick2");
        repository3044.save(myEntityPick);
        repository3043.save(myEntityPick2);
        MyEntity3042  myEntity3 = new MyEntity3042().setCustomField("Test data 3");
        MyEntity3042 myEntity4 = new MyEntity3042().setCustomField("Test data 4");
        List<MyEntity3042> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3027 myEntity3043new = new MyEntity3027().setCustomField("Test data")
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
        repository.save(myEntity3043new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
    }
}