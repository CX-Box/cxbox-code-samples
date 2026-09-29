package org.demo.documentation.widgets.pie1d.drilldown.drilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.pie1d.drilldown.data.MyExample4219SaleDTO;
import org.demo.documentation.widgets.pie1d.drilldown.data.MyExample4219SaleMeta;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingData;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4219SaleService extends VersionAwareResponseService<MyExample4219SaleDTO, MyEntityRingData> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4219SaleMeta> meta = MyExample4219SaleMeta.class;

	@Override
	protected CreateResult<MyExample4219SaleDTO> doCreateEntity(MyEntityRingData entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4219SaleDTO> doUpdateEntity(MyEntityRingData entity, MyExample4219SaleDTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
