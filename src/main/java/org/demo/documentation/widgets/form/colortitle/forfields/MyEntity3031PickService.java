package org.demo.documentation.widgets.form.colortitle.forfields;

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
public class MyEntity3031PickService extends VersionAwareResponseService<MyEntity3031PickDTO, MyEntity3031> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3031PickMeta> meta = MyEntity3031PickMeta.class;

	@Override
	protected CreateResult<MyEntity3031PickDTO> doCreateEntity(MyEntity3031 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3031PickDTO> doUpdateEntity(MyEntity3031 entity, MyEntity3031PickDTO data,
																  BusinessComponent bc) {
		return null;
	}


}