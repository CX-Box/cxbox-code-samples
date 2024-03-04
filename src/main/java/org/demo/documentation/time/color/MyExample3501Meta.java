package org.demo.documentation.time.color;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3501Meta extends FieldMetaBuilder<MyExample3501DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3501DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3501DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3501DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3501DTO_.customField);
    }

}