package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;
import org.springframework.stereotype.Service;

@Service
public class MyExample4216Meta extends FieldMetaBuilder<MyExample4216DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4216DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnumValues(MyExample4216DTO_.status, ExampleStatus.values());
      fields.setEnabled(MyExample4216DTO_.status);
      fields.setEnabled(MyExample4216DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4216DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.setEnumFilterValues(fields, MyExample4216DTO_.status, ExampleStatus.values());
      fields.enableFilter(MyExample4216DTO_.status);
    }

}