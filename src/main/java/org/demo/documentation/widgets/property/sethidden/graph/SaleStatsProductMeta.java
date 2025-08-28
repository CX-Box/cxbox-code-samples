package org.demo.documentation.widgets.property.sethidden.graph;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SaleStatsProductMeta extends AnySourceFieldMetaBuilder<SalesProductDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<SalesProductDTO> fields, BcDescription bc,
                                      String id, String parentId) {
        if (Objects.equals(fields.getCurrentValue(SalesProductDTO_.productName).orElse(null),
                ProductNameEnum.EQUIPMENT)) {
            fields.setHidden(SalesProductDTO_.clientName);
        }
    }


    @Override
    public void buildIndependentMeta(FieldsMeta<SalesProductDTO> fields, BcDescription bcDescription,
                                     String parentId) {
        // do nothing
    }

}
