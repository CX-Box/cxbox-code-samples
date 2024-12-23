package org.demo.documentation.widgets.additionallist.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3194Meta extends FieldMetaBuilder<MyExample3194DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3194DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3194DTO_.customFieldText);
        fields.setEnabled(MyExample3194DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3194DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}