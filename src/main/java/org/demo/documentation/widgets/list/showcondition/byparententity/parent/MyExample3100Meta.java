package org.demo.documentation.widgets.list.showcondition.byparententity.parent;

import lombok.AllArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.list.showcondition.bycurrententity.MyExample3101DTO_;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyExample3100Meta extends FieldMetaBuilder<MyExample3100DTO> {
    private final DocumentConfig configuration;

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3100DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3100DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3100DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3100DTO_.customField);

    }

}