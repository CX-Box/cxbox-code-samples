package org.demo.documentation.widgets.collapse;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.collapse.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3022Meta extends FieldMetaBuilder<MyExample3022DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3022DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3022DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3022DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3022DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3022DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3022DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3022DTO_.customFieldDictionary);
    }

}