package org.demo.documentation.fields.datetimewithseconds.validationdynamic;

import java.time.LocalDateTime;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample322Service extends VersionAwareResponseService<MyExample322DTO, MyEntity322> {

	private final MyEntity322Repository repository;


	public MyExample322Service(MyEntity322Repository repository) {
		super(MyExample322DTO.class, MyEntity322.class, null, MyExample322Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample322DTO> doCreateEntity(MyEntity322 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample322DTO> doUpdateEntity(MyEntity322 entity, MyExample322DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample322DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample322DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample322DTO> getActions() {
		return Actions.<MyExample322DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample322DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		LocalDateTime sysdate = LocalDateTime.now();
		if (dto.getCustomField() != null && sysdate.isAfter(dto.getCustomField())) {
			entity.addField(MyExample322DTO_.customField.getName(),
					"The field 'customField' cannot be less than the current date");
		}
		if (dto.getCustomField() != null && sysdate.isAfter(dto.getCustomFieldAdditional())) {
			entity.addField(
					MyExample322DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' cannot be less than the current date"
			);
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}