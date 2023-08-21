package org.demo.documentation.picklist.validationdynamic;

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
public class MyExample330Service extends VersionAwareResponseService<MyExample330DTO, MyEntity330> {

	private final MyEntity330Repository repository;


	public MyExample330Service(MyEntity330Repository repository) {
		super(MyExample330DTO.class, MyEntity330.class, null, MyExample330Meta.class);
		this.repository = repository;


	}

	@Override
	protected CreateResult<MyExample330DTO> doCreateEntity(MyEntity330 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample330DTO> doUpdateEntity(MyEntity330 entity, MyExample330DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample330DTO> getActions() {
		return Actions.<MyExample330DTO>builder()
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

	private void validate(BusinessComponent bc, MyExample330DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample330DTO_.customField.getName(),
					errorMessage("The field 'customField' can contain only letters.")
			);
		}
		if (String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample330DTO_.customFieldAdditional.getName(),
					errorMessage("The field 'customFieldAdditional' can contain only letters.")
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}