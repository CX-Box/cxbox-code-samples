package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

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
public class MyEntity5028PickPick0Service extends VersionAwareResponseService<MyEntity5028PickPick0DTO, MyEntity5028Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity5028PickPick0Meta> meta = MyEntity5028PickPick0Meta.class;

	@Override
	protected CreateResult<MyEntity5028PickPick0DTO> doCreateEntity(MyEntity5028Pick entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity5028PickPick0DTO> doUpdateEntity(MyEntity5028Pick entity, MyEntity5028PickPick0DTO data,
																	   BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}