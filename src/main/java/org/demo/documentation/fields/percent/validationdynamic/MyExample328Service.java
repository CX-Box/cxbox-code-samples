package org.demo.documentation.fields.percent.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample328Service extends VersionAwareResponseService<MyExample328DTO, MyEntity328> {

	private final MyEntity328Repository repository;


	public MyExample328Service(MyEntity328Repository repository) {
		super(MyExample328DTO.class, MyEntity328.class, null, MyExample328Meta.class);
		this.repository = repository;


	}

	@Override
	protected CreateResult<MyExample328DTO> doCreateEntity(MyEntity328 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample328DTO> doUpdateEntity(MyEntity328 entity, MyExample328DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample328DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample328DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample328DTO> getActions() {
		return Actions.<MyExample328DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample328DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (dto.getCustomField() < 5) {
			entity.addField(MyExample328DTO_.customField.getName(), "The field  cannot be less than 5%");
		}
		if (dto.getCustomField() < 5) {
			entity.addField(
					MyExample328DTO_.customFieldAdditional.getName(),
					"The field  cannot be less than 5%"
			);
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}