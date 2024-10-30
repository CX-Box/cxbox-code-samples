package org.demo.documentation.fields.dictionary.icon;

import org.cxbox.api.data.dto.rowmeta.IconCode;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.fields.dictionary.icon.enums.IconCodeEnum;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;
import static org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum.*;
import static org.demo.documentation.fields.dictionary.icon.enums.IconCodeEnum.CameraTwoTone;

@Service
public class MyExample3011Meta extends FieldMetaBuilder<MyExample3011DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3011DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3011DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3011DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3011DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample3011DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3011DTO_.customFieldDictionary);

        Map<Enum, String> valueIconMap = Map.of(
                HIGH,  CameraTwoTone.getValue(),
                MIDDLE,  CameraTwoTone.getValue(),
                LOW,  CameraTwoTone.getValue());
        fields.setAllValuesAddIconsEnum(MyExample3011DTO_.customFieldDictionary, REGIONS,valueIconMap);
        fields.setEnumValues(MyExample3011DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
    }

}
