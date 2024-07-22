package org.demo.documentation.widgets.form.colortitle;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3026Meta extends FieldMetaBuilder<MyExample3026DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3026DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3026DTO_.customFieldColorInput);
        fields.setEnabled(MyExample3026DTO_.customFieldColorText);
        fields.setEnabled(MyExample3026DTO_.customFieldColorDateTime);
        fields.setEnabled(MyExample3026DTO_.customFieldColorCheckbox);
        fields.setEnabled(MyExample3026DTO_.customFieldColorDate);
        fields.setEnabled(MyExample3026DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumValues(MyExample3026DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.setEnabled(MyExample3026DTO_.customFieldColorDictionary);
        fields.setEnabled(MyExample3026DTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyExample3026DTO_.customFieldColorFileUploade);
        fields.setEnabled(MyExample3026DTO_.customFieldColorNumber);
        fields.setEnabled(MyExample3026DTO_.customFieldColorPercent);
        fields.setEnabled(MyExample3026DTO_.customFieldColorMoney);
        fields.setEnumValues(MyExample3026DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.setEnabled(MyExample3026DTO_.customFieldColorRadio);
        fields.setEnabled(MyExample3026DTO_.customFieldColorPicklistId);
        fields.setEnabled(MyExample3026DTO_.customFieldColorPicklist);
        fields.setEnabled(MyExample3026DTO_.customFieldColorInlinePicklistId);
        fields.setEnabled(MyExample3026DTO_.customFieldColorInlinePicklist);
        fields.setEnabled(MyExample3026DTO_.customField);
        fields.setRequired(MyExample3026DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3026DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3026DTO_.customFieldColorInput);
        fields.enableFilter(MyExample3026DTO_.customFieldColorText);
        fields.enableFilter(MyExample3026DTO_.customFieldColorDateTime);
        fields.enableFilter(MyExample3026DTO_.customFieldColorCheckbox);
        fields.enableFilter(MyExample3026DTO_.customFieldColorDate);
        fields.enableFilter(MyExample3026DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3026DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.enableFilter(MyExample3026DTO_.customFieldColorDictionary);
        fields.enableFilter(MyExample3026DTO_.customFieldColorFileUploade);
        fields.enableFilter(MyExample3026DTO_.customFieldColorNumber);
        fields.enableFilter(MyExample3026DTO_.customFieldColorPercent);
        fields.enableFilter(MyExample3026DTO_.customFieldColorMoney);
        fields.setEnumFilterValues(fields, MyExample3026DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.enableFilter(MyExample3026DTO_.customFieldColorRadio);
        fields.enableFilter(MyExample3026DTO_.customFieldColorPicklist);
        fields.enableFilter(MyExample3026DTO_.customFieldColorInlinePicklist);
    }

}