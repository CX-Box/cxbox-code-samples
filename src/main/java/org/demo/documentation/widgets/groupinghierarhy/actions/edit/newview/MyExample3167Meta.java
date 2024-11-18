package org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3167Meta extends FieldMetaBuilder<MyExample3167DTO> {

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3167DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3167DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3167DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3167DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3167DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3167DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3167DTO_.customFieldDictionary);
    }

}