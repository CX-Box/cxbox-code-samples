package org.demo.documentation.widgets.additionallist.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.additionallist.base.allfields.MyEntity3191;
import org.demo.documentation.widgets.additionallist.base.allfields.MyEntity3191Repository;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.*;
import org.demo.documentation.widgets.additionallist.base.onefield.MyEntity3190;
import org.demo.documentation.widgets.additionallist.base.onefield.MyEntity3190Repository;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MyEntity3190TestDataLoadService {

    @Autowired
    MyEntity3190Repository repository;

    @Autowired
    MyEntity3191Repository repositoryAll;

    @Autowired
    MyEntity3191PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    private final CustomFileUploadServices customFileUploadServices;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3190().setCustomField("test data"));
        repository.save(new MyEntity3190().setCustomField("test data 2"));
        repository.save(new MyEntity3190().setCustomField("test data 3"));

        CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
        MyEntity3191MultiHover myEntity1 = new MyEntity3191MultiHover().setCustomField(
                "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
        MyEntity3191MultiHover myEntity2 = new MyEntity3191MultiHover().setCustomField(
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
        List<MyEntity3191MultiHover> list = new ArrayList<>();
        list.add(myEntity1);
        list.add(myEntity2);
        MyEntity3191Pick myEntityPick = new MyEntity3191Pick().setCustomField("Test data Pick");
        MyEntity3191Pick myEntityPick2 = new MyEntity3191Pick().setCustomField("Test data Pick2");
        repositoryPick.save(myEntityPick);
        repositoryPick.save(myEntityPick2);
        MyEntity3191Multi myEntity3 = new MyEntity3191Multi().setCustomField("Test data 3");
        MyEntity3191Multi myEntity4 = new MyEntity3191Multi().setCustomField("Test data 4");
        List<MyEntity3191Multi> list2 = new ArrayList<>();
        list2.add(myEntity3);
        list2.add(myEntity4);
        MyEntity3191 myEntitynew = new MyEntity3191().setCustomField("Test data")
                .setCustomFieldCheckbox(true)
                .setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
                .setCustomFieldDateTime(LocalDateTime.now())
                .setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldDate(LocalDateTime.now())
                .setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
                .setCustomFieldNumber(7L)
                .setCustomFieldPercent(9L)
                .setCustomFieldHint("Test data Hint")
                .setCustomFieldMoney(10000.0)
                .setCustomFieldRadio(CustomFieldRadioEnum.LOW)
                .setCustomFieldPickListEntity(myEntityPick)
                .setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
                .setCustomFieldInlineEntity(myEntityPick2)
                .setCustomFieldFileUpload(file.getData().getName())
                .setCustomFieldFileUploadId(file.getData().getId())
                ;
        MyEntity3191 myEntitynew2 = new MyEntity3191().setCustomField("Test data")
                .setCustomFieldCheckbox(true)
                .setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
                .setCustomFieldDateTime(LocalDateTime.now())
                .setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
                .setCustomFieldDate(LocalDateTime.now())
                .setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
                .setCustomFieldNumber(7L)
                .setCustomFieldPercent(9L)
                .setCustomFieldHint("Test data Hint")
                .setCustomFieldMoney(10000.0)
                .setCustomFieldRadio(CustomFieldRadioEnum.LOW)
                .setCustomFieldPickListEntity(myEntityPick)
                .setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
                .setCustomFieldInlineEntity(myEntityPick2)
                .setCustomFieldFileUpload(file.getData().getName())
                .setCustomFieldFileUploadId(file.getData().getId())
                ;
        repositoryAll.save(myEntitynew.setCustomFieldMultivalueHoverDisplayedKeyList(list).setCustomFieldMultivalueList(list2));
        repositoryAll.save(myEntitynew2);
    }

}