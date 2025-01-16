package org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3614PickPickMeta extends FieldMetaBuilder<MyEntity3614PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3614PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3614PickPickDTO_.id);
        fields.setEnabled(MyEntity3614PickPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3614PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
		fields.enableFilter(MyEntity3614PickPickDTO_.customField);
    }

}
