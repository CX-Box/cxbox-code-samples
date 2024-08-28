package org.demo.documentation.widgets.assoc.colortitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3056Meta extends FieldMetaBuilder<MyExample3056DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3056DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3056DTO_.customFieldMultiConst);
      fields.setEnabled(MyExample3056DTO_.customFieldMulti);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3056DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3056DTO_.customFieldMultiConst);
      fields.enableFilter(MyExample3056DTO_.customFieldMulti);
    }

}