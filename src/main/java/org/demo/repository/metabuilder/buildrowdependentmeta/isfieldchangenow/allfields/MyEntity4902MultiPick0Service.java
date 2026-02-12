package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

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
public class MyEntity4902MultiPick0Service extends VersionAwareResponseService<MyEntity4902MultiPick0DTO, MyEntity4902Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4902MultiPick0Meta> meta = MyEntity4902MultiPick0Meta.class;

	@Override
	protected CreateResult<MyEntity4902MultiPick0DTO> doCreateEntity(MyEntity4902Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity4902MultiPick0DTO> doUpdateEntity(MyEntity4902Multi entity, MyEntity4902MultiPick0DTO data,
																		BusinessComponent bc) {
		return null;
	}


}