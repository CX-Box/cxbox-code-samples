package org.demo.documentation.widgets.additionallist.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3193Meta extends FieldMetaBuilder<MyExample3193DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3193DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3193DTO_.customFieldText);
        fields.setEnabled(MyExample3193DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3193DTO> fields, InnerBcDescription bcDescription, Long parentId) {

    }

}