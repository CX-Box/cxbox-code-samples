package org.demo.documentation.feature.drilldown.goingforwardafterdrilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3621Meta extends FieldMetaBuilder<MyExample3621DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3621DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3621DTO_.customField);
        fields.setRequired(MyExample3621DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3621DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}