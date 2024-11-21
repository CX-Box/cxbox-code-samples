package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample3202Meta extends FieldMetaBuilder<MyExample3202DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3202DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3202DTO_.customFieldHidden);
        fields.setEnabled(MyExample3202DTO_.customFieldText);
        fields.setEnabled(MyExample3202DTO_.customFieldDateTime);
        fields.setEnabled(MyExample3202DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample3202DTO_.customFieldDate);
        fields.setEnabled(MyExample3202DTO_.customFieldDateTimeWithSeconds);
        fields.setEnabled(MyExample3202DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample3202DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample3202DTO_.customFieldNumber);
        fields.setEnabled(MyExample3202DTO_.customFieldPercent);
        fields.setEnabled(MyExample3202DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3202DTO_.customFieldPickList);
        fields.setEnabled(MyExample3202DTO_.customFieldInlineId);
        fields.setEnabled(MyExample3202DTO_.customFieldInline);
        fields.setEnabled(MyExample3202DTO_.customFieldMoney);
        fields.setEnabled(MyExample3202DTO_.customFieldRadio);
        fields.setDictionaryTypeWithCustomValues(MyExample3202DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .toArray(String[]::new));
        fields.setEnabled(MyExample3202DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample3202DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample3202DTO_.customFieldHint);
        fields.setEnabled(MyExample3202DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample3202DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3202DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3202DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3202DTO_.customFieldText);
        fields.enableFilter(MyExample3202DTO_.customFieldDateTime);
        fields.enableFilter(MyExample3202DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample3202DTO_.customFieldDate);
        fields.enableFilter(MyExample3202DTO_.customFieldDateTimeWithSeconds);
        fields.enableFilter(MyExample3202DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample3202DTO_.customFieldNumber);
        fields.enableFilter(MyExample3202DTO_.customFieldPercent);
        fields.enableFilter(MyExample3202DTO_.customFieldPickList);
        fields.enableFilter(MyExample3202DTO_.customFieldInline);
        fields.enableFilter(MyExample3202DTO_.customFieldMoney);
        fields.setEnumValues(MyExample3202DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnumFilterValues(fields, MyExample3202DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3202DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample3202DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample3202DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample3202DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample3202DTO_.customFieldMultivalueHover);
        fields.setEnumValues(MyExample3202DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3202DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3202DTO_.customFieldDictionary);
    }

}