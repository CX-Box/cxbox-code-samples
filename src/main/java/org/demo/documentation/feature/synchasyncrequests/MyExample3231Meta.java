package org.demo.documentation.feature.synchasyncrequests;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3231Meta extends FieldMetaBuilder<MyExample3231DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3231DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
         fields.setEnabled(MyExample3231DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3231DTO> fields, InnerBcDescription bcDescription, Long parentId) {

    }

}