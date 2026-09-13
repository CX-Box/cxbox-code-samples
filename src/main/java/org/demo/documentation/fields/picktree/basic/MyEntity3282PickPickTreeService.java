package org.demo.documentation.fields.picktree.basic;

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
public class MyEntity3282PickPickTreeService extends VersionAwareResponseService<MyEntity3282PickDTO, MyEntity3282Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3282PickPickTreeMeta> meta = MyEntity3282PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3282PickDTO> doCreateEntity(MyEntity3282Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3282PickDTO> doUpdateEntity(MyEntity3282Pick entity, MyEntity3282PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}