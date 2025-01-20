package org.demo.documentation.widgets.assoc.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3078AssocPickMeta extends FieldMetaBuilder<MyEntity3078AssocPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3078AssocPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3078AssocPickDTO_.customFieldNumber);
        fields.setEnabled(MyEntity3078AssocPickDTO_.customFieldText);
        fields.setEnabled(org.demo.documentation.widgets.assoc.customizationcolumns.MyEntity3078AssocPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.assoc.customizationcolumns.MyEntity3078AssocPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3078AssocPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3078AssocPickDTO_.customFieldNumber);
        fields.enableFilter(MyEntity3078AssocPickDTO_.customFieldText);

    }

}
