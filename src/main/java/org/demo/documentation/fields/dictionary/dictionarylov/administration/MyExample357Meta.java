package org.demo.documentation.fields.dictionary.dictionarylov.administration;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample357Meta extends FieldMetaBuilder<MyExample357DTO> {

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample357DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample357DTO_.active);
        fields.setEnabled(MyExample357DTO_.description);
        fields.setEnabled(MyExample357DTO_.displayOrder);
        fields.setEnabled(MyExample357DTO_.value);
        fields.setEnabled(MyExample357DTO_.key);
        fields.setEnabled(MyExample357DTO_.typeId);
        fields.setEnabled(MyExample357DTO_.type);
        fields.setEnabled(MyExample357DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample357DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample357DTO_.active);
        fields.enableFilter(MyExample357DTO_.description);
        fields.enableFilter(MyExample357DTO_.displayOrder);
        fields.enableFilter(MyExample357DTO_.value);
        fields.enableFilter(MyExample357DTO_.key);
        fields.enableFilter(MyExample357DTO_.type);
    }
    // --8<-- [end:buildIndependentMeta]
}