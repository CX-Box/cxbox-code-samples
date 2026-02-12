package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4300MultivalueHoverService extends VersionAwareResponseService<MyExample4300MultivalueHoverDTO, MyEntity4300MultivalueHover> {

	private final MyEntity4300MultivalueHoverRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300MultivalueHoverMeta> meta = MyExample4300MultivalueHoverMeta.class;

	@Override
	protected CreateResult<MyExample4300MultivalueHoverDTO> doCreateEntity(final MyEntity4300MultivalueHover entity, final BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyExample4300MultivalueHoverDTO> doUpdateEntity(final MyEntity4300MultivalueHover entity,
																			  final MyExample4300MultivalueHoverDTO data,
																			  final BusinessComponent bc) {
		return null;
	}

}
