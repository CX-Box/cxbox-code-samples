package org.demo.documentation.widgets.property.defaultlimitpage;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample359Meta extends FieldMetaBuilder<MyExample359DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample359DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample359DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample359DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}