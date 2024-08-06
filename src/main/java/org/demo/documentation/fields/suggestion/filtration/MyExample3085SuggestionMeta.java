package org.demo.documentation.fields.suggestion.filtration;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3085SuggestionMeta extends AnySourceFieldMetaBuilder<MyExample3085SuggestionDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3085SuggestionDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3085SuggestionDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
