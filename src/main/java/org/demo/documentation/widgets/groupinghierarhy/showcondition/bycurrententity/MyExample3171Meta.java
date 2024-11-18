package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3171Meta extends FieldMetaBuilder<MyExample3171DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3171DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3171DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3171DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3171DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3171DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3171DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3171DTO_.customFieldDictionary);
    }

}