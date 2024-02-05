package org.demo.documentation.text.validationbusinessex;

import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample49Service extends VersionAwareResponseService<MyExample49DTO, MyEntity49> {

	private final MyEntity49Repository repository;

	public MyExample49Service(MyEntity49Repository repository) {
		super(MyExample49DTO.class, MyEntity49.class, null, MyExample49Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample49DTO> doCreateEntity(MyEntity49 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample49DTO> doUpdateEntity(MyEntity49 entity, MyExample49DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample49DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			if (StringUtils.isNotEmpty(data.getCustomField())
					&& !String.valueOf(data.getCustomField()).matches("[A-Za-z]+")
			) {
				throw new BusinessException().addPopup("The field  can contain only letters.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample49DTO> getActions() {
		return Actions.<MyExample49DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}