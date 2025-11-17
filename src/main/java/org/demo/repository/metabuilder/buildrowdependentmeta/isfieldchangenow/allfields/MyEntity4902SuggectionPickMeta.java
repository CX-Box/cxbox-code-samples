package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4902SuggectionPickMeta extends FieldMetaBuilder<MyEntity4902SuggectionPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity4902SuggectionPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity4902SuggectionPickDTO_.id);
        fields.setEnabled(MyEntity4902SuggectionPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity4902SuggectionPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
