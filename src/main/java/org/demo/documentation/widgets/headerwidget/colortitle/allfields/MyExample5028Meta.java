package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample5028Meta extends FieldMetaBuilder<MyExample5028DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5028DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5028DTO_.customFieldHidden);
        fields.setEnabled(MyExample5028DTO_.customFieldText);
        fields.setEnabled(MyExample5028DTO_.customFieldDateTime);
        fields.setEnabled(MyExample5028DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample5028DTO_.customFieldDate);
        fields.setEnabled(MyExample5028DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumValues(MyExample5028DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample5028DTO_.customFieldDictionary);
        fields.setEnabled(MyExample5028DTO_.customFieldFileUploadId);
        fields.setEnabled(MyExample5028DTO_.customFieldFileUpload);
        fields.setEnabled(MyExample5028DTO_.customFieldNumber);
        fields.setEnabled(MyExample5028DTO_.customFieldPercent);
        fields.setEnabled(MyExample5028DTO_.customFieldPickListId);
        fields.setEnabled(MyExample5028DTO_.customFieldPickList);
        fields.setEnabled(MyExample5028DTO_.customFieldInlineId);
        fields.setEnabled(MyExample5028DTO_.customFieldInline);
        fields.setEnabled(MyExample5028DTO_.customFieldMoney);
        fields.setEnumValues(MyExample5028DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyExample5028DTO_.customFieldRadio);
        fields.setConcreteValues(MyExample5028DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(CustomFieldMultipleSelectEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample5028DTO_.customFieldMultipleSelect);
        fields.setEnabled(MyExample5028DTO_.customFieldMultivalue);
        fields.setEnabled(MyExample5028DTO_.customFieldHint);
        fields.setEnabled(MyExample5028DTO_.customFieldMultivalueHover);
        fields.setEnabled(MyExample5028DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5028DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample5028DTO_.customFieldText);
        fields.enableFilter(MyExample5028DTO_.customFieldDateTime);
        fields.enableFilter(MyExample5028DTO_.customFieldCheckbox);
        fields.enableFilter(MyExample5028DTO_.customFieldDate);
        fields.enableFilter(MyExample5028DTO_.customFieldDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample5028DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample5028DTO_.customFieldDictionary);
        fields.enableFilter(MyExample5028DTO_.customFieldFileUpload);
        fields.enableFilter(MyExample5028DTO_.customFieldNumber);
        fields.enableFilter(MyExample5028DTO_.customFieldPercent);
        fields.enableFilter(MyExample5028DTO_.customFieldPickList);
        fields.enableFilter(MyExample5028DTO_.customFieldInline);
        fields.enableFilter(MyExample5028DTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyExample5028DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample5028DTO_.customFieldRadio);
        fields.setConcreteFilterValues(MyExample5028DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample5028DTO_.customFieldMultipleSelect);
        fields.enableFilter(MyExample5028DTO_.customFieldMultivalue);
        fields.enableFilter(MyExample5028DTO_.customFieldMultivalueHover);
    }

}