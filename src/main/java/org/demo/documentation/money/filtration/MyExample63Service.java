package org.demo.documentation.money.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample63Service extends VersionAwareResponseService<MyExample63DTO, MyEntity63> {

	private final MyEntity63Repository repository;

	public MyExample63Service(MyEntity63Repository repository) {
		super(MyExample63DTO.class, MyEntity63.class, null, MyExample63Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample63DTO> doCreateEntity(MyEntity63 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample63DTO> doUpdateEntity(MyEntity63 entity, MyExample63DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample63DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample63DTO> getActions() {
		return Actions.<MyExample63DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}