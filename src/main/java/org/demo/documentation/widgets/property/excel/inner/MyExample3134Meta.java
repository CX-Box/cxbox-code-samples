package org.demo.documentation.widgets.property.excel.inner;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample3134Meta extends FieldMetaBuilder<MyExample3134DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3134DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3134DTO_.customFieldMoneyWithCurrencyDynamic);
      fields.setEnabled(MyExample3134DTO_.customFieldMoneyWithCurrencyConst);
      fields.setEnabled(MyExample3134DTO_.customFieldHidden);
      fields.setEnabled(MyExample3134DTO_.customFieldText);
      fields.setEnabled(MyExample3134DTO_.customFieldDateTime);
      fields.setEnabled(MyExample3134DTO_.customFieldCheckbox);
      fields.setEnabled(MyExample3134DTO_.customFieldDate);
      fields.setEnabled(MyExample3134DTO_.customFieldDateTimeWithSeconds);
      fields.setEnumValues(MyExample3134DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.setEnabled(MyExample3134DTO_.customFieldDictionary);
      fields.setEnabled(MyExample3134DTO_.customFieldFileUploadId);
      fields.setEnabled(MyExample3134DTO_.customFieldFileUpload);
      fields.setEnabled(MyExample3134DTO_.customFieldNumber);
      fields.setEnabled(MyExample3134DTO_.customFieldPercent);
      fields.setEnabled(MyExample3134DTO_.customFieldPickListId);
      fields.setEnabled(MyExample3134DTO_.customFieldPickList);
      fields.setEnabled(MyExample3134DTO_.customFieldInlineId);
      fields.setEnabled(MyExample3134DTO_.customFieldInline);
      fields.setEnabled(MyExample3134DTO_.customFieldMoney);
      fields.setEnumValues(MyExample3134DTO_.customFieldRadio, CustomFieldRadioEnum.values());
      fields.setEnabled(MyExample3134DTO_.customFieldRadio);
      fields.setDictionaryTypeWithCustomValues(MyExample3134DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
              .map(CustomFieldMultipleSelectEnum::getValue)
              .toArray(String[]::new));
      fields.setEnabled(MyExample3134DTO_.customFieldMultipleSelect);
      fields.setEnabled(MyExample3134DTO_.customFieldMultivalue);
      fields.setEnabled(MyExample3134DTO_.customFieldHint);
      fields.setEnabled(MyExample3134DTO_.customFieldMultivalueHover);
      fields.setEnabled(MyExample3134DTO_.customField);
        fields.setRequired(MyExample3134DTO_.customField);
    }

  // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3134DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3134DTO_.customFieldMoneyWithCurrencyDynamic);
      fields.enableFilter(MyExample3134DTO_.customFieldMoneyWithCurrencyConst);
      fields.enableFilter(MyExample3134DTO_.customFieldText);
      fields.enableFilter(MyExample3134DTO_.customFieldDateTime);
      fields.enableFilter(MyExample3134DTO_.customFieldCheckbox);
      fields.enableFilter(MyExample3134DTO_.customFieldDate);
      fields.enableFilter(MyExample3134DTO_.customFieldDateTimeWithSeconds);
      fields.setEnumFilterValues(fields, MyExample3134DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.enableFilter(MyExample3134DTO_.customFieldDictionary);
      fields.enableFilter(MyExample3134DTO_.customFieldFileUpload);
      fields.enableFilter(MyExample3134DTO_.customFieldNumber);
      fields.enableFilter(MyExample3134DTO_.customFieldPercent);
      fields.enableFilter(MyExample3134DTO_.customFieldPickList);
      fields.enableFilter(MyExample3134DTO_.customFieldInline);
      fields.enableFilter(MyExample3134DTO_.customFieldMoney);
      fields.setEnumFilterValues(fields, MyExample3134DTO_.customFieldRadio, CustomFieldRadioEnum.values());
      fields.enableFilter(MyExample3134DTO_.customFieldRadio);
      fields.setConcreteFilterValues(MyExample3134DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
              .map(en -> new SimpleDictionary(en.name(), en.getValue()))
              .collect(Collectors.toList()));
      fields.enableFilter(MyExample3134DTO_.customFieldMultipleSelect);
      fields.enableFilter(MyExample3134DTO_.customFieldMultivalue);
      fields.enableFilter(MyExample3134DTO_.customFieldMultivalueHover);
    }

}