package org.demo.documentation;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc832MetaBuilder extends FieldMetaBuilder<MyExampleBc832DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc832DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
        fields.setEnabled(
                org.demo.documentation.MyExampleBc832DTO_.id);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExampleBc832DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(
                org.demo.documentation.MyExampleBc832DTO_.id);
        fields.enableSort(
                org.demo.documentation.MyExampleBc832DTO_.id);
    }

}
