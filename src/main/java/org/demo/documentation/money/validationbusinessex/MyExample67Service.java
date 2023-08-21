package org.demo.documentation.money.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample67Service extends VersionAwareResponseService<MyExample67DTO, MyEntity67> {

	private final MyEntity67Repository repository;

	public MyExample67Service(MyEntity67Repository repository) {
		super(MyExample67DTO.class, MyEntity67.class, null, MyExample67Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample67DTO> doCreateEntity(MyEntity67 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample67DTO> doUpdateEntity(MyEntity67 entity, MyExample67DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample67DTO_.customField)) {
			if (data.getCustomField() < 100000) {
				throw new BusinessException().addPopup("The field 'customField' cannot be less than 100 000.00.");
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample67DTO> getActions() {
		return Actions.<MyExample67DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}