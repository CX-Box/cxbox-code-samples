package org.demo.documentation.widgets.picklist.color;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.picklist.color.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picklist.color.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3061PickMeta extends FieldMetaBuilder<MyEntity3061PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3061PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorInput);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorText);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorDateTime);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorCheckbox);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorDate);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumValues(MyEntity3061PickDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorDictionary);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorFileUploade);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorFileUploadeId);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorFileUploade);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorNumber);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorPercent);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorMoney);
        fields.setEnumValues(MyEntity3061PickDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorRadio);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorPicklistId);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorPicklist);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorInlinePicklistId);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorInlinePicklist);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorMultivalue);
        fields.setEnabled(MyEntity3061PickDTO_.customFieldColorMultivalueHover);
        fields.setEnabled(MyEntity3061PickDTO_.id);
        fields.setEnabled(MyEntity3061PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3061PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorInput);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorText);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorDateTime);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorCheckbox);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorDate);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyEntity3061PickDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorDictionary);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorFileUploade);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorFileUploade);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorNumber);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorPercent);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorMoney);
        fields.setEnumFilterValues(fields, MyEntity3061PickDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorRadio);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorPicklist);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorInlinePicklist);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorMultivalue);
        fields.enableFilter(MyEntity3061PickDTO_.customFieldColorMultivalueHover);

    }

}
