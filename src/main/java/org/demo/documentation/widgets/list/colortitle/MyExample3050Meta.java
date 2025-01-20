package org.demo.documentation.widgets.list.colortitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.list.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.list.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3050Meta extends FieldMetaBuilder<MyExample3050DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3050DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3050DTO_.customFieldText);
        fields.setEnabled(MyExample3050DTO_.customFieldColorInput);
        fields.setEnabled(MyExample3050DTO_.customFieldColorText);
        fields.setEnabled(MyExample3050DTO_.customFieldColorDateTime);
        fields.setEnabled(MyExample3050DTO_.customFieldColorCheckbox);
        fields.setEnabled(MyExample3050DTO_.customFieldColorDate);
        fields.setEnabled(MyExample3050DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumValues(MyExample3050DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.setEnabled(MyExample3050DTO_.customFieldColorDictionary);
        fields.setEnabled(MyExample3050DTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyExample3050DTO_.customFieldColorFileUploade);
        fields.setEnabled(MyExample3050DTO_.customFieldColorNumber);
        fields.setEnabled(MyExample3050DTO_.customFieldColorPercent);
        fields.setEnabled(MyExample3050DTO_.customFieldColorMoney);
        fields.setEnumValues(MyExample3050DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.setEnabled(MyExample3050DTO_.customFieldColorRadio);
        fields.setEnabled(MyExample3050DTO_.customFieldColorPicklistId);
        fields.setEnabled(MyExample3050DTO_.customFieldColorPicklist);
        fields.setEnabled(MyExample3050DTO_.customFieldColorInlinePicklistId);
        fields.setEnabled(MyExample3050DTO_.customFieldColorInlinePicklist);
        fields.setEnabled(MyExample3050DTO_.customFieldColorMultivalue);
        fields.setEnabled(MyExample3050DTO_.customFieldColorMultivalueHover);
        fields.setEnabled(MyExample3050DTO_.customField);
        fields.setRequired(MyExample3050DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3050DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3050DTO_.customFieldColorInput);
        fields.enableFilter(MyExample3050DTO_.customFieldColorText);
        fields.enableFilter(MyExample3050DTO_.customFieldColorDateTime);
        fields.enableFilter(MyExample3050DTO_.customFieldColorCheckbox);
        fields.enableFilter(MyExample3050DTO_.customFieldColorDate);
        fields.enableFilter(MyExample3050DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3050DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.enableFilter(MyExample3050DTO_.customFieldColorDictionary);
        fields.enableFilter(MyExample3050DTO_.customFieldColorFileUploade);
        fields.enableFilter(MyExample3050DTO_.customFieldColorNumber);
        fields.enableFilter(MyExample3050DTO_.customFieldColorPercent);
        fields.enableFilter(MyExample3050DTO_.customFieldColorMoney);
        fields.setEnumFilterValues(fields, MyExample3050DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.enableFilter(MyExample3050DTO_.customFieldColorRadio);
        fields.enableFilter(MyExample3050DTO_.customFieldColorPicklist);
        fields.enableFilter(MyExample3050DTO_.customFieldColorInlinePicklist);
        fields.enableFilter(MyExample3050DTO_.customFieldColorMultivalue);
        fields.enableFilter(MyExample3050DTO_.customFieldColorMultivalueHover);
    }

}