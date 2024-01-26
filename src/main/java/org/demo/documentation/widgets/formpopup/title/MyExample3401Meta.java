package org.demo.documentation.widgets.formpopup.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3401Meta extends FieldMetaBuilder<MyExample3401DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3401DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3401DTO_.customField2);
      fields.setEnabled(MyExample3401DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3401DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3401DTO_.customField2);
      fields.enableFilter(MyExample3401DTO_.customField);
    }

}