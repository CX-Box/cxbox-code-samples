package org.demo.documentation.widgets.additionallist.colortitle.twofields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.additionallist.colortitle.twofields.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3196Meta extends FieldMetaBuilder<MyExample3196DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3196DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3196DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3196DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3196DTO_.customFieldText);
        fields.setEnabled(MyExample3196DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3196DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3196DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3196DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3196DTO_.customFieldText);
    }

}