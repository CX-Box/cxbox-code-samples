package org.demo.documentation.widgets.list.base.allfields;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;

import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyExample3002Meta extends FieldMetaBuilder<MyExample3002DTO> {

    private final DocumentConfig configuration;

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3002DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setDictionaryTypeWithCustomValues(MyExample3002DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .toArray(String[]::new));

        fields.setEnumValues(MyExample3002DTO_.customFieldRadio, CustomFieldRadioEnum.values());

        fields.setEnumValues(MyExample3002DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3002DTO_.customFieldMultivalueHover,
                MyExample3002DTO_.customFieldHint,
                MyExample3002DTO_.customFieldMultivalue,
                MyExample3002DTO_.customFieldMultipleSelect,
                MyExample3002DTO_.customFieldInlineId,
                MyExample3002DTO_.customFieldInline,
                MyExample3002DTO_.customFieldPickListId,
                MyExample3002DTO_.customFieldPickList,
                MyExample3002DTO_.customFieldRadio,
                MyExample3002DTO_.customFieldMoney,
                MyExample3002DTO_.customFieldPercent,
                MyExample3002DTO_.customFieldNumber,
                MyExample3002DTO_.customFieldFileUploadId,
                MyExample3002DTO_.customFieldFileUpload,
                MyExample3002DTO_.customFieldDictionary,
                MyExample3002DTO_.customFieldDateTimeWithSeconds,
                MyExample3002DTO_.customFieldDate,
                MyExample3002DTO_.customFieldCheckbox,
                MyExample3002DTO_.customFieldDateTime,
                MyExample3002DTO_.customFieldText,
                MyExample3002DTO_.customFieldHidden,
                MyExample3002DTO_.customField);

        fields.setRequired(MyExample3002DTO_.customFieldMultivalueHover,
                MyExample3002DTO_.customFieldHint,
                MyExample3002DTO_.customFieldMultivalue,
                MyExample3002DTO_.customFieldMultipleSelect,
                MyExample3002DTO_.customFieldInlineId,
                MyExample3002DTO_.customFieldInline,
                MyExample3002DTO_.customFieldPickListId,
                MyExample3002DTO_.customFieldPickList,
                MyExample3002DTO_.customFieldRadio,
                MyExample3002DTO_.customFieldMoney,
                MyExample3002DTO_.customFieldPercent,
                MyExample3002DTO_.customFieldNumber,
                MyExample3002DTO_.customFieldFileUploadId,
                MyExample3002DTO_.customFieldFileUpload,
                MyExample3002DTO_.customFieldDictionary,
                MyExample3002DTO_.customFieldDateTimeWithSeconds,
                MyExample3002DTO_.customFieldDate,
                MyExample3002DTO_.customFieldCheckbox,
                MyExample3002DTO_.customFieldDateTime,
                MyExample3002DTO_.customFieldText,
                MyExample3002DTO_.customFieldHidden,
                MyExample3002DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3002DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3002DTO_.customFieldMultivalueHover);
        fields.enableFilter(MyExample3002DTO_.customFieldMultivalue);
        fields.setConcreteFilterValues(MyExample3002DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .toList());
        fields.enableFilter(MyExample3002DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3002DTO_.customFieldInline);
        fields.enableFilter(MyExample3002DTO_.customFieldPickList);
        fields.setEnumFilterValues(fields, MyExample3002DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3002DTO_.customFieldRadio);
        fields.enableFilter(MyExample3002DTO_.customFieldMoney);
        fields.enableFilter(MyExample3002DTO_.customFieldPercent);
        fields.enableFilter(MyExample3002DTO_.customFieldNumber);
        fields.enableFilter(MyExample3002DTO_.customFieldFileUpload);
        fields.setEnumFilterValues(fields, MyExample3002DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3002DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3002DTO_.customFieldDateTimeWithSeconds);
        fields.enableFilter(MyExample3002DTO_.customFieldDate);
        fields.enableFilter(MyExample3002DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample3002DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3002DTO_.customFieldText);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3002DTO_.customField);
        }
        fields.enableFilter(MyExample3002DTO_.customField);

    }
    // --8<-- [end:buildIndependentMeta]

}