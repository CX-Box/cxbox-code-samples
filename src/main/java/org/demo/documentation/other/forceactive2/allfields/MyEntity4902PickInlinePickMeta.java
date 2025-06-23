package org.demo.documentation.other.forceactive2.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4902PickInlinePickMeta extends FieldMetaBuilder<MyEntity4902PickInlinePickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity4902PickInlinePickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.other.forceactive2.allfields.MyEntity4902PickInlinePickDTO_.id);
        fields.setEnabled(org.demo.documentation.other.forceactive2.allfields.MyEntity4902PickInlinePickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity4902PickInlinePickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
