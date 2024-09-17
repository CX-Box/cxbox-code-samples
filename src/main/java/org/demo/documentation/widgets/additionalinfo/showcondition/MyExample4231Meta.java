package org.demo.documentation.widgets.additionalinfo.showcondition;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample4231Meta extends FieldMetaBuilder<MyExample4231DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4231DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4231DTO_.customFieldNum);
        fields.setEnabled(MyExample4231DTO_.customField);
        fields.setRequired(MyExample4231DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4231DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4231DTO_.customFieldNum);
        fields.enableSort(MyExample4231DTO_.customFieldNum);
    }

}
