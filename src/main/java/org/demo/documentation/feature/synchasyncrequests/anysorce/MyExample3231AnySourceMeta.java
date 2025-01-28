package org.demo.documentation.feature.synchasyncrequests.anysorce;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3231AnySourceMeta extends AnySourceFieldMetaBuilder<MyExample3231AnySourceDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3231AnySourceDTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
   }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3231AnySourceDTO> fields, BcDescription bcDescription, String parentId) {
    }

}
