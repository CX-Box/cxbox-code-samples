package org.demo.documentation.fields.suggestion.validationdynamic;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3117SuggestionMeta extends AnySourceFieldMetaBuilder<MyExample3117SuggestionDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3117SuggestionDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3117SuggestionDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
