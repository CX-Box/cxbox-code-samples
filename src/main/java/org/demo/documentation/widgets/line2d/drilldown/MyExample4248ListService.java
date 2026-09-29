package org.demo.documentation.widgets.line2d.drilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.line2d.data.MyEntity4240;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4248ListService extends VersionAwareResponseService<MyExample4248ListDTO, MyEntity4240> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4248ListMeta> meta = MyExample4248ListMeta.class;

	@Override
	protected CreateResult<MyExample4248ListDTO> doCreateEntity(MyEntity4240 entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4248ListDTO> doUpdateEntity(MyEntity4240 entity, MyExample4248ListDTO data, BusinessComponent bc) {
		throw new IllegalStateException();
	}
}
