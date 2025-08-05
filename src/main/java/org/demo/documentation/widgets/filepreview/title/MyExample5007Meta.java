package org.demo.documentation.widgets.filepreview.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5007Meta extends FieldMetaBuilder<MyExample5007DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5007DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample5007DTO_.customFieldId);
        fields.setEnabled(MyExample5007DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5007DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample5007DTO_.customFieldId);
    }

}