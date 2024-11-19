package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample3175Meta extends FieldMetaBuilder<MyExample3175DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3175DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3175DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3175DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample3175DTO_.customFieldHidden);
        fields.setEnabled(MyExample3175DTO_.customFieldDate);
        fields.setEnabled(MyExample3175DTO_.customFieldDateTimeWithSeconds);
        fields.setEnabled(MyExample3175DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample3175DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample3175DTO_.customFieldNumber);
        fields.setEnabled(MyExample3175DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3175DTO_.customFieldPickList);
        fields.setEnabled(MyExample3175DTO_.customFieldInlineId);
        fields.setEnabled(MyExample3175DTO_.customFieldInline);
        fields.setEnabled(MyExample3175DTO_.customFieldMoney);
        fields.setEnabled(MyExample3175DTO_.customFieldRadio);
        fields.setDictionaryTypeWithCustomValues(MyExample3175DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .toArray(String[]::new));
        fields.setEnabled(MyExample3175DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3175DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3175DTO_.customFieldHint);
        fields.setEnabled(MyExample3175DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample3175DTO_.customFieldPercent);
        fields.setEnabled(MyExample3175DTO_.customFieldText);
        fields.setEnabled(MyExample3175DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3175DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3175DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3175DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3175DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample3175DTO_.customFieldDate);
        fields.enableFilter(MyExample3175DTO_.customFieldDateTimeWithSeconds);
        fields.enableFilter(MyExample3175DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample3175DTO_.customFieldNumber);
        fields.enableFilter(MyExample3175DTO_.customFieldPickList);
        fields.enableFilter(MyExample3175DTO_.customFieldInline);
        fields.enableFilter(MyExample3175DTO_.customFieldMoney);
        fields.setEnumValues(MyExample3175DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnumFilterValues(fields, MyExample3175DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3175DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample3175DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample3175DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3175DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3175DTO_.customFieldMultivalueHover);
        fields.enableFilter(MyExample3175DTO_.customFieldPercent);
        fields.enableFilter(MyExample3175DTO_.customFieldText);
        fields.setEnumValues(MyExample3175DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3175DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3175DTO_.customFieldDictionary);
    }

}