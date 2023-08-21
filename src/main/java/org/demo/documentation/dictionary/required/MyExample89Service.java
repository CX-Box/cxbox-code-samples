package org.demo.documentation.dictionary.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample89Service extends VersionAwareResponseService<MyExample89DTO, MyEntity89> {

	private final MyEntity89Repository repository;

	public MyExample89Service(MyEntity89Repository repository) {
		super(MyExample89DTO.class, MyEntity89.class, null, MyExample89Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample89DTO> doCreateEntity(MyEntity89 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample89DTO> doUpdateEntity(MyEntity89 entity, MyExample89DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample89DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample89DTO> getActions() {
		return Actions.<MyExample89DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}