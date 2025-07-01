package org.demo.documentation.other.drilldown.option.any;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3424Meta extends AnySourceFieldMetaBuilder<MyExample3424DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3424DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
        fields.setEnabled(MyExample3424DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3424DTO> fields, BcDescription bcDescription, String parentId) {
        fields.enableFilter(MyExample3424DTO_.customField);
    }

}
