package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3618Meta extends FieldMetaBuilder<MyExample3618DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3618DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3618DTO_.customFieldPicklistId);
        fields.setEnabled(MyExample3618DTO_.customFieldPicklist);
        fields.setEnabled(MyExample3618DTO_.customFieldMultivalueDisplayedKey);
        fields.setEnumValues(MyExample3618DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3618DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3618DTO_.customFieldNew);
        fields.setEnabled(MyExample3618DTO_.customField);
    }


    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3618DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3618DTO_.customFieldPicklist);
        fields.enableFilter(MyExample3618DTO_.customFieldMultivalueDisplayedKey);
        fields.setEnumFilterValues(fields, MyExample3618DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3618DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3618DTO_.customFieldNew);
    }
    // --8<-- [end:buildIndependentMeta]
}