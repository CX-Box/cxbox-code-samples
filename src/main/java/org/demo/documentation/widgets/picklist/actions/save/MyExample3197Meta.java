package org.demo.documentation.widgets.picklist.actions.save;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3197Meta extends FieldMetaBuilder<MyExample3197DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3197DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3197DTO_.customFieldPickListId);
      fields.setEnabled(MyExample3197DTO_.customFieldPickList);
      fields.setEnabled(MyExample3197DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3197DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.enableFilter(MyExample3197DTO_.customFieldPickList);
    }

}