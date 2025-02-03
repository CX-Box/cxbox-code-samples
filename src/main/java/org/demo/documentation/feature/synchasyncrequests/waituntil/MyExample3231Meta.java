package org.demo.documentation.feature.synchasyncrequests.waituntil;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3231Meta extends FieldMetaBuilder<MyExample3231DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3231DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3231DTO_.customFieldForm);
        fields.setEnumValues(MyExample3231DTO_.statusResponse, StatusEnum.values());
        fields.setEnabled(MyExample3231DTO_.statusResponse);
        fields.setEnabled(MyExample3231DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3231DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3231DTO_.customFieldForm);
        fields.setEnumFilterValues(fields, MyExample3231DTO_.statusResponse, StatusEnum.values());
        fields.enableFilter(MyExample3231DTO_.statusResponse);

    }

}