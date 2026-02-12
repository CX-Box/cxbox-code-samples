package org.demo.documentation.widgets.info.base.allfields.forfields;

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
public class MyEntity4222MultiMultivalueService extends VersionAwareResponseService<MyEntity4222MultiMultivalueDTO, MyEntity4222Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4222MultiMultivalueMeta> meta = MyEntity4222MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity4222MultiMultivalueDTO> doCreateEntity(MyEntity4222Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity4222MultiMultivalueDTO> doUpdateEntity(MyEntity4222Multi entity, MyEntity4222MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		return null;
	}


}