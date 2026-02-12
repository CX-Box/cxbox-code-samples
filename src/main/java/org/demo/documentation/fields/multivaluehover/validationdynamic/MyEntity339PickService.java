package org.demo.documentation.fields.multivaluehover.validationdynamic;

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
public class MyEntity339PickService extends VersionAwareResponseService<MyEntity339PickDTO, MyEntity339> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity339PickMeta> meta = MyEntity339PickMeta.class;

	@Override
	protected CreateResult<MyEntity339PickDTO> doCreateEntity(MyEntity339 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity339PickDTO> doUpdateEntity(MyEntity339 entity, MyEntity339PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}