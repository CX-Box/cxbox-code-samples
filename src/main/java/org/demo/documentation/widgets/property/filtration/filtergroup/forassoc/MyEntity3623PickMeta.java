package org.demo.documentation.widgets.property.filtration.filtergroup.forassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3623PickMeta extends FieldMetaBuilder<MyEntity3623PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3623PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3623PickDTO_.id);
        fields.setEnabled(MyEntity3623PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3623PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3623PickDTO_.customField);
    }

}
