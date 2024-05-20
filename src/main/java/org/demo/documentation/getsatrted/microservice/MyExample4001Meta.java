package org.demo.documentation.getsatrted.microservice;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample4001Meta extends FieldMetaBuilder<MyExample4001DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4001DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4001DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}