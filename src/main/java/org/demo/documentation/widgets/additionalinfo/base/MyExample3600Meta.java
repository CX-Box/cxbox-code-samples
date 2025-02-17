package org.demo.documentation.widgets.additionalinfo.base;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample3600Meta extends FieldMetaBuilder<MyExample3600DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3600DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3600DTO_.customFieldDate);
        fields.setEnabled(MyExample3600DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample3600DTO_.customFieldHint);
        fields.setEnabled(MyExample3600DTO_.customFieldMultivalue);
        fields.setDictionaryTypeWithCustomValues(MyExample3600DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .toArray(String[]::new));
        fields.setEnabled(MyExample3600DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3600DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3600DTO_.customFieldPickList);
        fields.setEnabled(MyExample3600DTO_.customFieldInlinePickListId);
        fields.setEnabled(MyExample3600DTO_.customFieldInlinePickList);
        fields.setEnabled(MyExample3600DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumValues(MyExample3600DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample3600DTO_.customFieldRadio);
        fields.setEnabled(MyExample3600DTO_.customFieldMoney);
        fields.setEnabled(MyExample3600DTO_.customFieldPercent);
        fields.setEnabled(MyExample3600DTO_.customFieldNum);
        fields.setEnumValues(MyExample3600DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3600DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3600DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample3600DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3600DTO_.customFieldText);
        fields.setEnabled(MyExample3600DTO_.customField3);
        fields.setEnabled(MyExample3600DTO_.customField2);
        fields.setEnabled(MyExample3600DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3600DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3600DTO_.customFieldDate);
        fields.enableFilter(MyExample3600DTO_.customFieldMultivalueHover);
        fields.enableFilter(MyExample3600DTO_.customFieldMultivalue);
        fields.setConcreteFilterValues(MyExample3600DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .toList());
        fields.enableFilter(MyExample3600DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3600DTO_.customFieldPickList);
        fields.enableFilter(MyExample3600DTO_.customFieldInlinePickList);
        fields.enableFilter(MyExample3600DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3600DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3600DTO_.customFieldRadio);
        fields.enableFilter(MyExample3600DTO_.customFieldMoney);
        fields.enableFilter(MyExample3600DTO_.customFieldPercent);
        fields.enableFilter(MyExample3600DTO_.customFieldNum);
        fields.setEnumFilterValues(fields, MyExample3600DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3600DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3600DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample3600DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3600DTO_.customFieldText);
        fields.enableFilter(MyExample3600DTO_.customField3);
        fields.enableFilter(MyExample3600DTO_.customField2);
        fields.enableFilter(MyExample3600DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]
}