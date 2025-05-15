package org.demo.documentation.fields.multivaluehover.validationconfirm;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity244PickMeta extends FieldMetaBuilder<MyEntity244PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity244PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.fields.multivaluehover.validationconfirm.MyEntity244PickDTO_.id);
        fields.setEnabled(org.demo.documentation.fields.multivaluehover.validationconfirm.MyEntity244PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity244PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
