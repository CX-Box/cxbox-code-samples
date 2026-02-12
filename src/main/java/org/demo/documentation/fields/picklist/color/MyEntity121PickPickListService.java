package org.demo.documentation.fields.picklist.color;

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
public class MyEntity121PickPickListService extends VersionAwareResponseService<MyEntity121PickDTO, MyEntity121> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity121PickPickListMeta> meta = MyEntity121PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity121PickDTO> doCreateEntity(MyEntity121 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity121PickDTO> doUpdateEntity(MyEntity121 entity, MyEntity121PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}