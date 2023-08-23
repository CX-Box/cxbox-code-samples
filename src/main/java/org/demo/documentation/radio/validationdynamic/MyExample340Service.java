package org.demo.documentation.radio.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.radio.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample340Service extends VersionAwareResponseService<MyExample340DTO, MyEntity340> {

	private final MyEntity340Repository repository;

	public MyExample340Service(MyEntity340Repository repository) {
		super(MyExample340DTO.class, MyEntity340.class, null, MyExample340Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample340DTO> doCreateEntity(MyEntity340 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample340DTO> doUpdateEntity(MyEntity340 entity, MyExample340DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample340DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample340DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample340DTO> getActions() {
		return Actions.<MyExample340DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

	private void validateFields(BusinessComponent bc, MyExample340DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!CustomFieldEnum.HIGH.getValue().equals(dto.getCustomField().getValue())) {
			entity.addField(MyExample340DTO_.customField.getName(), "Custom message about error");
		}
		if (!CustomFieldEnum.HIGH.getValue().equals(dto.getCustomFieldAdditional().getValue())) {
			entity.addField(MyExample340DTO_.customFieldAdditional.getName(), "Custom message about error");
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}