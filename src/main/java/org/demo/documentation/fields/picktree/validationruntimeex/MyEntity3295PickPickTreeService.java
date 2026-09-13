package org.demo.documentation.fields.picktree.validationruntimeex;

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
public class MyEntity3295PickPickTreeService extends VersionAwareResponseService<MyEntity3295PickDTO, MyEntity3295Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3295PickPickTreeMeta> meta = MyEntity3295PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3295PickDTO> doCreateEntity(MyEntity3295Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3295PickDTO> doUpdateEntity(MyEntity3295Pick entity, MyEntity3295PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}