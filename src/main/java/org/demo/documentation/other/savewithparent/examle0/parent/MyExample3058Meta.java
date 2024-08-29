package org.demo.documentation.other.savewithparent.examle0.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample3058Meta extends FieldMetaBuilder<MyExample3058DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3058DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3058DTO_.customFieldRequired);
        fields.setRequired(MyExample3058DTO_.customFieldRequired);
        fields.setEnabled(MyExample3058DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3058DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3058DTO_.customFieldRequired);

    }

}