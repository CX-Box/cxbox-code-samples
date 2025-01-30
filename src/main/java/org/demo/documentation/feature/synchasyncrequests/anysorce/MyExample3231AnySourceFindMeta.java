package org.demo.documentation.feature.synchasyncrequests.anysorce;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3231AnySourceFindMeta extends AnySourceFieldMetaBuilder<MyExample3231AnySourceFindDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3231AnySourceFindDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
        fields.setEnabled(MyExample3231AnySourceFindDTO_.customField);
        fields.setEnabled(MyExample3231AnySourceFindDTO_.customFieldForm);
        fields.setPlaceholder(MyExample3231AnySourceFindDTO_.customField, "input a value - `data`");
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3231AnySourceFindDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
