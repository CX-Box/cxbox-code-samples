package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3191MultiHoverPickService extends VersionAwareResponseService<MyEntity3191MultiHoverPickDTO, MyEntity3191MultiHover> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3191MultiHoverPickMeta> meta = MyEntity3191MultiHoverPickMeta.class;

	@Override
	protected CreateResult<MyEntity3191MultiHoverPickDTO> doCreateEntity(MyEntity3191MultiHover entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3191MultiHoverPickDTO> doUpdateEntity(MyEntity3191MultiHover entity, MyEntity3191MultiHoverPickDTO data,
																			BusinessComponent bc) {
		return null;
	}


}