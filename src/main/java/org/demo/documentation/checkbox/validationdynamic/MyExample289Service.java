package org.demo.documentation.checkbox.validationdynamic;

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
public class MyExample289Service extends VersionAwareResponseService<MyExample289DTO, MyEntity289> {

	private final MyEntity289Repository repository;


	public MyExample289Service(MyEntity289Repository repository) {
		super(MyExample289DTO.class, MyEntity289.class, null, MyExample289Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample289DTO> doCreateEntity(MyEntity289 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample289DTO> doUpdateEntity(MyEntity289 entity, MyExample289DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample289DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample289DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample289DTO> getActions() {
		return Actions.<MyExample289DTO>builder()
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

	private void validate(BusinessComponent bc, MyExample289DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (Boolean.FALSE.equals(dto.getCustomField())) {
			entity.addField(
					MyExample289DTO_.customField.getName(),
					errorMessage("The field 'customField' can contain only 'True")
			);
		}
		if (Boolean.FALSE.equals(dto.getCustomFieldAdditional())) {
			entity.addField(
					MyExample289DTO_.customFieldAdditional.getName(),
					errorMessage("The field 'customFieldAdditional' can contain only 'True")
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}