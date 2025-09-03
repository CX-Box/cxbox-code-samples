package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample5035Meta extends FieldMetaBuilder<MyExample5035DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5035DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5035DTO_.customFieldHidden);
        fields.setEnabled(MyExample5035DTO_.customFieldText);
        fields.setEnabled(MyExample5035DTO_.customFieldDateTime);
        fields.setEnabled(MyExample5035DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample5035DTO_.customFieldDate);
        fields.setEnabled(MyExample5035DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumValues(MyExample5035DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample5035DTO_.customFieldDictionary);
        fields.setEnabled(MyExample5035DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample5035DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample5035DTO_.customFieldNumber);
        fields.setEnabled(MyExample5035DTO_.customFieldPercent);
        fields.setEnabled(MyExample5035DTO_.customFieldPickListId);
        fields.setEnabled(MyExample5035DTO_.customFieldPickList);
        fields.setEnabled(MyExample5035DTO_.customFieldInlineId);
        fields.setEnabled(MyExample5035DTO_.customFieldInline);
        fields.setEnabled(MyExample5035DTO_.customFieldMoney);
        fields.setEnumValues(MyExample5035DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample5035DTO_.customFieldRadio);
        fields.setConcreteValues(MyExample5035DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample5035DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample5035DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample5035DTO_.customFieldHint);
        fields.setEnabled(MyExample5035DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample5035DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5035DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample5035DTO_.customFieldText);
        fields.enableFilter(MyExample5035DTO_.customFieldDateTime);
        fields.enableFilter(MyExample5035DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample5035DTO_.customFieldDate);
        fields.enableFilter(MyExample5035DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample5035DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample5035DTO_.customFieldDictionary);
        fields.enableFilter(MyExample5035DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample5035DTO_.customFieldNumber);
        fields.enableFilter(MyExample5035DTO_.customFieldPercent);
        fields.enableFilter(MyExample5035DTO_.customFieldPickList);
        fields.enableFilter(MyExample5035DTO_.customFieldInline);
        fields.enableFilter(MyExample5035DTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyExample5035DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample5035DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample5035DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample5035DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample5035DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample5035DTO_.customFieldMultivalueHover);
    }

}