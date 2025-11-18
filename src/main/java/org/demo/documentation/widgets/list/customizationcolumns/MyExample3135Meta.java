package org.demo.documentation.widgets.list.customizationcolumns;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldMultipleSelectEnum1;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyExample3135Meta extends FieldMetaBuilder<MyExample3135DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3135DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3135DTO_.customFieldMultivalueHover);
        fields.setConcreteValues( MyExample3135DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum1.values())
                .map(CustomFieldMultipleSelectEnum1::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample3135DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3135DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3135DTO_.customFieldHidden);
        fields.setEnabled(MyExample3135DTO_.customFieldText);
        fields.setEnabled(MyExample3135DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3135DTO_.customFieldDateTimeWithSeconds);
        fields.setEnabled(MyExample3135DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample3135DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample3135DTO_.customFieldNumber);
        fields.setEnabled(MyExample3135DTO_.customFieldPercent);
        fields.setEnabled(MyExample3135DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3135DTO_.customFieldPickList);
        fields.setEnabled(MyExample3135DTO_.customFieldInlineId);
        fields.setEnabled(MyExample3135DTO_.customFieldInline);
        fields.setEnabled(MyExample3135DTO_.customFieldMoney);
        fields.setEnumValues(MyExample3135DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample3135DTO_.customFieldRadio);
        fields.setConcreteValues( MyExample3135DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample3135DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3135DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3135DTO_.customFieldHint);
        fields.setEnabled(MyExample3135DTO_.customFieldMultivalueHover);
        fields.setEnumValues(MyExample3135DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3135DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3135DTO_.customFieldCheckBox);
        fields.setEnabled(MyExample3135DTO_.customFieldDate);
        fields.setEnabled(MyExample3135DTO_.customFieldInput);
        fields.setEnabled(MyExample3135DTO_.customField);
        fields.setRequired(MyExample3135DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3135DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3135DTO_.customFieldMultivalueHover);
        fields.setConcreteFilterValues(MyExample3135DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum1.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .toList());
        fields.enableFilter(MyExample3135DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3135DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3135DTO_.customFieldText);
        fields.enableFilter(MyExample3135DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3135DTO_.customFieldDateTimeWithSeconds);
        fields.enableFilter(MyExample3135DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample3135DTO_.customFieldNumber);
        fields.enableFilter(MyExample3135DTO_.customFieldPercent);
        fields.enableFilter(MyExample3135DTO_.customFieldPickList);
        fields.enableFilter(MyExample3135DTO_.customFieldInline);
        fields.enableFilter(MyExample3135DTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyExample3135DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3135DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample3135DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .toList());
        fields.enableFilter(MyExample3135DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3135DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3135DTO_.customFieldMultivalueHover);
        fields.setEnumFilterValues(fields, MyExample3135DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3135DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3135DTO_.customFieldCheckBox);
        fields.enableFilter(MyExample3135DTO_.customFieldDate);
        fields.enableFilter(MyExample3135DTO_.customFieldInput);
    }

}