package org.demo.documentation.fields.picktree.validationannotation;

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
public class MyEntity3291PickService extends VersionAwareResponseService<MyEntity3291PickDTO, MyEntity3291Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3291PickMeta> meta = MyEntity3291PickMeta.class;

	@Override
	protected CreateResult<MyEntity3291PickDTO> doCreateEntity(MyEntity3291Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3291PickDTO> doUpdateEntity(MyEntity3291Pick entity, MyEntity3291PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}