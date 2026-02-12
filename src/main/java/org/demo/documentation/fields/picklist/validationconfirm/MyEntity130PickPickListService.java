package org.demo.documentation.fields.picklist.validationconfirm;

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
public class MyEntity130PickPickListService extends VersionAwareResponseService<MyEntity130PickDTO, MyEntity130> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity130PickPickListMeta> meta = MyEntity130PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity130PickDTO> doCreateEntity(MyEntity130 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity130PickDTO> doUpdateEntity(MyEntity130 entity, MyEntity130PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}