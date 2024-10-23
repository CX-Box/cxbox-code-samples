package org.demo.documentation.widgets.form.base.allfields;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample3010Meta extends FieldMetaBuilder<MyExample3010DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3010DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3010DTO_.customFieldHidden);
        fields.setEnabled(MyExample3010DTO_.customFieldText);
        fields.setEnabled(MyExample3010DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3010DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample3010DTO_.customFieldDate);
        fields.setEnabled(MyExample3010DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumValues(MyExample3010DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3010DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3010DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample3010DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample3010DTO_.customFieldNumber);
        fields.setEnabled(MyExample3010DTO_.customFieldPercent);
        fields.setEnabled(MyExample3010DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3010DTO_.customFieldPickList);
        fields.setEnabled(MyExample3010DTO_.customFieldInlineId);
        fields.setEnabled(MyExample3010DTO_.customFieldInline);
        fields.setEnabled(MyExample3010DTO_.customFieldMoney);
        fields.setEnumValues(MyExample3010DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample3010DTO_.customFieldRadio);
        fields.setDictionaryTypeWithCustomValues(MyExample3010DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .toArray(String[]::new));
        fields.setEnabled(MyExample3010DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3010DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3010DTO_.customFieldHint);
        fields.setEnabled(MyExample3010DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample3010DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3010DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3010DTO_.customFieldText);
        fields.enableFilter(MyExample3010DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3010DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample3010DTO_.customFieldDate);
        fields.enableFilter(MyExample3010DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3010DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3010DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3010DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample3010DTO_.customFieldNumber);
        fields.enableFilter(MyExample3010DTO_.customFieldPercent);
        fields.enableFilter(MyExample3010DTO_.customFieldPickList);
        fields.enableFilter(MyExample3010DTO_.customFieldInline);
        fields.enableFilter(MyExample3010DTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyExample3010DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3010DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample3010DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample3010DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3010DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3010DTO_.customFieldMultivalueHover);
    }

}