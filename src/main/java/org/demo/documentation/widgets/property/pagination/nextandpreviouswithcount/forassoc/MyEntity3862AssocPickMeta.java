package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3862AssocPickMeta extends FieldMetaBuilder<MyEntity3862AssocPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3862AssocPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3862AssocPickDTO_.id);
        fields.setEnabled(MyEntity3862AssocPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3862AssocPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
