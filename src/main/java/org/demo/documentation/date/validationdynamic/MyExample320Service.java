package org.demo.documentation.date.validationdynamic;

import java.time.LocalDate;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample320Service extends VersionAwareResponseService<MyExample320DTO, MyEntity320> {

	private final MyEntity320Repository repository;

	public MyExample320Service(MyEntity320Repository repository) {
		super(MyExample320DTO.class, MyEntity320.class, null, MyExample320Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample320DTO> doCreateEntity(MyEntity320 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample320DTO> doUpdateEntity(MyEntity320 entity, MyExample320DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample320DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample320DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample320DTO> getActions() {
		return Actions.<MyExample320DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

	private void validateFields(BusinessComponent bc, MyExample320DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		LocalDate sysdate = LocalDate.now();
		if (dto.getCustomField() != null && sysdate.compareTo(dto.getCustomField()) > 0) {
			entity.addField(MyExample320DTO_.customField.getName(),
					"The field 'customField' cannot be less than the current date");
		}
		if (dto.getCustomField() != null && sysdate.compareTo(dto.getCustomFieldAdditional()) > 0) {
			entity.addField(
					MyExample320DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' cannot be less than the current date"
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}