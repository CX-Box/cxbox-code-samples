package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

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
public class MyEntity4903OCPPickPickService extends VersionAwareResponseService<MyEntity4903OCPPickPickDTO, MyEntity4903OCPPick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4903OCPPickPickMeta> meta = MyEntity4903OCPPickPickMeta.class;

	@Override
	protected CreateResult<MyEntity4903OCPPickPickDTO> doCreateEntity(MyEntity4903OCPPick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity4903OCPPickPickDTO> doUpdateEntity(MyEntity4903OCPPick entity, MyEntity4903OCPPickPickDTO data,
																		 BusinessComponent bc) {
		return null;
	}


}