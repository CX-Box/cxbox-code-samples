package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4902MultiHoverPickMeta extends FieldMetaBuilder<MyEntity4902MultiHoverPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity4902MultiHoverPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity4902MultiHoverPickDTO_.id);
        fields.setEnabled(MyEntity4902MultiHoverPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity4902MultiHoverPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
