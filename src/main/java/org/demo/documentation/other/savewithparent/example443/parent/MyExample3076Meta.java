package org.demo.documentation.other.savewithparent.example443.parent;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.other.savewithparent.example443.child.MyExample3077DTO_;
import org.springframework.stereotype.Service;


@Service
public class MyExample3076Meta extends AnySourceFieldMetaBuilder<MyExample3076DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3076DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
        fields.setEnabled(MyExample3076DTO_.customField);
        fields.setEnabled(MyExample3076DTO_.customFieldNew);
        fields.setRequired(MyExample3076DTO_.customFieldNew);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3076DTO> fields, BcDescription bcDescription, String parentId) {
        fields.enableSort(MyExample3076DTO_.customField);
    }

}
