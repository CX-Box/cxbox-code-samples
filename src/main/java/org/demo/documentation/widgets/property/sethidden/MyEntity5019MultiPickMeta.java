package org.demo.documentation.widgets.property.sethidden;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum1;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity5019MultiPickMeta extends FieldMetaBuilder<MyEntity5019MultiPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity5019MultiPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        if (Objects.equals(fields.getCurrentValue(MyEntity5019MultiPickDTO_.customFieldDictionary).orElse(null),
                CustomFieldDictionaryEnum1.LOW)) {
            fields.setHidden(MyEntity5019MultiPickDTO_.customField);
        }

        fields.setEnumValues(MyEntity5019MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum1.values());
        fields.setEnabled(MyEntity5019MultiPickDTO_.customFieldDictionary);
        fields.setEnabled(org.demo.documentation.widgets.property.sethidden.MyEntity5019MultiPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.property.sethidden.MyEntity5019MultiPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity5019MultiPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setEnumFilterValues(fields, MyEntity5019MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum1.values());
        fields.enableFilter(MyEntity5019MultiPickDTO_.customFieldDictionary);

    }

}
