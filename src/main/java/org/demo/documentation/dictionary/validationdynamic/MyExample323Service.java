package org.demo.documentation.dictionary.validationdynamic;

import static org.cxbox.api.util.i18n.ErrorMessageSource.errorMessage;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.dictionary.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample323Service extends VersionAwareResponseService<MyExample323DTO, MyEntity323> {

	private final MyEntity323Repository repository;

	public MyExample323Service(MyEntity323Repository repository) {
		super(MyExample323DTO.class, MyEntity323.class, null, MyExample323Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample323DTO> doCreateEntity(MyEntity323 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample323DTO> doUpdateEntity(MyEntity323 entity, MyExample323DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample323DTO> getActions() {
		return Actions.<MyExample323DTO>builder()
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

	private void validate(BusinessComponent bc, MyExample323DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!dto.getCustomField().getValue().equals(CustomFieldEnum.HIGH.getValue())) {
			entity.addField(
					MyExample323DTO_.customField.getName(),
					errorMessage("The field 'customField' can contain only 'High'")
			);
		}
		if (!dto.getCustomFieldAdditional().getValue().equals(CustomFieldEnum.HIGH.getValue())) {
			entity.addField(
					MyExample323DTO_.customFieldAdditional.getName(),
					errorMessage("The field 'customFieldAdditional' can contain only 'High'")
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}