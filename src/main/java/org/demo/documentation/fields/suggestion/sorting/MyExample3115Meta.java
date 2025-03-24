package org.demo.documentation.fields.suggestion.sorting;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3115Meta extends AnySourceFieldMetaBuilder<MyExample3115DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3115DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3115DTO> fields, BcDescription bcDescription, String parentId) {
    }

}
