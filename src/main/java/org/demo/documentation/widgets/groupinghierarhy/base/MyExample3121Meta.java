package org.demo.documentation.widgets.groupinghierarhy.base;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3121Meta extends FieldMetaBuilder<MyExample3121DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3121DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3121DTO_.customFieldRadio);
        fields.setEnabled(MyExample3121DTO_.customFieldCheckbox);
        fields.setEnumValues(MyExample3121DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3121DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3121DTO_.customField);
        fields.setRequired(MyExample3121DTO_.customField);
    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3121DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setEnumValues(MyExample3121DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.setEnumFilterValues(fields, MyExample3121DTO_.customFieldRadio, CustomFieldRadioEnum.values());
        fields.enableFilter(MyExample3121DTO_.customFieldRadio);
        fields.enableFilter(MyExample3121DTO_.customFieldCheckbox);
        fields.enableSort(MyExample3121DTO_.customFieldCheckbox);
        fields.setEnumFilterValues(fields, MyExample3121DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3121DTO_.customFieldDictionary);
        fields.enableSort(MyExample3121DTO_.customFieldDictionary);
        fields.enableSort(MyExample3121DTO_.customField);
    }

}