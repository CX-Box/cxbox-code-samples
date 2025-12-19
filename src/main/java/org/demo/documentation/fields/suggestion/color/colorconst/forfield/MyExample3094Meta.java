package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.suggestion.color.colorconst.forfield.enums.ResidentTypeEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3094Meta extends FieldMetaBuilder<MyExample3094DTO> {

    @Override
    // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3094DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3094DTO_.inn2Id);
        fields.setEnabled(MyExample3094DTO_.inn2);
        fields.setEnabled(MyExample3094DTO_.inn);
        fields.setEnabled(MyExample3094DTO_.rusFullName);
        fields.setEnabled(MyExample3094DTO_.rusShortNameId);
        fields.setEnabled(MyExample3094DTO_.rusShortName);
        fields.setEnumValues(MyExample3094DTO_.residentType, ResidentTypeEnum.values());
        fields.setEnabled(MyExample3094DTO_.residentType);
        fields.setEnabled(MyExample3094DTO_.customField);
    }

    // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3094DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3094DTO_.inn2);
        fields.enableFilter(MyExample3094DTO_.inn);
        fields.enableFilter(MyExample3094DTO_.rusFullName);
        fields.enableFilter(MyExample3094DTO_.rusShortName);
        fields.setEnumFilterValues(fields, MyExample3094DTO_.residentType, ResidentTypeEnum.values());
        fields.enableFilter(MyExample3094DTO_.residentType);
    }

}