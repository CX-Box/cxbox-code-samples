package org.demo.documentation.multipleselect.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.validationdynamic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class MyExample334Service extends VersionAwareResponseService<MyExample334DTO, MyEntity334> {

	private final MyEntity334Repository repository;

	public MyExample334Service(MyEntity334Repository repository) {
		super(MyExample334DTO.class, MyEntity334.class, null, MyExample334Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample334DTO> doCreateEntity(MyEntity334 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample334DTO> doUpdateEntity(MyEntity334 entity, MyExample334DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample334DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample334DTO_.customFieldAdditional)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample334DTO> getActions() {
		return Actions.<MyExample334DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample334DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		Boolean customFieldFlg = dto.getCustomField().getValues()
				.stream()
				.anyMatch(val ->
						CustomFieldEnum.HIGH.getValue().equals(val.getValue()));
		Boolean customFieldAdditionalFlg = dto.getCustomFieldAdditional().getValues()
				.stream()
				.anyMatch(val ->
						CustomFieldEnum.HIGH.getValue().equals(val.getValue()));
		if (Boolean.TRUE.equals(customFieldFlg)) {
			entity.addField(
					MyExample334DTO_.customField.getName(),
					"Custom message about error"
			);
		}
		if  (Boolean.TRUE.equals(customFieldAdditionalFlg)) {
			entity.addField(
					MyExample334DTO_.customFieldAdditional.getName(),
					"Custom message about error"
			);
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}