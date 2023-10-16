package org.demo.documentation.other.test;


import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample420Service extends VersionAwareResponseService<MyExample420DTO, MyEntity420> {

	private final MyEntity420Repository repository;


	public MyExample420Service(MyEntity420Repository repository) {
		super(MyExample420DTO.class, MyEntity420.class, null, MyExample420Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample420DTO> doCreateEntity(MyEntity420 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample420DTO> doUpdateEntity(MyEntity420 entity, MyExample420DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample420DTO_.customFieldForceActive2)) {
			entity.setCustomFieldForceActive2(data.getCustomFieldForceActive2());
		}
		if (data.isFieldChanged(MyExample420DTO_.customFieldForceActive3)) {
			entity.setCustomFieldForceActive3(data.getCustomFieldForceActive3());
		}
		if (data.isFieldChanged(MyExample420DTO_.customFieldForceActive)) {
			entity.setCustomFieldForceActive(data.getCustomFieldForceActive());
			entity.setCustomFieldForceActive2("New data 2");
			entity.setCustomField2("New data 2");
		}
		if (data.isFieldChanged(MyExample420DTO_.customField2)) {
			entity.setCustomField2(data.getCustomField2());
		}
		if (data.isFieldChanged(MyExample420DTO_.customField3)) {
			entity.setCustomField3(data.getCustomField3());
		}
		if (data.isFieldChanged(MyExample420DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			entity.setCustomField2("Test44");
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample420DTO> getActions() {
		return Actions.<MyExample420DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.action("check", "check")
				.invoker((bc, dto) -> {
					validateFields(bc, dto);
					return new ActionResultDTO<>();
				})
				.add()
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample420DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(MyExample420DTO_.customField.getName(), "The field 'customField' can contain only letters.");
		}
		if (!String.valueOf(dto.getCustomField2()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample420DTO_.customField2.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (!String.valueOf(dto.getCustomField3()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample420DTO_.customField3.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (!String.valueOf(dto.getCustomFieldForceActive()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample420DTO_.customFieldForceActive.getName(),
					"The field 'customField' can contain only letters."
			);
		}
		if (!String.valueOf(dto.getCustomField2()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample420DTO_.customFieldForceActive2.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (!String.valueOf(dto.getCustomField3()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample420DTO_.customFieldForceActive3.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}