package org.demo.documentation.widgets.column2d.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.column2d.data.MyEntity4252;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@Service
public class MyExample4258SaleService extends VersionAwareResponseService<MyExample4258SaleDTO, MyEntity4252> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4258SaleMeta> meta = MyExample4258SaleMeta.class;

	@Override
	protected CreateResult<MyExample4258SaleDTO> doCreateEntity(MyEntity4252 entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4258SaleDTO> doUpdateEntity(MyEntity4252 entity, MyExample4258SaleDTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
