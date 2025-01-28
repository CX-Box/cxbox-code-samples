package org.demo.documentation.widgets.picklist.actions.cancelcreate;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3198Meta extends FieldMetaBuilder<MyExample3198DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3198DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3198DTO_.customFieldPickListId);
        fields.setEnabled(MyExample3198DTO_.customFieldPickList);
        fields.setEnabled(MyExample3198DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3198DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3198DTO_.customFieldPickList);
    }

}