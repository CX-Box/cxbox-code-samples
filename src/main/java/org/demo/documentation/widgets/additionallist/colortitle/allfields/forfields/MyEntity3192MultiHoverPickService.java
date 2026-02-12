package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

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
public class MyEntity3192MultiHoverPickService extends VersionAwareResponseService<MyEntity3192MultiHoverPickDTO, MyEntity3192MultiHover> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3192MultiHoverPickMeta> meta = MyEntity3192MultiHoverPickMeta.class;

	@Override
	protected CreateResult<MyEntity3192MultiHoverPickDTO> doCreateEntity(MyEntity3192MultiHover entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3192MultiHoverPickDTO> doUpdateEntity(MyEntity3192MultiHover entity, MyEntity3192MultiHoverPickDTO data,
																			BusinessComponent bc) {
		return null;
	}


}