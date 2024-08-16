package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3062Meta extends FieldMetaBuilder<MyExample3062DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3062DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3062DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3062DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3062DTO_.customField);
    }

}