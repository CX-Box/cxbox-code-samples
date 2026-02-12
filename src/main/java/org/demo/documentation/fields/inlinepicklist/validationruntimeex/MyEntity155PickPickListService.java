package org.demo.documentation.fields.inlinepicklist.validationruntimeex;

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
public class MyEntity155PickPickListService extends
		VersionAwareResponseService<MyEntity155PickDTO, org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity155PickPickListMeta> meta = MyEntity155PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity155PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity155PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155 entity, MyEntity155PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}