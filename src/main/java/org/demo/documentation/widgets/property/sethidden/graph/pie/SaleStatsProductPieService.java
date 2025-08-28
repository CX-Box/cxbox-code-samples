package org.demo.documentation.widgets.property.sethidden.graph.pie;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class SaleStatsProductPieService extends AnySourceVersionAwareResponseService<SalesProductPieDTO, SalesProductPieDTO> {

    @Getter(onMethod_ = @Override)
    private final Class<SaleStatsProductPieMeta> meta = SaleStatsProductPieMeta.class;

    @Getter(onMethod_ = @Override)
    private final Class<SaleStatsProductPieDao> dao = SaleStatsProductPieDao.class;

    @Override
    protected CreateResult<SalesProductPieDTO> doCreateEntity(SalesProductPieDTO entity, BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    protected ActionResultDTO<SalesProductPieDTO> doUpdateEntity(SalesProductPieDTO entity, SalesProductPieDTO data, BusinessComponent bc) {
        throw new IllegalStateException();
    }

}

