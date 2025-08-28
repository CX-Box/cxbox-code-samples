package org.demo.documentation.widgets.property.sethidden.graph.pie;

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
public class SaleStatsProductPieMeta extends AnySourceFieldMetaBuilder<SalesProductPieDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<SalesProductPieDTO> fields, BcDescription bc,
                                      String id, String parentId) {
        if (Objects.equals(fields.getCurrentValue(SalesProductPieDTO_.title).orElse(null),
                ProductNameEnum.EQUIPMENT)) {
            fields.setHidden(SalesProductPieDTO_.value);
        }
    }


    @Override
    public void buildIndependentMeta(FieldsMeta<SalesProductPieDTO> fields, BcDescription bcDescription,
                                     String parentId) {
        // do nothing
    }

}
