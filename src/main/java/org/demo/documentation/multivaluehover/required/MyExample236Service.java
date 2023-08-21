package org.demo.documentation.multivaluehover.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample236Service extends VersionAwareResponseService<MyExample236DTO, MyEntity236> {

	private final MyEntity236Repository repository;

	public MyExample236Service(MyEntity236Repository repository) {
		super(MyExample236DTO.class, MyEntity236.class, null, MyExample236Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample236DTO> doCreateEntity(MyEntity236 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample236DTO> doUpdateEntity(MyEntity236 entity, MyExample236DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample236DTO> getActions() {
		return Actions.<MyExample236DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}