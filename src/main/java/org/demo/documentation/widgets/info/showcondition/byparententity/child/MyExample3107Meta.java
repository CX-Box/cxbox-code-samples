package org.demo.documentation.widgets.info.showcondition.byparententity.child;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3107Meta extends FieldMetaBuilder<MyExample3107DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3107DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3107DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}