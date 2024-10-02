package org.demo.documentation.widgets.picklist.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.picklist.basic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.basic.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3067PickPickMeta extends FieldMetaBuilder<MyEntity3067PickPickDTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3067PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3067PickPickDTO_.customField);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldInput);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldText);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldDateTime);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldCheckbox);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldDate);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldDateTimeWithSeconds);
        fields.setEnumValues(MyEntity3067PickPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldDictionary);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldFileUploadeId);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldFileUploade);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldNumber);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldPercent);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldMoney);
        fields.setEnumValues(MyEntity3067PickPickDTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldRadio);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldPicklistId);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldPicklist);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldInlinePicklistId);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldInlinePicklist);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldMultivalue);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldMultivalueHover);
        fields.setEnabled(MyEntity3067PickPickDTO_.id);
        fields.setEnabled(MyEntity3067PickPickDTO_.customFieldPick);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3067PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3067PickPickDTO_.customField);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldInput);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldText);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldDateTime);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldCheckbox);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldDate);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldDateTimeWithSeconds);
        fields.setEnumFilterValues(fields, MyEntity3067PickPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldDictionary);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldFileUploade);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldNumber);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldPercent);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldMoney);
        fields.setEnumFilterValues(fields, MyEntity3067PickPickDTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldRadio);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldPicklist);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldInlinePicklist);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldMultivalue);
        fields.enableFilter(MyEntity3067PickPickDTO_.customFieldMultivalueHover);

        fields.enableSort(MyEntity3067PickPickDTO_.customField);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldInput);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldText);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldDateTime);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldCheckbox);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldDate);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldDateTimeWithSeconds);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldDictionary);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldFileUploade);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldNumber);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldPercent);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldMoney);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldRadio);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldPicklist);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldInlinePicklist);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldMultivalue);
        fields.enableSort(MyEntity3067PickPickDTO_.customFieldMultivalueHover);

    }

}
