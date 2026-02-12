package org.demo.documentation.fields.multivaluehover.placeholder;

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
public class MyEntityMulti235PickService extends VersionAwareResponseService<MyEntityMulti235PickDTO, MyEntityMulti235> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntityMulti235PickMeta> meta = MyEntityMulti235PickMeta.class;

	@Override
	protected CreateResult<MyEntityMulti235PickDTO> doCreateEntity(MyEntityMulti235 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntityMulti235PickDTO> doUpdateEntity(MyEntityMulti235 entity, MyEntityMulti235PickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}