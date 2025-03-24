package org.demo.documentation.widgets.picklist.base;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.picklist.base.allfields.MyEntity3067;
import org.demo.documentation.widgets.picklist.base.allfields.MyEntity3067Repository;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.*;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067PickRepository;
import org.demo.documentation.widgets.picklist.base.onefield.MyEntity3079;
import org.demo.documentation.widgets.picklist.base.onefield.MyEntity3079Repository;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079PickRepository;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity3067TestDataLoadService {

    @Autowired
    MyEntity3079PickRepository repository3079Pick;

    @Autowired
    MyEntity3079Repository repository3079;

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

    private final CustomFileUploadServices customFileUploadServices;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
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
        MyEntity3067Pick myEntity3067new = new MyEntity3067Pick()
                .setCustomField("Test data")
                .setCustomFieldPick("Test data Pick")
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
                .setCustomFieldFileUploade(file.getData().getName())
                .setCustomFieldFileUploadeId(file.getData().getId())
                .setCustomFieldInlinePicklistEntity(myEntityPick2);
        repository2.save(myEntity3067new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
        repository.save(new MyEntity3067().setCustomFieldEntity(myEntity3067new));

        repository3079.deleteAll();
        repository3079.save(new MyEntity3079().setCustomField("test data"));
        repository3079.save(new MyEntity3079().setCustomField("test data2"));
        repository3079.save(new MyEntity3079().setCustomField("test data3"));

        repository3079Pick.deleteAll();
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data2"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data3"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data4"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data5"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data6"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data3"));
        repository3079Pick.save(new MyEntity3079Pick().setCustomField("test data3"));
    }

}