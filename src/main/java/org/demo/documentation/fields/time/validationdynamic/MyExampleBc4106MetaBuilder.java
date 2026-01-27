package org.demo.documentation.fields.time.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc4106MetaBuilder extends FieldMetaBuilder<MyExampleBc4106DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc4106DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
        fields.setEnabled(MyExampleBc4106DTO_.customFieldAdditional);
        fields.setEnabled(MyExampleBc4106DTO_.customField);
        fields.setEnabled(
                org.demo.documentation.fields.time.validationdynamic.MyExampleBc4106DTO_.id
        );
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExampleBc4106DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExampleBc4106DTO_.customFieldAdditional);
        fields.enableFilter(MyExampleBc4106DTO_.customField);
        fields.enableFilter(
                org.demo.documentation.fields.time.validationdynamic.MyExampleBc4106DTO_.id
        );
        fields.enableSort(
                org.demo.documentation.fields.time.validationdynamic.MyExampleBc4106DTO_.id
        );
    }

}
