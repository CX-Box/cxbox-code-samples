package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.widgets.list.base.MyExample3002DTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3101Meta extends FieldMetaBuilder<MyExample3101DTO> {
    private final DocumentConfig configuration;

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3101DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3101DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3101DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3101DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3101DTO_.customField);
        }
    }

}