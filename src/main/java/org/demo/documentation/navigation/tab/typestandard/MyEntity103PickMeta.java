package org.demo.documentation.navigation.tab.typestandard;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity103PickMeta extends FieldMetaBuilder<MyEntity103PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity103PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.navigation.tab.typestandard.MyEntity103PickDTO_.id);
        fields.setEnabled(org.demo.documentation.navigation.tab.typestandard.MyEntity103PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity103PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
