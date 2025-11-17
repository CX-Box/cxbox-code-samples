package org.demo.documentation.fields.fileupload.types;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyExample107Meta extends FieldMetaBuilder<MyExample107DTO> {

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample107DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample107DTO_.customFieldId);
        fields.setEnabled(MyExample107DTO_.customField);
        fields.setPlaceholder(MyExample107DTO_.customField,"Type only .pdf");

    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample107DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample107DTO_.customField);
        fields.setFileAccept(MyExample107DTO_.customField, List.of(".pdf" ));

    }
    // --8<-- [end:buildIndependentMeta]
}