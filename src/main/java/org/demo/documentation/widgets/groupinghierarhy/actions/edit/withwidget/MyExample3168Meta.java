package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary2Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary3Enum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3168Meta extends FieldMetaBuilder<MyExample3168DTO> {

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3168DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        if(fields.isFieldChangedNow(fields,MyExample3168DTO_.customFieldDictionary3)){
            fields.setCurrentValue(MyExample3168DTO_.customFieldDictionary2,null);
            fields.setCurrentValue(MyExample3168DTO_.customField,null);
        }
        fields.setEnumValues(MyExample3168DTO_.customFieldDictionary3, CustomFieldDictionary3Enum.values());
        fields.setEnabled(MyExample3168DTO_.customFieldDictionary3);
        fields.setEnumValues(MyExample3168DTO_.customFieldDictionary2, CustomFieldDictionary2Enum.values());
        fields.setEnabled(MyExample3168DTO_.customFieldDictionary2);
        fields.setEnabled(MyExample3168DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3168DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3168DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3168DTO_.customFieldDictionary3, CustomFieldDictionary3Enum.values());
        fields.enableFilter(MyExample3168DTO_.customFieldDictionary3);
        fields.setEnumFilterValues(fields, MyExample3168DTO_.customFieldDictionary2, CustomFieldDictionary2Enum.values());
        fields.enableFilter(MyExample3168DTO_.customFieldDictionary2);
        fields.setEnumValues(MyExample3168DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3168DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3168DTO_.customFieldDictionary);
        fields.setForceActive(MyExample3168DTO_.customFieldDictionary3);
    }

}