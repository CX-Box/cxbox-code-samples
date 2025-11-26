package org.demo.documentation.feature.massoperations;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.massoperations.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample6101Meta extends FieldMetaBuilder<MyExample6101DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6101DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample6101DTO_.customFieldCheckbox);
        fields.setEnumValues(MyExample6101DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample6101DTO_.customFieldDictionary);
        fields.setEnabled(MyExample6101DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample6101DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample6101DTO_.customFieldCheckbox);
        fields.setEnumFilterValues(fields, MyExample6101DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample6101DTO_.customFieldDictionary);
    }

}