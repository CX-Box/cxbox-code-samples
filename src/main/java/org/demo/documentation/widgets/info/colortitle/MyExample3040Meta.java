package org.demo.documentation.widgets.info.colortitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3040Meta extends FieldMetaBuilder<MyExample3040DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3040DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3040DTO_.customFieldColorMoney);
        fields.setEnabled(MyExample3040DTO_.customFieldColorInput);
        fields.setEnabled(MyExample3040DTO_.customFieldColorText);
        fields.setEnabled(MyExample3040DTO_.customFieldColorDateTime);
        fields.setEnabled(MyExample3040DTO_.customFieldColorCheckbox);
        fields.setEnabled(MyExample3040DTO_.customFieldColorDate);
        fields.setEnabled(MyExample3040DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumValues(MyExample3040DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.setEnabled(MyExample3040DTO_.customFieldColorDictionary);
        fields.setEnabled(MyExample3040DTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyExample3040DTO_.customFieldColorFileUploade);
        fields.setEnabled(MyExample3040DTO_.customFieldColorNumber);
        fields.setEnabled(MyExample3040DTO_.customFieldColorPercent);
        fields.setEnumValues(MyExample3040DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.setEnabled(MyExample3040DTO_.customFieldColorRadio);
        fields.setEnabled(MyExample3040DTO_.customFieldColorPicklistId);
        fields.setEnabled(MyExample3040DTO_.customFieldColorPicklist);
        fields.setEnabled(MyExample3040DTO_.customFieldColorInlinePicklistId);
        fields.setEnabled(MyExample3040DTO_.customFieldColorInlinePicklist);
        fields.setEnabled(MyExample3040DTO_.customFieldColorMultivalue);
        fields.setEnabled(MyExample3040DTO_.customFieldColorMultivalueHover);
        fields.setEnabled(MyExample3040DTO_.customField);
        fields.setRequired(MyExample3040DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3040DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3040DTO_.customFieldColorMoney);
        fields.enableFilter(MyExample3040DTO_.customFieldColorInput);
        fields.enableFilter(MyExample3040DTO_.customFieldColorText);
        fields.enableFilter(MyExample3040DTO_.customFieldColorDateTime);
        fields.enableFilter(MyExample3040DTO_.customFieldColorCheckbox);
        fields.enableFilter(MyExample3040DTO_.customFieldColorDate);
        fields.enableFilter(MyExample3040DTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyExample3040DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.enableFilter(MyExample3040DTO_.customFieldColorDictionary);
        fields.enableFilter(MyExample3040DTO_.customFieldColorFileUploade);
        fields.enableFilter(MyExample3040DTO_.customFieldColorNumber);
        fields.enableFilter(MyExample3040DTO_.customFieldColorPercent);
        fields.setEnumFilterValues(fields, MyExample3040DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.enableFilter(MyExample3040DTO_.customFieldColorRadio);
        fields.enableFilter(MyExample3040DTO_.customFieldColorPicklist);
        fields.enableFilter(MyExample3040DTO_.customFieldColorInlinePicklist);
        fields.enableFilter(MyExample3040DTO_.customFieldColorMultivalue);
        fields.enableFilter(MyExample3040DTO_.customFieldColorMultivalueHover);
    }

}