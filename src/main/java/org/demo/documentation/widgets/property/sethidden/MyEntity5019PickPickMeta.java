package org.demo.documentation.widgets.property.sethidden;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum2;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity5019PickPickMeta extends FieldMetaBuilder<MyEntity5019PickPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity5019PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        if (Objects.equals(fields.getCurrentValue(MyEntity5019PickPickDTO_.customFieldDictionary).orElse(null),
                CustomFieldDictionaryEnum2.LOW)) {
            fields.setHidden(MyEntity5019PickPickDTO_.customField);
        }

        fields.setEnumValues(MyEntity5019PickPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum2.values());
        fields.setEnabled(MyEntity5019PickPickDTO_.customFieldDictionary);
        fields.setEnabled(org.demo.documentation.widgets.property.sethidden.MyEntity5019PickPickDTO_.id);
        fields.setEnabled(org.demo.documentation.widgets.property.sethidden.MyEntity5019PickPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity5019PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setEnumFilterValues(fields, MyEntity5019PickPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum2.values());
        fields.enableFilter(MyEntity5019PickPickDTO_.customFieldDictionary);

    }

}
