package org.demo.documentation.widgets.assoc.colortitle.colorconst;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3056MultiPick0Meta extends FieldMetaBuilder<MyEntity3056MultiPick0DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3056MultiPick0DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3056MultiPick0DTO_.customFieldText);
        fields.setEnabled(MyEntity3056MultiPick0DTO_.id);
        fields.setEnabled(MyEntity3056MultiPick0DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3056MultiPick0DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3056MultiPick0DTO_.customFieldText);

    }

}
