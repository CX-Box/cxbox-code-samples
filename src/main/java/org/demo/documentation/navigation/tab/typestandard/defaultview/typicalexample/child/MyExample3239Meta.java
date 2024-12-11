package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3239Meta extends FieldMetaBuilder<MyExample3239DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3239DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3239DTO_.phoneNumber);
        fields.setEnabled(MyExample3239DTO_.fullName);
        fields.setEnabled(MyExample3239DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3239DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3239DTO_.phoneNumber);
        fields.enableFilter(MyExample3239DTO_.fullName);
    }

}