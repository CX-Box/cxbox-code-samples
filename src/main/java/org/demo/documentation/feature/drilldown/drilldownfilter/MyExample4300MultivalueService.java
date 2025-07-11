package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

@Service
@RequiredArgsConstructor
public class MyExample4300MultivalueService extends VersionAwareResponseService<MyExample4300MultivalueDTO, MyEntity4300Multivalue> {

	private final MyEntityWithDrilldown4300Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300MultivalueMeta> meta = MyExample4300MultivalueMeta.class;

	@Override
	protected CreateResult<MyExample4300MultivalueDTO> doCreateEntity(final MyEntity4300Multivalue entity, final BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyExample4300MultivalueDTO> doUpdateEntity(final MyEntity4300Multivalue entity, final MyExample4300MultivalueDTO data,
																																			 final BusinessComponent bc) {
		return null;
	}

}
