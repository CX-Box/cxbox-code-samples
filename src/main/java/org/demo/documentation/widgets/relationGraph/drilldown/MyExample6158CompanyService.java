package org.demo.documentation.widgets.relationGraph.drilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6158CompanyService extends VersionAwareResponseService<MyExample6158CompanyDTO, MyEntity6151> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6158CompanyMeta> meta = MyExample6158CompanyMeta.class;

	@Override
	protected CreateResult<MyExample6158CompanyDTO> doCreateEntity(MyEntity6151 entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample6158CompanyDTO> doUpdateEntity(MyEntity6151 entity, MyExample6158CompanyDTO data, BusinessComponent bc) {
		throw new IllegalStateException();
	}
}
