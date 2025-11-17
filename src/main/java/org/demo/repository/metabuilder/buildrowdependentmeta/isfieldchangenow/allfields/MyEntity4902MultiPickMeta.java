package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4902MultiPickMeta extends FieldMetaBuilder<MyEntity4902MultiPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity4902MultiPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity4902MultiPickDTO_.id);
        fields.setEnabled(MyEntity4902MultiPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity4902MultiPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
