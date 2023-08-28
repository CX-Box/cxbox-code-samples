package org.demo.documentation.datetimewithseconds.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample167Service extends VersionAwareResponseService<MyExample167DTO, MyEntity167> {

	private final MyEntity167Repository repository;

	public MyExample167Service(MyEntity167Repository repository) {
		super(MyExample167DTO.class, MyEntity167.class, null, MyExample167Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample167DTO> doCreateEntity(MyEntity167 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample167DTO> doUpdateEntity(MyEntity167 entity, MyExample167DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample167DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample167DTO> getActions() {
		return Actions.<MyExample167DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}