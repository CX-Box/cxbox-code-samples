package org.demo.documentation.widgets.groupinghierarhy.fieldslayoute;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.groupinghierarhy.fieldslayoute.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3140Meta extends FieldMetaBuilder<MyExample3140DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3140DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3140DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3140DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3140DTO_.customField);
        fields.setRequired(MyExample3140DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3140DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumFilterValues(fields, MyExample3140DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3140DTO_.customFieldDictionary);
    }

}