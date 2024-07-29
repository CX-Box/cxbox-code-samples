package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3071Meta extends FieldMetaBuilder<MyExample3071DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3071DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3071DTO_.customFieldId);
        fields.setEnabled(MyExample3071DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3071DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3071DTO_.customField);
    }

}