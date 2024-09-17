package org.demo.documentation.widgets.list.title;

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
public class MyExample3104Meta extends FieldMetaBuilder<MyExample3104DTO> {

    // --8<-- [start:buildRowDependentMeta]
    private final DocumentConfig configuration;
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3104DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3104DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3104DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3104DTO_.customField);
        fields.enableSort(MyExample3104DTO_.customField);
        if (configuration.getForceActiveEnabled()) {
            fields.setForceActive(MyExample3104DTO_.customField);
        }
    }
    // --8<-- [end:buildIndependentMeta]
}