package org.demo.documentation.fields.time.validationconfirm;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample4103Meta extends FieldMetaBuilder<MyExample4103DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4103DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4103DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}