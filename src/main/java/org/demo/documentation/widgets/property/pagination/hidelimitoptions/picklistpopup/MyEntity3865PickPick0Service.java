package org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity3865PickPick0Service extends VersionAwareResponseService<MyEntity3865PickPick0DTO, MyEntity3865Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3865PickPick0Meta> meta = MyEntity3865PickPick0Meta.class;

	@Override
	protected CreateResult<MyEntity3865PickPick0DTO> doCreateEntity(MyEntity3865Pick entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3865PickPick0DTO> doUpdateEntity(MyEntity3865Pick entity, MyEntity3865PickPick0DTO data,
	                                                                   BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}