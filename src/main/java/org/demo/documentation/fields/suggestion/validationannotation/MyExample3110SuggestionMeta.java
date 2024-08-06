package org.demo.documentation.fields.suggestion.validationannotation;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3110SuggestionMeta extends AnySourceFieldMetaBuilder<MyExample3110SuggestionDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3110SuggestionDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3110SuggestionDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
