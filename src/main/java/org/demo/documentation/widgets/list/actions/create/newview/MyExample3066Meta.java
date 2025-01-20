package org.demo.documentation.widgets.list.actions.create.newview;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3066Meta extends FieldMetaBuilder<MyExample3066DTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3066DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3066DTO_.customFieldText);
        fields.setEnabled(MyExample3066DTO_.customField);
        fields.setRequired(MyExample3066DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3066DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3066DTO_.customFieldText);
        fields.enableSort(MyExample3066DTO_.customFieldText);
        fields.enableSort(MyExample3066DTO_.customField);
    }

}