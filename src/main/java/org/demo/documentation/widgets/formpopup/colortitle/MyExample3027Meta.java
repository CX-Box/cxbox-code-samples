package org.demo.documentation.widgets.formpopup.colortitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.formpopup.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.formpopup.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3027Meta extends FieldMetaBuilder<MyExample3027DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3027DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3027DTO_.customFieldColorInput);
        fields.setEnabled(MyExample3027DTO_.customFieldColorText);
        fields.setEnabled(MyExample3027DTO_.customFieldColorDateTime);
        fields.setEnabled(MyExample3027DTO_.customFieldColorCheckbox);
        fields.setEnabled(MyExample3027DTO_.customFieldColorDate);
        fields.setEnabled(MyExample3027DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumValues(MyExample3027DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.setEnabled(MyExample3027DTO_.customFieldColorDictionary);
        fields.setEnabled(MyExample3027DTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyExample3027DTO_.customFieldColorFileUploade);
        fields.setEnabled(MyExample3027DTO_.customFieldColorNumber);
        fields.setEnabled(MyExample3027DTO_.customFieldColorPercent);
        fields.setEnabled(MyExample3027DTO_.customFieldColorMoney);
        fields.setEnumValues(MyExample3027DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.setEnabled(MyExample3027DTO_.customFieldColorRadio);
        fields.setEnabled(MyExample3027DTO_.customFieldColorPicklistId);
        fields.setEnabled(MyExample3027DTO_.customFieldColorPicklist);
        fields.setEnabled(MyExample3027DTO_.customFieldColorInlinePicklistId);
        fields.setEnabled(MyExample3027DTO_.customFieldColorInlinePicklist);
        fields.setEnabled(MyExample3027DTO_.customFieldColorMultivalue);
        fields.setEnabled(MyExample3027DTO_.customFieldColorMultivalueHover);
        fields.setEnabled(MyExample3027DTO_.customField);
        fields.setRequired(MyExample3027DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3027DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3027DTO_.customFieldColorInput);
        fields.enableFilter(MyExample3027DTO_.customFieldColorText);
        fields.enableFilter(MyExample3027DTO_.customFieldColorDateTime);
        fields.enableFilter(MyExample3027DTO_.customFieldColorCheckbox);
        fields.enableFilter(MyExample3027DTO_.customFieldColorDate);
        fields.enableFilter(MyExample3027DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3027DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.enableFilter(MyExample3027DTO_.customFieldColorDictionary);
        fields.enableFilter(MyExample3027DTO_.customFieldColorFileUploade);
        fields.enableFilter(MyExample3027DTO_.customFieldColorNumber);
        fields.enableFilter(MyExample3027DTO_.customFieldColorPercent);
        fields.enableFilter(MyExample3027DTO_.customFieldColorMoney);
        fields.setEnumFilterValues(fields, MyExample3027DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.enableFilter(MyExample3027DTO_.customFieldColorRadio);
        fields.enableFilter(MyExample3027DTO_.customFieldColorPicklist);
        fields.enableFilter(MyExample3027DTO_.customFieldColorInlinePicklist);
        fields.enableFilter(MyExample3027DTO_.customFieldColorMultivalue);
        fields.enableFilter(MyExample3027DTO_.customFieldColorMultivalueHover);
    }

}