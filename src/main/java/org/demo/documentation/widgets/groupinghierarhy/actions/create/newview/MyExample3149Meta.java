package org.demo.documentation.widgets.groupinghierarhy.actions.create.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3149Meta extends FieldMetaBuilder<MyExample3149DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3149DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3149DTO_.customFieldText);
        fields.setEnabled(MyExample3149DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3149DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3149DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3149DTO_.customFieldText);
        fields.setEnumValues(MyExample3149DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3149DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3149DTO_.customFieldDictionary);
    }

}