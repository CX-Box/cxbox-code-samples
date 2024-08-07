package org.demo.documentation.feature.customizationcolumns;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3135Meta extends FieldMetaBuilder<MyExample3135DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3135DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3135DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3135DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3135DTO_.customFieldCheckBox);
        fields.setEnabled(MyExample3135DTO_.customFieldDate);
        fields.setEnabled(MyExample3135DTO_.customFieldInput);
        fields.setEnabled(MyExample3135DTO_.customField);
        fields.setRequired(MyExample3135DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3135DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3135DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3135DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3135DTO_.customFieldCheckBox);
        fields.enableFilter(MyExample3135DTO_.customFieldDate);
        fields.enableFilter(MyExample3135DTO_.customFieldInput);
    }

}