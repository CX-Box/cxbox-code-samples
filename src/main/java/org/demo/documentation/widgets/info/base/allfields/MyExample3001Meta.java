package org.demo.documentation.widgets.info.base.allfields;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyExample3001Meta extends FieldMetaBuilder<MyExample3001DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3001DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3001DTO_.customFieldInlinePickListId);
        fields.setEnabled(MyExample3001DTO_.customFieldInlinePickList);
        fields.setEnabled(MyExample3001DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3001DTO_.customFieldPickList);
        fields.setEnabled(MyExample3001DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3001DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample3001DTO_.customFieldText);
        fields.setEnabled(MyExample3001DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3001DTO_.customFieldCheckbox);
        fields.setEnumValues(MyExample3001DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3001DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3001DTO_.customFieldNum);
        fields.setEnabled(MyExample3001DTO_.customFieldMoney);
        fields.setEnumValues(MyExample3001DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample3001DTO_.customFieldRadio);
        fields.setEnabled(MyExample3001DTO_.customFieldDateTimeWithSeconds);
        fields.setEnabled(MyExample3001DTO_.customFieldPercent);
        fields.setConcreteValues(MyExample3001DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample3001DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3001DTO_.customFieldHint);
        fields.setEnabled(MyExample3001DTO_.customFieldDate);
        fields.setEnabled(MyExample3001DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3001DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3001DTO_.customFieldInlinePickList);
        fields.enableFilter(MyExample3001DTO_.customFieldPickList);
        fields.enableFilter(MyExample3001DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3001DTO_.customFieldMultivalueHover);
        fields.enableFilter(MyExample3001DTO_.customFieldText);
        fields.enableFilter(MyExample3001DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3001DTO_.customFieldCheckbox);
        fields.setEnumFilterValues(fields, MyExample3001DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3001DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3001DTO_.customFieldNum);
        fields.enableFilter(MyExample3001DTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyExample3001DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3001DTO_.customFieldRadio);
        fields.enableFilter(MyExample3001DTO_.customFieldDateTimeWithSeconds);
        fields.enableFilter(MyExample3001DTO_.customFieldPercent);
        fields.setConcreteFilterValues(MyExample3001DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .toList());
        fields.enableFilter(MyExample3001DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3001DTO_.customFieldDate);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3001DTO_.customField);
        }
        fields.enableFilter(MyExample3001DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]

}