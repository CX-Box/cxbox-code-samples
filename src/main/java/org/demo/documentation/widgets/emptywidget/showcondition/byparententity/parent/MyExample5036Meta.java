package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5036Meta extends FieldMetaBuilder<MyExample5036DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5036DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5036DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5036DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}