package org.demo.documentation.widgets.picktreepopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.picktreepopup.Myexample3261Pick0Meta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class Myexample3261Pick0Service extends VersionAwareResponseService<Myexample3261Pick0DTO, org.demo.documentation.widgets.picktreepopup.tree.Myexample3261> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261Pick0Meta> meta = Myexample3261Pick0Meta.class;

	@Override
	protected CreateResult<Myexample3261Pick0DTO> doCreateEntity(org.demo.documentation.widgets.picktreepopup.tree.Myexample3261 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3261Pick0DTO> doUpdateEntity(org.demo.documentation.widgets.picktreepopup.tree.Myexample3261 entity, Myexample3261Pick0DTO data,
	                                                                BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}