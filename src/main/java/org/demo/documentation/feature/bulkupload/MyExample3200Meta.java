package org.demo.documentation.feature.bulkupload;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3200Meta extends FieldMetaBuilder<MyExample3200DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3200DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3200DTO_.customFieldFileId);
      fields.setEnabled(MyExample3200DTO_.customFieldFile);
      fields.setEnabled(MyExample3200DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3200DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3200DTO_.customFieldFile);
    }

}