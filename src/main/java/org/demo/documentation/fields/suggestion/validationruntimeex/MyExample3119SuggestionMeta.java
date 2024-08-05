package org.demo.documentation.fields.suggestion.validationruntimeex;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3119SuggestionMeta extends AnySourceFieldMetaBuilder<MyExample3119SuggestionDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3119SuggestionDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3119SuggestionDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
