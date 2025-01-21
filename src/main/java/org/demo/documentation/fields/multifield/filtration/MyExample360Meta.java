package org.demo.documentation.fields.multifield.filtration;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample360Meta extends FieldMetaBuilder<MyExample360DTO> {
// --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample360DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample360DTO_.customFieldMulti);
        fields.setEnabled(MyExample360DTO_.customFieldAdditionalMulti);
        fields.setEnabled(MyExample360DTO_.customField);
        fields.setEnabled(MyExample360DTO_.informationField);
        fields.setEnabled(MyExample360DTO_.customFieldAdditional);
    }
   // --8<-- [end:buildRowDependentMeta]
  
   // --8<-- [start:buildIndependentMeta]
  @Override
    public void buildIndependentMeta(FieldsMeta<MyExample360DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample360DTO_.customFieldMulti);
        fields.enableFilter(MyExample360DTO_.customFieldAdditionalMulti);
        fields.enableFilter(MyExample360DTO_.customField);
        fields.enableFilter(MyExample360DTO_.informationField);
        fields.enableFilter(MyExample360DTO_.customFieldAdditional);
    }

}