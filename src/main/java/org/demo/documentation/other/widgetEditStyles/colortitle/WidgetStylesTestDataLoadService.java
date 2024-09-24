package org.demo.documentation.other.widgetEditStyles.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesColorDictionaryEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesColorRadioEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesInlinePicklist;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMultiMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesPicklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetStylesTestDataLoadService {
    @Autowired
    WidgetStylesRepository repository;

    @Autowired
    WidgetStylesPickRepository repositoryPick;

    @Autowired
    WidgetStylesInlineRepository repositoryPick2;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        WidgetStylesMulti myEntity1 = new WidgetStylesMulti().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        WidgetStylesMulti myEntity2 = new WidgetStylesMulti().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<WidgetStylesMulti> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        WidgetStylesPicklist myEntityPick = new WidgetStylesPicklist().setCustomField("Test data Pick");
        WidgetStylesInlinePicklist myEntityPick2 = new WidgetStylesInlinePicklist().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick2.save(myEntityPick2);
        WidgetStylesMultiMulti myEntity3 = new WidgetStylesMultiMulti().setCustomField("Test data 3");
        WidgetStylesMultiMulti myEntity4 = new WidgetStylesMultiMulti().setCustomField("Test data 4");
        List<WidgetStylesMultiMulti> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        WidgetStyles myEntity3050new = new WidgetStyles().setCustomField("Test data")
                .setCustomFieldColorCheckbox(true)
                .setCustomFieldColorDictionary(WidgetStylesColorDictionaryEnum.HIGH)
                .setCustomFieldColorDateTime(LocalDateTime.now())
                .setCustomFieldColorDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldColorDate(LocalDateTime.now())
                .setCustomFieldColorText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
                .setCustomFieldColorNumber(7L)
                .setCustomFieldColorPercent(9L)
                .setCustomFieldColorMoney(10000.0)
                .setCustomFieldColorRadio(WidgetStylesColorRadioEnum.LOW)
                .setCustomFieldColorPicklistEntity(myEntityPick)
                .setCustomFieldColorInput("Test data")
                .setCustomFieldColorInlinePicklistEntity(myEntityPick2);
        repository.save(myEntity3050new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
    }
}