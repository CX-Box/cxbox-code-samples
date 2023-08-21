package org.demo.documentation.text.validationdynamic;

import static org.cxbox.api.util.i18n.ErrorMessageSource.errorMessage;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample332Service extends VersionAwareResponseService<MyExample332DTO, MyEntity332> {

	private final MyEntity332Repository repository;


	public MyExample332Service(MyEntity332Repository repository) {
		super(MyExample332DTO.class, MyEntity332.class, null, MyExample332Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample332DTO> doCreateEntity(MyEntity332 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample332DTO> doUpdateEntity(MyEntity332 entity, MyExample332DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample332DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample332DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample332DTO> getActions() {
		return Actions.<MyExample332DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.action("check", "Check")
				.invoker((bc, dto) -> {
					validate(bc, dto);
					return new ActionResultDTO<>();
				})
				.add()
				.build();
	}

	private void validate(BusinessComponent bc, MyExample332DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample332DTO_.customField.getName(),
					errorMessage("The field 'customField' can contain only letters.")
			);
		}
		if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample332DTO_.customFieldAdditional.getName(),
					errorMessage("The field 'customFieldAdditional' can contain only letters.")
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}