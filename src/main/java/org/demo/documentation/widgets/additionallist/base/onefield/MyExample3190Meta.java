package org.demo.documentation.widgets.additionallist.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.additionallist.base.onefield.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3190Meta extends FieldMetaBuilder<MyExample3190DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3190DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3190DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3190DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3190DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3190DTO> fields, InnerBcDescription bcDescription, Long parentId) {
         fields.setEnumIcons(MyExample3190DTO_.customFieldDictionary, CustomFieldDictionaryEnum.iconMap());
    }

}