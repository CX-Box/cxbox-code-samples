package org.demo.documentation.widgets.info.showcondition.bycurrententity;

import org.cxbox.api.data.dto.rowmeta.FieldDTO;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyExample3103Meta extends FieldMetaBuilder<MyExample3103DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3103DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3103DTO_.customFieldNumber);
        fields.setEnabled(MyExample3103DTO_.customFieldText);
        fields.setEnabled(MyExample3103DTO_.customField);
        if ("true".equals(fields.get(MyExample3103DTO_.customFieldShowCond).getCurrentValue())) {
            fields.setHidden(MyExample3103DTO_.customFieldText);
        }
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3103DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3103DTO_.customFieldNumber);
        fields.enableFilter(MyExample3103DTO_.customFieldText);
        fields.enableFilter(MyExample3103DTO_.customField);
    }
    // --8<-- [end:buildIndependentMeta]
}