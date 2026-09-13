package org.demo.documentation.fields.picktree.validationdynamic;

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
public class MyEntity3294PickPickService extends VersionAwareResponseService<MyEntity3294PickPickDTO, MyEntity3294Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3294PickPickMeta> meta = MyEntity3294PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3294PickPickDTO> doCreateEntity(MyEntity3294Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3294PickPickDTO> doUpdateEntity(MyEntity3294Pick entity, MyEntity3294PickPickDTO data,
																	 BusinessComponent bc) {
		return null;
	}


}