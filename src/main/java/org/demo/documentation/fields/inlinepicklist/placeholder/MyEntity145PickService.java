package org.demo.documentation.fields.inlinepicklist.placeholder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.fields.inlinepicklist.placeholder.picklist.MyEntity145;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity145PickService extends VersionAwareResponseService<MyEntity145PickDTO, MyEntity145> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity145PickMeta> meta = MyEntity145PickMeta.class;

	@Override
	protected CreateResult<MyEntity145PickDTO> doCreateEntity(MyEntity145 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity145PickDTO> doUpdateEntity(MyEntity145 entity, MyEntity145PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}