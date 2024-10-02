package org.demo.documentation.widgets.assoc.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.widgets.assoc.colortitle.allfields.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.assoc.colortitle.allfields.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3052MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3052MultiMultivalueDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3052MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorInput);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorText);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorDateTime);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorCheckbox);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorDate);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumValues(MyEntity3052MultiMultivalueDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorDictionary);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorFileUploade);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorNumber);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorPercent);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorMoney);
        fields.setEnumValues(MyEntity3052MultiMultivalueDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorRadio);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorPicklistId);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorPicklist);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorInlinePicklistId);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorInlinePicklist);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorMultivalue);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customFieldColorMultivalueHover);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.id);
        fields.setEnabled(MyEntity3052MultiMultivalueDTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3052MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorInput);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorText);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorDateTime);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorCheckbox);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorDate);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyEntity3052MultiMultivalueDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorDictionary);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorFileUploade);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorNumber);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorPercent);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorMoney);
        fields.setEnumFilterValues(fields, MyEntity3052MultiMultivalueDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorRadio);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorPicklist);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorInlinePicklist);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorMultivalue);
        fields.enableFilter(MyEntity3052MultiMultivalueDTO_.customFieldColorMultivalueHover);

    }

}
