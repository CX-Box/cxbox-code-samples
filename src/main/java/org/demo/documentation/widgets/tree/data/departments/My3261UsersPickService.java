package org.demo.documentation.widgets.tree.data.departments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.tree.data.users.My3261Users;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class My3261UsersPickService extends VersionAwareResponseService<My3261UsersPickDTO, My3261Users> {

	@Getter(onMethod_ = @Override)
	private final Class<My3261UsersPickMeta> meta = My3261UsersPickMeta.class;

	@Override
	protected CreateResult<My3261UsersPickDTO> doCreateEntity(My3261Users entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<My3261UsersPickDTO> doUpdateEntity(My3261Users entity, My3261UsersPickDTO data,
	                                                             BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}