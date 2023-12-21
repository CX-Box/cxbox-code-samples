package org.demo.documentation.widgets.info.title;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3102Meta extends FieldMetaBuilder<MyExample3102DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3102DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3102DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3102DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3102DTO_.customField);
    }

}