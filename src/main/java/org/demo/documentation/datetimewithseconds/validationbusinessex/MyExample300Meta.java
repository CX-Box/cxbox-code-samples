package org.demo.documentation.datetimewithseconds.validationbusinessex;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample300Meta extends FieldMetaBuilder<MyExample300DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample300DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample300DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample300DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample300DTO_.customField);
    }

}