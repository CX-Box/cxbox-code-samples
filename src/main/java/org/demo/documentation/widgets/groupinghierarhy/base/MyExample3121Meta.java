package org.demo.documentation.widgets.groupinghierarhy.base;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3121Meta extends FieldMetaBuilder<MyExample3121DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3121DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3121DTO_.customFieldCheckbox);
        fields.setEnumValues(MyExample3121DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3121DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3121DTO_.customField);
        fields.setRequired(MyExample3121DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3121DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3121DTO_.customFieldCheckbox);
        fields.enableSort(MyExample3121DTO_.customFieldCheckbox);
        fields.setEnumFilterValues(fields, MyExample3121DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3121DTO_.customFieldDictionary);
        fields.enableSort(MyExample3121DTO_.customFieldDictionary);
        fields.enableSort(MyExample3121DTO_.customField);
    }

}