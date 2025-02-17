package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3170Meta extends FieldMetaBuilder<MyExample3170DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3170DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3170DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3170DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3170DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3170DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3170DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3170DTO_.customFieldDictionary);
    }

}