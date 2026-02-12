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
public class MyEntity3032PickService extends VersionAwareResponseService<MyEntity3032PickDTO, MyEntity3032> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3032PickMeta> meta = MyEntity3032PickMeta.class;

	@Override
	protected CreateResult<MyEntity3032PickDTO> doCreateEntity(MyEntity3032 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3032PickDTO> doUpdateEntity(MyEntity3032 entity, MyEntity3032PickDTO data,
																  BusinessComponent bc) {
		return null;
	}


}