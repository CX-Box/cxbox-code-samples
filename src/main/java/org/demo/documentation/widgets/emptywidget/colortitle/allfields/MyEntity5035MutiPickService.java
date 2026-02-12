package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5035MutiPickService extends VersionAwareResponseService<MyEntity5035MutiPickDTO, MyEntity5035Muti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity5035MutiPickMeta> meta = MyEntity5035MutiPickMeta.class;

	@Override
	protected CreateResult<MyEntity5035MutiPickDTO> doCreateEntity(MyEntity5035Muti entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity5035MutiPickDTO> doUpdateEntity(MyEntity5035Muti entity, MyEntity5035MutiPickDTO data,
																	  BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}