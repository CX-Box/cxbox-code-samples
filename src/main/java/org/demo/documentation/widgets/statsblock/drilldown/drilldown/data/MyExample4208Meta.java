package org.demo.documentation.widgets.statsblock.drilldown.drilldown.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4208Meta extends FieldMetaBuilder<MyExample4208DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4208DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4208DTO_.customField);
        fields.setEnabled(MyExample4208DTO_.customFieldStatus);
        fields.setEnumValues(MyExample4208DTO_.customFieldStatus, CustomFieldEnum.values());
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4208DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4208DTO_.customField);
        fields.enableSort(MyExample4208DTO_.customField);
        fields.setEnumFilterValues(fields, MyExample4208DTO_.customFieldStatus, CustomFieldEnum.values());
    }
}