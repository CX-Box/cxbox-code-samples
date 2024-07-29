package org.demo.documentation.widgets.picklist.title.withouttitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3069Meta extends FieldMetaBuilder<MyExample3069DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3069DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3069DTO_.customFieldId);
        fields.setEnabled(MyExample3069DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3069DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3069DTO_.customField);
    }

}