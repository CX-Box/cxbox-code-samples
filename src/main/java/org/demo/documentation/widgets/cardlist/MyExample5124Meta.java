package org.demo.documentation.widgets.cardlist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5124Meta extends FieldMetaBuilder<MyExample5124DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5124DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample5124DTO_.customFieldFileId);
      fields.setEnabled(MyExample5124DTO_.customFieldFile);
      fields.setEnabled(MyExample5124DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample5124DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample5124DTO_.customFieldFile);
    }

}