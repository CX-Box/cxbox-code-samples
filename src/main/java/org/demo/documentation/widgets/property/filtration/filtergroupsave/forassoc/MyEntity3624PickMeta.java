package org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3624PickMeta extends FieldMetaBuilder<MyEntity3624PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3624PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyEntity3624PickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyEntity3624PickDTO_.customFieldDictionary);
        fields.setEnabled(MyEntity3624PickDTO_.id);
        fields.setEnabled(MyEntity3624PickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3624PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setEnumFilterValues(fields, MyEntity3624PickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyEntity3624PickDTO_.customFieldDictionary);
        fields.enableFilter(MyEntity3624PickDTO_.customField);
    }

}
