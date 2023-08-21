package org.demo.documentation.hint.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample162Service extends VersionAwareResponseService<MyExample162DTO, MyEntity162> {

	private final MyEntity162Repository repository;

	public MyExample162Service(MyEntity162Repository repository) {
		super(MyExample162DTO.class, MyEntity162.class, null, MyExample162Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample162DTO> doCreateEntity(MyEntity162 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample162DTO> doUpdateEntity(MyEntity162 entity, MyExample162DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample162DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample162DTO> getActions() {
		return Actions.<MyExample162DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}