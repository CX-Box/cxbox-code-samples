package org.demo.documentation.fields.dictionary.dictionarylov.anysorce.dictionaryanysource;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample380Meta extends AnySourceFieldMetaBuilder<MyExample380DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample380DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample380DTO> fields, BcDescription bcDescription, String parentId) {
    }

}
