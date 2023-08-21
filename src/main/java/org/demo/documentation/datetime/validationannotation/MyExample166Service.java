package org.demo.documentation.datetime.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample166Service extends VersionAwareResponseService<MyExample166DTO, MyEntity166> {

	private final MyEntity166Repository repository;

	public MyExample166Service(MyEntity166Repository repository) {
		super(MyExample166DTO.class, MyEntity166.class, null, MyExample166Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample166DTO> doCreateEntity(MyEntity166 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample166DTO> doUpdateEntity(MyEntity166 entity, MyExample166DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample166DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample166DTO> getActions() {
		return Actions.<MyExample166DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}