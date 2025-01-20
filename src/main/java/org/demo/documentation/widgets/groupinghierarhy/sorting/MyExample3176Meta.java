package org.demo.documentation.widgets.groupinghierarhy.sorting;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.sorting.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3176Meta extends FieldMetaBuilder<MyExample3176DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3176DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3176DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3176DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3176DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3176DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3176DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3176DTO_.customFieldDictionary);
        fields.enableSort(MyExample3176DTO_.customFieldDictionary);
        fields.enableSort(MyExample3176DTO_.customField);
    }

}