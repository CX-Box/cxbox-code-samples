package org.demo.documentation.other.forceactive2.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4902PickPickMeta extends FieldMetaBuilder<MyEntity4902PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity4902PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.other.forceactive2.allfields.MyEntity4902PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.other.forceactive2.allfields.MyEntity4902PickPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity4902PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
