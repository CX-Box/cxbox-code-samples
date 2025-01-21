package org.demo.documentation.widgets.groupinghierarhy.actions.create.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3148Meta extends FieldMetaBuilder<MyExample3148DTO> {


    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3148DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3148DTO_.customFieldText);
        fields.setEnabled(MyExample3148DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3148DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3148DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3148DTO_.customFieldText);
        fields.setEnumValues(MyExample3148DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3148DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3148DTO_.customFieldDictionary);
    }

}