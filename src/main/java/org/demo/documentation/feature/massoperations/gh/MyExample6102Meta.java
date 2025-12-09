package org.demo.documentation.feature.massoperations.gh;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.massoperations.gh.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample6102Meta extends FieldMetaBuilder<MyExample6102DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6102DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample6102DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample6102DTO_.customFieldDictionary);
        fields.setEnabled(MyExample6102DTO_.customFieldCheckbox);
        fields.setEnabled(MyExample6102DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample6102DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample6102DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample6102DTO_.customFieldDictionary);
        fields.enableFilter(MyExample6102DTO_.customFieldCheckbox);
    }

}