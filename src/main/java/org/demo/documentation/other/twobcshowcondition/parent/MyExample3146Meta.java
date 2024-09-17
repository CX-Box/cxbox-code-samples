package org.demo.documentation.other.twobcshowcondition.parent;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
public class MyExample3146Meta extends FieldMetaBuilder<MyExample3146DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3146DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3146DTO_.customField);
        fields.setRequired(MyExample3146DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3146DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample3146DTO_.customField);
    }

}