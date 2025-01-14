package org.demo.documentation.fields.dictionary.dictionarydictionary.anysorce;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample381Meta extends FieldMetaBuilder<MyExample381DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample381DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample381DTO_.customField);

        fields.setDictionaryValues(MyExample381DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample381DTO> fields, InnerBcDescription bcDescription, Long parentId) {
    }

}