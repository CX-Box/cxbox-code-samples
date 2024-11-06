package org.demo.documentation.fields.dictionary.icon.picklistpopup;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3012PickMeta extends FieldMetaBuilder<MyEntity3012PickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3012PickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyEntity3012PickDTO_.customField);
        fields.setEnabled(MyEntity3012PickDTO_.id);
        fields.setEnabled(MyEntity3012PickDTO_.customFieldDictionary);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyEntity3012PickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.enableFilter(MyEntity3012PickDTO_.customField);
        fields.setAllValuesWithIcons(MyEntity3012PickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.iconMap());
        fields.enableFilter(MyEntity3012PickDTO_.customFieldDictionary);
        fields.setEnumFilterValues(fields, MyEntity3012PickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumValues(MyEntity3012PickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
    }

}
