package org.demo.documentation.input.validationdynamic;

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
public class MyExample326Service extends VersionAwareResponseService<MyExample326DTO, MyEntity326> {

	private final MyEntity326Repository repository;

	public MyExample326Service(MyEntity326Repository repository) {
		super(MyExample326DTO.class, MyEntity326.class, null, MyExample326Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample326DTO> doCreateEntity(MyEntity326 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample326DTO> doUpdateEntity(MyEntity326 entity, MyExample326DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample326DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample326DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample326DTO> getActions() {
		return Actions.<MyExample326DTO>builder()
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

	private void validate(BusinessComponent bc, MyExample326DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample326DTO_.customField.getName(),
					errorMessage("The field 'customField' can contain only letters.")
			);
		}
		if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample326DTO_.customFieldAdditional.getName(),
					errorMessage("The field 'customFieldAdditional' can contain only letters.")
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}