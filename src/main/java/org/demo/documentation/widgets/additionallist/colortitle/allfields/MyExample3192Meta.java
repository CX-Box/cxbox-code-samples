package org.demo.documentation.widgets.additionallist.colortitle.allfields;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyExample3192Meta extends FieldMetaBuilder<MyExample3192DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3192DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3192DTO_.customFieldHidden);
        fields.setEnabled(MyExample3192DTO_.customFieldText);
        fields.setEnabled(MyExample3192DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3192DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample3192DTO_.customFieldDate);
        fields.setEnabled(MyExample3192DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumValues(MyExample3192DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3192DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3192DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample3192DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample3192DTO_.customFieldNumber);
        fields.setEnabled(MyExample3192DTO_.customFieldPercent);
        fields.setEnabled(MyExample3192DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3192DTO_.customFieldPickList);
        fields.setEnabled(MyExample3192DTO_.customFieldInlineId);
        fields.setEnabled(MyExample3192DTO_.customFieldInline);
        fields.setEnabled(MyExample3192DTO_.customFieldMoney);
        fields.setEnumValues(MyExample3192DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample3192DTO_.customFieldRadio);
        fields.setDictionaryTypeWithCustomValues(MyExample3192DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .toArray(String[]::new));
        fields.setEnabled(MyExample3192DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3192DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3192DTO_.customFieldHint);
        fields.setEnabled(MyExample3192DTO_.customFieldMultivalueHoverDisplayedKey);
        fields.setEnabled(MyExample3192DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3192DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3192DTO_.customFieldText);
        fields.enableFilter(MyExample3192DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3192DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample3192DTO_.customFieldDate);
        fields.enableFilter(MyExample3192DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3192DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3192DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3192DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample3192DTO_.customFieldNumber);
        fields.enableFilter(MyExample3192DTO_.customFieldPercent);
        fields.enableFilter(MyExample3192DTO_.customFieldPickList);
        fields.enableFilter(MyExample3192DTO_.customFieldInline);
        fields.enableFilter(MyExample3192DTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyExample3192DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3192DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample3192DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .toList());
        fields.enableFilter(MyExample3192DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3192DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3192DTO_.customFieldMultivalueHoverDisplayedKey);
    }

}