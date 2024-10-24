package org.demo.documentation.fields.suggestion.ro;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3088SuggestionMeta extends AnySourceFieldMetaBuilder<MyExample3088SuggestionDTO> {

    @Override
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3088SuggestionDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3088SuggestionDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
