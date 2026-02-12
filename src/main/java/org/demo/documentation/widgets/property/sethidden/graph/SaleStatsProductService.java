package org.demo.documentation.widgets.property.sethidden.graph;


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
public class SaleStatsProductService extends AnySourceVersionAwareResponseService<SalesProductDTO, SalesProductDTO> {

	@Getter(onMethod_ = @Override)
	private final Class<SaleStatsProductMeta> meta = SaleStatsProductMeta.class;

	@Getter(onMethod_ = @Override)
	private final Class<SaleStatsProductDao> dao = SaleStatsProductDao.class;

	@Override
	protected CreateResult<SalesProductDTO> doCreateEntity(SalesProductDTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<SalesProductDTO> doUpdateEntity(SalesProductDTO entity, SalesProductDTO data, BusinessComponent bc) {
		throw new IllegalStateException();
	}

}

