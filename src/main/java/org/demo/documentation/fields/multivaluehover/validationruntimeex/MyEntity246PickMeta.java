package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity246PickMeta extends FieldMetaBuilder<MyEntity246PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity246PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.fields.multivaluehover.validationruntimeex.MyEntity246PickDTO_.id);
        fields.setEnabled(org.demo.documentation.fields.multivaluehover.validationruntimeex.MyEntity246PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity246PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
