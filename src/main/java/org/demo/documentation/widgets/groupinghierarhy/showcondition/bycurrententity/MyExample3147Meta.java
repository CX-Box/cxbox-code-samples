package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3147Meta extends FieldMetaBuilder<MyExample3147DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3147DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3147DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3147DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3147DTO_.customField);
        fields.setRequired(MyExample3147DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3147DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3147DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3147DTO_.customFieldDictionary);
    }

}