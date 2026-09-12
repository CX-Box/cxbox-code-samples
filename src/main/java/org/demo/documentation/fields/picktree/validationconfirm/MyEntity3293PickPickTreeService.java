package org.demo.documentation.fields.picktree.validationconfirm;

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
public class MyEntity3293PickPickTreeService extends VersionAwareResponseService<MyEntity3293PickDTO, MyEntity3293Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3293PickPickTreeMeta> meta = MyEntity3293PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3293PickDTO> doCreateEntity(MyEntity3293Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3293PickDTO> doUpdateEntity(MyEntity3293Pick entity, MyEntity3293PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}