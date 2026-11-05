package org.demo.documentation.widgets.dualaxes2d.drilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.dualaxes2d.data.MyEntity4280;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4286ListService extends VersionAwareResponseService<MyExample4286ListDTO, MyEntity4280> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4286ListMeta> meta = MyExample4286ListMeta.class;

	@Override
	protected CreateResult<MyExample4286ListDTO> doCreateEntity(MyEntity4280 entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4286ListDTO> doUpdateEntity(MyEntity4280 entity, MyExample4286ListDTO data, BusinessComponent bc) {
		throw new IllegalStateException();
	}
}
