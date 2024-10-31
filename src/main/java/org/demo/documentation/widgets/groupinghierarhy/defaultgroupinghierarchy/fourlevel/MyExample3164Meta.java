package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3164Meta extends FieldMetaBuilder<MyExample3164DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3164DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3164DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3164DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}